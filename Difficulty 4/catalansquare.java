
import java.util.*;
import java.io.*;
import java.math.BigInteger;
class catalansquare{
  //Difficulty: 3.6
  public static BigInteger[] catalan = new BigInteger[5002];
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    catalan[0] = BigInteger.ONE;
    calcCatalan(5001);
    System.out.println(catalan[Rd.nextInt()+1]);
    bw.flush();
  }
  public static void calcCatalan(int n){
    BigInteger prev = catalan[0], four = BigInteger.valueOf(4), 
      num = BigInteger.valueOf(2), den = num;
    int i;
    for (i = 1; i <= n; i++){
      catalan[i] = prev.multiply(num).divide(den);
      prev = catalan[i];
      num = num.add(four);
      den = den.add(BigInteger.ONE);
      
    }
    return;
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