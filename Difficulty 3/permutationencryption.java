
import java.util.*;
import java.io.*;

class permutationencryption{
  //Difficulty: 2.8
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n, i, j;
    while ((n = Rd.nextInt()) != 0){
      int[] seq = new int[n];
      for (i = 0; i < n; i++){
        seq[i] = Rd.nextInt()-1;
      }
      String msg = Rd.nextLine();
      StringBuilder sb = new StringBuilder();
      i = 0;
      while (i < msg.length()){
        for (j = 0; j < n; j++){
          sb.append(charAt(msg, i+seq[j]));
        }
        i += n;
      }
      bw.write('\'');
      bw.write(sb.toString());
      bw.write('\'');
      bw.newLine();
    }
    bw.flush();
  }
  
  public static char charAt(String s, int i){
    if (i >= s.length())
      return ' ';
    return s.charAt(i);
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