
import java.util.*;
import java.io.*;
import java.math.BigInteger;

class anagramcounting{
  //Difficulty: 2.2
  public static BigInteger[] fact = new BigInteger[101];
  
  public static void main(String[] args) throws IOException{
    fact[0] = BigInteger.ONE;
    int i;
    BigInteger mult = BigInteger.ONE, res = BigInteger.ONE;
    for (i = 1; i < fact.length; i++){
      res = res.multiply(mult);
      mult = mult.add(BigInteger.ONE);
      fact[i] = res;
    }
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (Rd.hasMoreTokens()){
      String word = Rd.nextLine();
      int[] freq = new int[256];
      for (i = 0; i < word.length(); i++){
        freq[word.charAt(i)]++;
      }
      BigInteger ans = fact[word.length()];
      for (i = 'A'; i <= 'Z'; i++){
        ans = ans.divide(fact[freq[i]]);
      }
      for (i = 'a'; i <= 'z'; i++){
        ans = ans.divide(fact[freq[i]]);
      }
      bw.write(String.format("%s\n", ans));
      bw.flush();
    }
    bw.flush();
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