
import java.util.*;
import java.io.*;

class skener{
  //Difficulty: 1.9
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int r = Rd.nextInt(), c = Rd.nextInt(), zr = Rd.nextInt(), zc = Rd.nextInt(), i, j, zi, zj;
    char[][] enlarged = new char[r * zr][c * zc];
    for (i = 0; i < r; i++){
      String line = Rd.nextLine();
      for (j = 0; j < line.length(); j++){
        char read = line.charAt(j);
        for (zi = 0; zi < zr; zi++){
          for (zj = 0; zj < zc; zj++){
            enlarged[i*zr+zi][j*zc+zj] = read;
          }
        }
      }
    }
    for (i = 0; i < enlarged.length; i++){
      bw.write(new String(enlarged[i]));
      bw.newLine();
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