
import java.util.*;
import java.io.*;

class lawnmower{
  //Difficulty: 2.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      int nx = Rd.nextInt(), ny = Rd.nextInt(), i;
      double w = Rd.nextDouble();
      if (nx == 0 && ny == 0)
        break;
      double[] sx = new double[nx], sy = new double[ny];
      for (i = 0; i < nx; i++){
        sx[i] = Rd.nextDouble();
      }
      for (i = 0; i < ny; i++){
        sy[i] = Rd.nextDouble();
      }
      boolean yes = cover(sx, w, 75.0) && cover(sy, w, 100.0);
      bw.write(yes?"YES\n":"NO\n");
    }
    bw.flush();
  }
  
  public static boolean cover(double[] s, double w, double l){
    Arrays.sort(s);
    if (s[0] > w/2 || s[s.length-1] < l-w/2)
      return false;
    double last = s[0];
    for (int i = 1; i < s.length; i++){
      if (s[i] - last > w)
        return false;
      last = s[i];
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