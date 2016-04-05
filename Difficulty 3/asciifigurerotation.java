import java.util.*;
import java.io.*;

class asciifigurerotation{
  //Difficulty: 2.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int h, l, i, j;
    boolean start = true;
    while ( (h = Rd.nextInt()) != 0){
      l = 0;
      if (start){
        start = false;
      } else {
        bw.newLine();
      }
      
      String[] lines = new String[h];
      for (i = 0; i < h; i++){
        lines[i] = Rd.nextLine();
        if (lines[i].length() > l){
          l = lines[i].length();
        }
      }
      char[][] rot = new char[l][h];
      for (i = 0; i < l; i++){
        Arrays.fill(rot[i], ' ');
      }
      for (i = 0; i < h; i++){
        for (j = 0; j < lines[i].length(); j++){
          rot[j][h-i-1] = rotate(lines[i].charAt(j));
        }
      }
      for (i = 0; i < l; i++){
        bw.write(trim(new String(rot[i])));
        bw.newLine();
      }
      
    }
      
    bw.flush();
  }
  
  public static String trim(String s){
    int i = s.length()-1;
    while (s.charAt(i) == ' ')
      i--;
    return s.substring(0, i+1);
  }
  public static char rotate(char c){
    if (c == '-')
      return '|';
    if (c == '|')
      return '-';
    return c;
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