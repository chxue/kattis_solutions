
import java.util.*;
import java.io.*;

class modulo{
  //Difficulty: 1.3 
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Set<Integer> remainders = new HashSet<Integer>();
    for (int i = 0; i < 10; i++){
      remainders.add(Rd.nextInt()%42);
    }
    bw.write(Integer.toString(remainders.size()));
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