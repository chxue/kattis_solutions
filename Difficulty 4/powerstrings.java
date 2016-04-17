
import java.util.*;
import java.io.*;

class powerstrings{
  //Difficulty: 3.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s;
    while (!(s = Rd.next()).equals(".")){
      bw.write(s.length()/longestRepeat(s) + "\n");
    }
    bw.flush();
  }
  
  public static int longestRepeat(String s){
    int i, start = 0, end = 0;
    for (i = 1; i < s.length(); i++){
      if (s.charAt(i) == s.charAt(0)){
        end = i;
        break;
      }
    }
    if (end == 0){
      return s.length();
    }
    for (i = end; i < s.length(); i++){
      if (start == end){
        start = 0;
      }
      if (s.charAt(start) == s.charAt(i)){
        start++;
      } else {
        while (i < s.length() && s.charAt(i) != s.charAt(0))
          i++;
        end = i;
        start = 1;
      }
    }
    return end;
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