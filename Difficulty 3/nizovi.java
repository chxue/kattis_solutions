
import java.util.*;
import java.io.*;

class nizovi{
  //Difficulty: 2.8
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = Rd.nextLine();
    int i, j, spaces = 0;
    boolean nextLine = false;
    for (i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if (c == ','){
        bw.write(c);
        nextLine = true;
      } else if (c < 'a' || c > 'z'){
        if (c == '{'){
          spaces += 2;
        } else if (c == '}'){
          spaces -= 2;
          if (!nextLine){
            bw.newLine();
            for (j = 0; j < spaces; j++)
              bw.write(' ');
          }
        }
        if (nextLine){
          bw.newLine();
          int start = 0;
          if (c == '{')
            start += 2;
          for (j = start; j < spaces; j++)
            bw.write(' ');
          nextLine = false;
        }
        bw.write(c);
        nextLine = true;
      } else {
        if (nextLine){
          bw.newLine();
          for (j = 0; j < spaces; j++)
            bw.write(' ');
          nextLine = false;
        }
        bw.write(c);
      }
    }
    bw.newLine();
    bw.flush();
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