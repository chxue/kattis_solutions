import java.util.*;
import java.io.*;
class pivot{
  //Difficulty: 3.2
  public static void main(String[] args){
    Rd.init(System.in);
    try{
      int n = Rd.nextInt(), lastMax = -1*Integer.MAX_VALUE, queueSize = 0;
      Queue<Integer> pivots = new PriorityQueue<Integer>(n, Collections.reverseOrder());
      for (int i = 0; i < n; i++){
        int next = Rd.nextInt();
        if (next >= lastMax){
          lastMax = next;
          pivots.add(next);
          queueSize++;
        }
        while (pivots.peek() != null && pivots.peek() > next){
          pivots.poll();
          queueSize--;
        }
      }
      System.out.println(queueSize);
    } catch (IOException e){
      System.exit(-1);
    }
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

  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
  
  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }
}