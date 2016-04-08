
import java.util.*;
import java.io.*;

class satisfiability{
  //Difficulty: 3.6
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, j;
    for (i = 0; i < t; i++){
      int vars = Rd.nextInt(), cls = Rd.nextInt();
      Clause[] clauses = new Clause[cls];
      int[] assignment = new int[vars];
      for (j = 0; j < cls; j++){
        clauses[j] = new Clause(Rd.nextLine());
      }
      bw.write(solve(clauses, assignment)?"satisfiable\n":"unsatisfiable\n");
    }
    bw.flush();
  }
  
  public static boolean solve(Clause[] clauses, int[] assignment){
    Stack<Integer> assigned = new Stack<Integer>(), decision = new Stack<Integer>();
    boolean sat = false;
    while (!sat){
      sat = true;
      boolean changed = true;
      while (changed){
        changed = false;
        for (int i = 0; i < clauses.length; i++){
          Clause c = clauses[i];
          c.update(assignment);
          if (!c.sat){
            sat = false;
            if (c.length == 0){
              if (decision.empty()){
                return false;
              }
              while (assigned.peek() != decision.peek()){
                int poped = assigned.pop();
                assignment[poped] = 0;
              }
              assignment[decision.pop()] = -1;
              changed = true;              
            }
            if (c.length == 1){
              c.unit_prop(assignment, assigned);
              changed = true;
            }
          }
        }
      }
      for (int i = 0; i < assignment.length; i++){
        if (assignment[i] == 0){
          assigned.push(i);
          decision.push(i);
          assignment[i] = 1;
          continue;
        }
      }
    }
    return true;
  }
  
}

class Clause{
  Set<Integer> c;
  int length;
  boolean sat;
  public Clause(String s){
    String[] line = s.split(" v ");
    c = new HashSet<Integer>();
    for (int i = 0; i < line.length; i++){
      String next = line[i];
      if (next.charAt(0) == '~'){
        c.add(-Integer.parseInt(next.substring(2)));
      } else {
        c.add(Integer.parseInt(next.substring(1)));
      }
    }
    length = c.size();
    sat = false;
  }
  
  public void update(int[] assignment){
    length = c.size();
    for (int i: c){
      int var = Math.abs(i) - 1;
      if (assignment[var] * i > 0){
        sat = true;
        return;
      }
      if (assignment[var] * i < 0){
        length--;
      }
    }
    if (length == 0)
      sat = false;
  }
  
  public void unit_prop(int[] assignment, Stack<Integer> assigned){
    if (length > 1)
      return;
    for (int i: c){
      int var = Math.abs(i) -1;
      if (assignment[var] == 0){
        assignment[var] = i/(var+1);
        assigned.push(var);
        sat = true;
        return;
      }
    }
    return;
  }
}
class Rd{
  static BufferedReader reader;
  static StringTokenizer tokenizer;
  
  static void init(InputStream input) {
    reader = new BufferedReader(new InputStreamReader(input));
    tokenizer = new StringTokenizer("");
  }
  
  static String next() throws IOException {
    while (!tokenizer.hasMoreTokens()) {
      tokenizer = new StringTokenizer(reader.readLine() );
    }
    return tokenizer.nextToken();
  }
  
  static String nextLine() throws IOException {
    if (!tokenizer.hasMoreTokens()){
      return reader.readLine();
    }
    StringBuilder s = new StringBuilder();
    while (tokenizer.hasMoreTokens()){
      s.append(tokenizer.nextToken()+" ");
    }
    String out = s.toString();
    return out.substring(0, out.length()-1);
  }
  
  static boolean hasMoreTokens() { 
    while (tokenizer == null || !tokenizer.hasMoreTokens()) { 
      String s = null; 
      try { 
        s = reader.readLine(); 
      } catch (IOException e) { 
        e.printStackTrace(); 
      } 
      if (s == null) 
        return false; 
      tokenizer = new StringTokenizer(s); 
    } 
    return true; 
  }
  
  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
  
  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }
  
  static long nextLong() throws IOException{
    return Long.parseLong(next());
  }
  
}