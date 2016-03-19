
import java.util.*;
import java.io.*;

class textureanalysis{
  //Difficulty: 2.3
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = 1;
    while (true){
      String pattern = Rd.next();
      if (pattern.equals("END"))
        break;
      bw.write(String.format("%d %s\n", t++, solve(pattern)?"EVEN":"NOT EVEN"));
    }
    bw.flush();
  }
  
  public static boolean solve(String pattern){
    int space = -1, next = 0, i;
    for (i = 1;i < pattern.length(); i++){
      if (pattern.charAt(i) == '.'){
        next++;
      } else {
        if (space == -1){
          space = next;
        } else {
          if (space != next){
            return false;
          }
        }
        next = 0;
      }
    }
    return true;
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
  
  static long nextLong() throws IOException{
    return Long.parseLong(next());
  }
  
}