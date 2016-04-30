
import java.util.*;
import java.io.*;

class digitsum{
  //Difficulty: 5.0
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt();
    while (t-- > 0){
      long a = Rd.nextLong(), b = Rd.nextLong();
      bw.write(sumTo(b) - sumTo(a-1) + "\n");
    }
    bw.flush();
  }
  
  public static long sumTo(long n){
    if (n < 0){
      return 0;
    }
    long sum = 0, div = 10, prev = 1, digit, rem;
    while (prev <= n){
      rem = n % div;
      digit = (n/prev)%10;
      sum += n/div * prev * 45;
      if (digit != 0)
        sum += (digit-1) * digit/2 * prev + digit * (n % prev + 1);
      prev = div;
      div *= 10;
    }
    return sum;
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