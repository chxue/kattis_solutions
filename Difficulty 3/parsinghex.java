
import java.util.*;
import java.io.*;

class parsinghex{
  //Difficulty: 2.6
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int i;
    while (Rd.hasMoreTokens()){
      String line = Rd.next();
      for (i = 0; i < line.length() - 2; i++){
        if (line.charAt(i) == '0' && Character.toLowerCase(line.charAt(i+1)) == 'x'){
          int end = getEnd(line, i);
          String s = line.substring(i, end);
          bw.write(String.format("%s %d\n", s, Long.parseLong(s.substring(2), 16)));
          bw.flush();
        }
      }
    }
    bw.flush();
  }
  
  public static int getEnd(String s, int start){
    start += 2;
    while (start < s.length()){
      char c = s.charAt(start);
      if ((c <= 'F' && c >= 'A') || (c <= '9' && c >= '0') || (c <= 'f' && c >= 'a')){
        start++;
      } else {
        break;
      }
    }
    return start;
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