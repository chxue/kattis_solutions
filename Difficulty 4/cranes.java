
import java.util.*;
import java.io.*;

class cranes{
  //Difficulty: 3.4 
  static double MAX;
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt();
    while (t-- > 0){
      int n = Rd.nextInt(), i, j;
      Crane[] cranes = new Crane[n];
      MAX = 0;
      List<List<Integer>> g = new ArrayList<List<Integer>>();
      for (i = 0; i < n; i++){
        g.add(new ArrayList<Integer>());
        cranes[i] = new Crane(Rd.nextDouble(), Rd.nextDouble(), Rd.nextDouble());
      }
      for (i = 0; i < n-1; i++){
        for (j = i+1; j < n; j++){
          if (cranes[i].interfere(cranes[j]))
            g.get(i).add(j);
        }
      }
      dfs(cranes, g, 0, new int[n], 0);
      bw.write((long)MAX + "\n");
    }
    bw.flush();
  }
  
  public static void dfs(Crane[] cranes, List<List<Integer>> g, int index, int[] conflicts, double total){
    if (index == g.size()){
      if (total > MAX)
        MAX = total;
      return;
    }
    if (conflicts[index] != 0){
      dfs(cranes, g, index+1, conflicts, total);
      return;
    }
    Crane c = cranes[index];
    dfs(cranes, g, index+1, conflicts, total);
    total += c.r*c.r;
    List<Integer> adjacent = g.get(index++);
    
    for (int e: adjacent){
      conflicts[e]++;
    }
    dfs(cranes, g, index, conflicts, total);
    for (int e: adjacent){
      conflicts[e]--;
    }
    return;
  }
}
class Crane{
  double x, y, r;
  public Crane(double a, double b, double c){
    x = a;
    y = b;
    r = c;
  }
  
  public boolean interfere(Crane other){
    double xC = Math.abs(this.x-other.x), yC = Math.abs(this.y-other.y), rC = this.r + other.r;
    return rC*rC >= xC*xC+yC*yC;
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