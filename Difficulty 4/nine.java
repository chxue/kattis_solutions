
import java.util.*;
import java.io.*;

class nine{
  //Difficulty: 3.1
  public static long[] results = new long[35334693];
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i;
    long d, res = 1;
    results[0] = 1;
    for (i = 1; i < 35334693; i++){
      res *= 9;
      res %= 1000000007;
      results[i] = res;
    }
    for (i = 0; i < t; i++){
      d = Rd.nextLong();
      bw.write(solve(d) + "\n");
    }
    bw.flush();
  }
  
  public static long solve(long d){
    d--;
    d %= 500000003;
    long res = 1, pow = d/35334693;
    while (pow-- > 0){
      res *= 21;
      res %= 1000000007;
    }
    res *= results[(int)(d%35334693)];
    res %= 1000000007;
    res *= 8;
    res %= 1000000007;
    return res;
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