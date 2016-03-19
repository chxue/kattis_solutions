
import java.util.*;
import java.io.*;

class ferryloading4{
  //Difficulty: 2.7
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, j;
    for (i = 0; i < t; i++){
      int l = Rd.nextInt()*100, n = Rd.nextInt(), load = 0, cnt = 0;
      Queue<Integer> left = new LinkedList<Integer>(), right = new LinkedList<Integer>();
      for (j = 0; j < n; j++){
        int car = Rd.nextInt();
        String bank = Rd.next();
        //System.out.format("Car: %d, Bank: %s, ShipAt: %s, Loaded: %d\n", car, bank, loc, load);
        if (bank.equals("left")){
          left.add(car);
        } else {
          right.add(car);
        }
      }
      
      while (left.peek() != null || right.peek() != null){
        //System.out.format("current count: %d, waiting: %d, %d\n", cnt, left.peek(), right.peek());
        if (cnt % 2 == 0){
          while (left.peek() != null && left.peek() + load <= l){
            load += left.poll();
          }
        } else {
          while (right.peek() != null && right.peek() + load <= l){
            load += right.poll();
          }
        }
        cnt++;
        load = 0;
      }
      bw.write(cnt + "\n");
    }
    bw.flush();
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