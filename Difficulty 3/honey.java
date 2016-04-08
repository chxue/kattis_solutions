
import java.util.*;
import java.io.*;

class honey{
  //Difficulty: 2.8
  public static long[][][] walks = new long[29][29][15];
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, j, k;
    for (i = 0; i < 29; i++){
      for (j = 0; j < 29; j++){
        for (k = 1; k < 15; k++){
          walks[i][j][k] = -1;
        }
      }
    }
    walks[14][14][0] = 1;
    for (i = 0; i < t; i++){
      int n = Rd.nextInt();
      bw.write(w(14,14,n) + "\n");
    }
    bw.flush();
  }
  
  public static long w(int x, int y, int s){
    if (s == 0 || walks[x][y][s] != -1)
      return walks[x][y][s];
    long res = w(x,y-1,s-1) + w(x+1,y-1,s-1) + w(x-1,y,s-1) + w(x+1,y,s-1) + w(x-1,y+1,s-1) + w(x,y+1,s-1);
    walks[x][y][s] = res;
    return res;
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