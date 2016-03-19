import java.util.*;
import java.io.*;

class artichoke{
  //Difficulty: 2.0
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int p = Rd.nextInt(), a = Rd.nextInt(), b = Rd.nextInt(),
      c = Rd.nextInt(), d = Rd.nextInt(), n = Rd.nextInt();
    double high = 0, maxDiff = 0;
    if (n > 1){
      for (int i = 1; i <= n; i++){
        double price = p * (Math.sin(a*i+b) + Math.cos(c*i+d)+2);
        if (price > high){
          high = price;
        } else {
          double diff = high - price;
          if (diff > maxDiff)
            maxDiff = diff;
        }
      }
    }
    bw.write(String.format("%.6f",maxDiff));
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
}