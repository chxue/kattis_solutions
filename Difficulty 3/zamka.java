
import java.util.*;
import java.io.*;

class zamka{
  //Difficulty: 2.7
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int l = Rd.nextInt(), d = Rd.nextInt(), x = Rd.nextInt(),  i;
    
    for (i = l; i <= d; i++){
      if (sumDigits(i) == x){
        bw.write(i + "\n");
        break;
      }
    }
    for (i = d; i >= l; i--){
      if (sumDigits(i) == x){
        bw.write(i + "\n");
        break;
      }
    }
    bw.flush();
  }
  
  public static int sumDigits(int n){
    int sum = 0;
    while (n != 0){
      sum += n%10;
      n/=10;
    }
    return sum;
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