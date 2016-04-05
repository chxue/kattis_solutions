
import java.util.*;
import java.io.*;

class color{
  //Difficulty: 2.6
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int s = Rd.nextInt(), c = Rd.nextInt(), k = Rd.nextInt(), i;
    Queue<Integer> socks = new PriorityQueue<Integer>();
    for (i = 0; i < s; i++){
      socks.add(Rd.nextInt());
    }
    int numMachines = 0, currentCap = 0, maxColor = -1;
    while (socks.peek() != null){
      int next = socks.poll();
      if (currentCap == c || next > maxColor){
        numMachines++;
        currentCap = 1;
        maxColor = next + k;
      } else {
        currentCap++;
      }
    }
    bw.write(Integer.toString(numMachines));
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