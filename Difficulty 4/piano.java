
import java.util.*;
import java.io.*;

class piano{
  //Difficulty: 3.7
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt();
    while (t-- > 0){
      int m = Rd.nextInt(), p = Rd.nextInt()/2,  i;
      List<Interval> input = new ArrayList<Interval>();
      while (m-- > 0){
        input.add(new Interval(Rd.nextInt()-1, Rd.nextInt()-1));
      }
      //System.out.println(tasks);
      if (solve(init(input, 0), p, 0))
        bw.write("fine\n");
      else if (solve(init(input, 1), p, 1))
        bw.write("weekend work\n");
      else
        bw.write("serious trouble\n");
    }
    bw.flush();
  }
  
  public static List<Queue<Interval>> init(List<Interval> input, int type){
    List<Queue<Interval>> tasks = new ArrayList<Queue<Interval>>();
    for (int i = 0; i < 100; i++){
      tasks.add(new PriorityQueue<Interval>());
    }
    for (Interval it: input){
      tasks.get(nextAvailable(it.s, type)).add(it);
    }
    return tasks;
  }
  
  public static boolean solve(List<Queue<Interval>> tasks, int p, int type){
    int i = 0, next, j;
    while (i < 100){
      
      next = nextDay(i, type);
      Queue<Interval> q = tasks.get(i);
      int n = Math.min(p, q.size());
      for (j = 0; j < n; j++){
        if (q.poll().e < i)
          return false;
      }
      if (i == 99 && q.peek() != null)
        return false;
      while (q.peek() != null)
        tasks.get(next).add(q.poll());
      i = next;
    }
    return true;
  }
  public static int nextDay(int today, int type){
    if (type == 1)
      return today+1;
    if (today % 7 == 4)
      return today+3;
    return today+1;
  }
  public static int nextAvailable(int today, int type){
    if (type == 1)
      return today;
    if (today % 7 == 5)
      return today + 2;
    if (today % 7 == 6)
      return today + 1;
    return today;
  }
}
  
class Interval implements Comparable<Interval>{
  int s, e;
  public Interval(int a, int b){
    s = a;
    e = b;
  }
  
  public int compareTo(Interval other){
    return this.e - other.e;
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