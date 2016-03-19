
import java.util.*;
import java.io.*;

class irepeatmyself{
  //Difficulty: 3.0
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i;
    for (i = 0; i < t; i++){
      String line = Rd.nextLine();
      bw.write(solve(line) + "\n");
    }
    bw.flush();
  }
  
  public static int solve(String s){
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
    //System.out.println("end is: " + end);
    for (i = end; i < s.length(); i++){
      if (start == end){
        start = 0;
      }
      //System.out.println(s.charAt(start) + "---" + s.charAt(i));
      if (s.charAt(start) == s.charAt(i)){
        start++;
      } else {
        //System.out.println("end updated to " + i);
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