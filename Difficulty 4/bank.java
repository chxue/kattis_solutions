
import java.util.*;
import java.io.*;

class bank{
  //Difficulty: 3.5
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt(), close = Rd.nextInt(), i, t = 0, val = 0;
    Queue<Client> c = new PriorityQueue<Client>();
    Queue<Integer> received = new PriorityQueue<Integer>();
    for (i = 0; i < n; i++){
      c.add(new Client(Rd.nextInt(), Rd.nextInt()));
    }
    while (c.peek() != null){
      Client next = c.poll();
      if (next.t >= received.size()){
        received.add(next.v);
      } else if (next.v > received.peek()){
        received.poll();
        received.add(next.v);
      }
    }
    while (received.peek() != null){
      val += received.poll();
    }
    bw.write(Integer.toString(val));   
    bw.flush();
  }
  
  
}
class Client implements Comparable<Client>{
  int v, t;
  public Client(int val, int time){
    v = val;
    t = time;
  }
  
  public int compareTo(Client other){
    return this.t-other.t;
  }
}
class Rd {
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