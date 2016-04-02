
import java.util.*;
import java.io.*;

class airconditioned{
  //Difficulty: 3.0
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), rooms = 0, i;
    Interval current = new Interval(0, -1);
    Queue<Interval> minions = new PriorityQueue<Interval>();
    for (i = 0; i < t; i++){
      minions.add(new Interval(Rd.nextInt(), Rd.nextInt()));
    }
    while (minions.peek() != null){
      Interval next = minions.poll();
      if (current.intersect(next).isEmpty()){
        current = next;
        rooms++;
      } else {
        current = current.intersect(next);
      }
    }
    bw.write(Integer.toString(rooms));
    bw.flush();
  }
}

class Interval implements Comparable<Interval>{
  int lower, upper;
  public Interval(int l, int u){
    lower = l;
    upper = u;
  }
  
  public Interval intersect(Interval other){
    int newL = Math.max(this.lower, other.lower),
      newU = Math.min(this.upper, other.upper);
    return new Interval(newL, newU);
  }
  
  public boolean isEmpty(){
    return lower > upper;
  }
  
  public int compareTo(Interval other){
    return this.lower - other.lower;
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