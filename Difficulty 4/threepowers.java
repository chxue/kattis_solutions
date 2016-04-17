
import java.util.*;
import java.io.*;
import java.math.BigInteger;
class threepowers{
  //Difficulty: 3.1
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BigInteger n, one = BigInteger.ONE, two = BigInteger.valueOf(2), three = BigInteger.valueOf(3);
    
    while (!(n = new BigInteger(Rd.next())).equals(BigInteger.ZERO)){
      n = n.add(one.negate());
      List<BigInteger> res = new ArrayList<BigInteger>();
      BigInteger next = one;
      while (!n.equals(BigInteger.ZERO)){
        if (n.mod(two).equals(one)){
          res.add(next);
        }
        next = next.multiply(three);
        n = n.divide(two);
      }
      bw.write(res.toString().replace("[","{ ").replace("]"," }"));
      bw.newLine();
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