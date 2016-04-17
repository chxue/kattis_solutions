
import java.util.*;
import java.io.*;
import java.math.BigInteger;
class luckynumber{
  //Difficulty: 6.0
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    List<BigInteger> prev = new ArrayList<BigInteger>();
    int n = Rd.nextInt(), i;
    BigInteger ten = BigInteger.valueOf(10);
    if (n == 1)
      bw.write("9");
    else {
      for (i = 1; i < 10; i++){
        prev.add(BigInteger.valueOf(i));
      }
      for (i = 2; i <= n; i++){
        List<BigInteger> next = new ArrayList<BigInteger>();
        BigInteger num, bigI = BigInteger.valueOf(i);
        int unit;
        for (BigInteger n1: prev){
          if (i % 5 == 0){
            for (unit = 0; unit < 10; unit += 5){
              num = n1.multiply(ten).add(BigInteger.valueOf(unit));
              if (num.mod(bigI) == BigInteger.ZERO)
                next.add(num);
            }
          } else if (i % 2 == 0){
            for (unit = 0; unit < 10; unit += 2){
              num = n1.multiply(ten).add(BigInteger.valueOf(unit));
              if (num.mod(bigI) == BigInteger.ZERO)
                next.add(num);
            }
          } else {
            for (unit = 0; unit < 10; unit++){
              num = n1.multiply(ten).add(BigInteger.valueOf(unit));
              if (num.mod(bigI) == BigInteger.ZERO)
                next.add(num);
            }
          }
        }
        prev = next;
      }
      bw.write(Integer.toString(prev.size()));
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