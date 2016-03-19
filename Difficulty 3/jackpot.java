
import java.util.*;
import java.io.*;

class jackpot{
  //Difficulty: 2.6
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, j;
    for (i = 0; i < t; i++){
      int n = Rd.nextInt();
      long res = 1;
      for (j = 0; j < n; j++){
        if (res <= 1000000000)
          res = lcm(res, Rd.nextLong());
        else 
          Rd.nextLong();
      }
      if (res <= 1000000000)
        bw.write(res + "\n");
      else 
        bw.write("More than a billion.\n");
      
    }
    
    bw.flush();
  }
  
  public static long gcd(long a, long b){
    long temp;
    if (a > b){
      temp = a;
      a = b;
      b = temp;
    }
    while (a != 0){
      temp = b%a;
      b = a;
      a = temp;
    }
    return b;
  }
  
  public static long lcm(long a, long b){
    return a * b / gcd(a, b);
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
  
  static long nextLong() throws IOException{
    return Long.parseLong(next());
  }
  
  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }
}