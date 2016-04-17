
import java.util.*;
import java.io.*;

class thebackslashproblem{
  //Difficulty: 3.3
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (Rd.hasMoreTokens()){
      int l = Rd.nextInt(), i;
      if (l == 0){
        bw.write(Rd.nextLine());
      } else {
        char[] inserted = new char[(int)Math.pow(2,l)-1], line = Rd.nextLine().toCharArray();
        Arrays.fill(inserted, '\\');
        String s = new String(inserted);
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < line.length; i++){
          char c = line[i];
          if ((c >= '!' && c <= '*')||(c >= '[' && c <= ']')){
            sb.append(s);
          }
          sb.append(c);
        }
        bw.write(sb.toString());
      }
      bw.newLine();
      //bw.flush();
    }
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