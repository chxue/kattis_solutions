
import java.util.*;
import java.io.*;

class bitbybit{
  //Difficulty: 3.2
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n, i;
    while ((n = Rd.nextInt()) != 0){
      int[] bits = new int[32];
      Arrays.fill(bits, -1);
      for (i = 0; i < n; i++){
        String op = Rd.next();
        int k1 = Rd.nextInt();
        if (op.equals("SET")){
          bits[k1] = 1;
        } else if (op.equals("CLEAR")){
          bits[k1] = 0;
        } else {
          int k2 = Rd.nextInt();
          if (op.equals("AND")){
            bits[k1] = and(bits[k1], bits[k2]);
          } else {
            bits[k1] = or(bits[k1], bits[k2]);
          }
        }
      }
      bw.write(toString(bits));
      bw.newLine();
    }
        
    bw.flush();
  }
  
  public static String toString(int[] bits){
    StringBuilder sb = new StringBuilder();
    for (int i: bits){
      if (i == -1)
        sb.append("?");
      else
        sb.append(i);
    }
    return sb.reverse().toString();
  }
  
  public static int and(int k1, int k2){
    if (k1 == 0 || k2 == 0)
      return 0;
    if (k1 == -1 || k2 == -1)
      return -1;
    return 1;
  }
  
  public static int or(int k1, int k2){
    if (k1 == 1 || k2 == 1)
      return 1;
    if (k1 == -1 || k2 == -1)
      return -1;
    return 0;
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