
import java.util.*;
import java.io.*;

class modulararithmetic{
  //Difficulty: 2.6
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      long n = Rd.nextLong(), t = Rd.nextLong();
      if (n == 0 && t == 0)
        break;
      while (t-- > 0){
        long a = Rd.nextLong();
        char op = Rd.next().charAt(0);
        long b = Rd.nextLong();
        bw.write(compute(a, b, op, n) + "\n");
      }
    }
    bw.flush();
  }
  
  public static long compute(long a, long b, char op, long mod){
    if (op == '+')
      return (a + b)%mod;
    if (op == '-'){
      long res = a-b;
      if (res < 0)
        return res + mod;
      return res % mod;
    }
    if (op == '*')
      return (a * b)%mod;
    long inv = inverse(b, mod);
    if (inv == -1)
      return -1;
    return (a * inv)%mod;
  }
      
      
  
  public static long inverse(long a, long n){
    long t = 0, newt = 1, r = n, newr = a;
    while (newr != 0){
      long quotient = r/newr, tempt = t, tempr = r;
      t = newt;
      newt = tempt - quotient * newt;
      r = newr;
      newr = tempr - quotient * newr;
    }
    if (r > 1)
        return -1;
    if (t < 0)
      t += n;
    return t;
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