
import java.util.*;
import java.io.*;

class enlarginghashtables{
  //Difficulty: 3.6
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n, i;
    while ((n = Rd.nextInt()) != 0){
      boolean prime = isPrime(n);
      i = 2*n+1;
      while (!isPrime(i)){
        i++;
      }
      bw.write(String.format("%d%s", i, prime?"\n":String.format(" (%d is not prime)\n", n)));
    }
    bw.flush();
  }
  
  public static boolean isPrime(long n){
    if (n % 2 == 0)
      return n == 2;
    if (n % 3 == 0)
      return n == 3;
    for (long i = 5; i * i <= n; i += 6){
      if (n % i == 0)
        return false;
    }
    for (long i = 7; i * i <= n; i += 6){
      if (n % i == 0)
        return false;
    }
    return true;
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