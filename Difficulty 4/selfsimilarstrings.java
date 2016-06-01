
import java.util.*;
import java.io.*;

class selfsimilarstrings{
  //Difficulty: 3.6
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s;
    while (Rd.hasMoreTokens()){
      s = Rd.nextLine();
      bw.write(solve(s) + "\n");
    }
    bw.flush();
  }
  
  public static int solve(String s){
    int l, i, j, k, id;
    boolean match;
    l = s.length();
    int[][] dp = new int[l-1][l];
    id = 1;
    for (i = 0; i < l-1; i++){
      for (j = 0; j < l-i; j++){
        if (dp[i][j]== 0){
          dp[i][j] = id;
          match = false;
          for (k = j+1; k < l-i; k++){
            if (i == 0 || dp[i-1][j] == dp[i-1][k]){
              if (s.charAt(j+i) == s.charAt(k+i)){
                dp[i][k] = id;
                match = true;
              }
            }
          }
          id++;
          if (match == false)
            return i;
        }
      }
    }
    return l-1;
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