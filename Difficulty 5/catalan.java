
import java.util.*;
import java.io.*;
import java.math.BigInteger;
class catalan{
  //Difficulty: 4.2
  //important lesson: math.BigInteger!
  public static BigInteger[] catalan = new BigInteger[5001];
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    catalan[0] = BigInteger.ONE;
    calcCatalan(5000);
    int t = Rd.nextInt(), i;
    for (i = 0; i < t; i++){
      out.write(String.format("%s\n", catalan[Rd.nextInt()]));
    }
    out.flush();
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
  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
  
  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }
}