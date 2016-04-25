
import java.util.*;
import java.io.*;

class palindromesubstring{
  //Difficulty: 3.5
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (Rd.hasMoreTokens()){
      String s = Rd.nextLine();
      Set<String> ans = palindromeStrings(s);
      for (String substring: ans){
        bw.write(substring);
        bw.newLine();
      }
      bw.newLine();
      bw.flush();
    }
    bw.flush();
  }
  
  public static Set<String> palindromeStrings(String s){
    Set<String> res = new TreeSet<String>();
    int i, l = s.length(), left, right1, right2;
    for (i = 1; i < l; i++){
      left = i-1;
      right1 = i;
      while (left >= 0 && right1 < l && s.charAt(left--) == s.charAt(right1++)){
        res.add(s.substring(left+1, right1));
      }
      left = i-1;
      right2 = i+1;
      while (left >= 0 && right2 < l && s.charAt(left--) == s.charAt(right2++)){
        res.add(s.substring(left+1, right2));
      }
    }
    return res;
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