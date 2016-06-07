
import java.util.*;
import java.io.*;

class rectanglesurrounding{
  //Difficulty: 
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n, x, y;
    while ((n = Rd.nextInt()) != 0){
      int[][] boundary = new int[1000][2];
      boolean[][] covered = new boolean[1000][1000];
      for (x = 0; x < 1000; x++){
        boundary[x][0] = 1000;
      }
      int sum = 0;
      while (n-- > 0){
        int lx = Rd.nextInt(), ly = Rd.nextInt(), 
          ux = Rd.nextInt(), uy = Rd.nextInt();
        for (x = lx; x < ux; x++){
          for (y = ly; y < uy; y++){
            if (!covered[x][y]){
              covered[x][y] = true;
              sum++;
            }
          }
        }
      }
      
      bw.write(sum + "\n");
      
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