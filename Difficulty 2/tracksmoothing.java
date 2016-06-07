
import java.util.*;
import java.io.*;

class tracksmoothing{
  //Difficulty: 1.8
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt();
    double x, y, prevx = -1, prevy;
    while (t-- > 0){
      int r = Rd.nextInt(), n = Rd.nextInt(), i;
      Point[] points = new Point[n];
      double l = 0, circ = 2 * Math.PI * r;
      for (i = 0; i < n; i++)
        points[i] = new Point(Rd.nextDouble(), Rd.nextDouble());
      for (i = 0; i < n-1; i++)
        l += points[i].distance(points[i+1]);
      l += points[n-1].distance(points[0]);
      if (circ > l)
        bw.write("Not possible\n");
      else
        bw.write(1 - circ/l + "\n");
    }
    bw.flush();
  }
}

class Point{
  double x, y;
  public Point(double a, double b){
    x = a;
    y = b;
  }
  
  public double distance(Point other){
    double difx = x - other.x, dify = y - other.y;
    return Math.sqrt(difx*difx + dify*dify);
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