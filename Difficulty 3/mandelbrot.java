
import java.util.*;
import java.io.*;

class mandelbrot{
  //Difficulty: 2.5
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = 1;
    while (Rd.hasMoreTokens()){
      String[] line = Rd.nextLine().split(" ");
      double x = Double.parseDouble(line[0]), y = Double.parseDouble(line[1]);
      int it = Integer.parseInt(line[2]);
      Complex c = new Complex();
      while (it-- > 0 && !c.diverge()){
        c.next(x, y);
      }      
      bw.write(String.format("Case %d: %s", t++, c.diverge()?"OUT":"IN"));
      bw.newLine();
    }
    bw.flush();
  }
}
class Complex{
  double x, y;
  public Complex(){
    x = 0;
    y = 0;
  }
  
  public boolean diverge(){
    return x*x + y*y > 4;
  }
  
  public void next(double x0, double y0) {
    double temp = x;
    x = x*x-y*y+x0;
    y = 2*temp*y+y0;
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