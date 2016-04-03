
import java.util.*;
import java.io.*;

class loowater{
  //Difficulty: 2.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      int n = Rd.nextInt(), m = Rd.nextInt(), sum = 0, i;
      if (n == 0 && m == 0){
        break;
      }
      Queue<Integer> heads = new PriorityQueue<Integer>(), knights = new PriorityQueue<Integer>();
      for (i = 0; i < n; i++){
        heads.add(Rd.nextInt());
      }
      for (i = 0; i < m; i++){
        knights.add(Rd.nextInt());
      }
      while (heads.peek()!= null && knights.peek()!=null){
        if (knights.peek() >= heads.peek()){
          sum += knights.poll();
          heads.poll();
        } else {
          knights.poll();
        }
      }
      if (heads.peek() != null){
        bw.write("Loowater is doomed!\n");
      } else {
        bw.write(sum + "\n");
      }
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