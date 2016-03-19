
import java.util.*;
import java.io.*;

class kastenlauf{
  //Difficulty: 3.3
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), n, i, j;
    for (i = 0; i < t; i++){
      n = Rd.nextInt();
      Point[] points = new Point[n+2];
      boolean[] reached = new boolean[n+2];
      reached[0] = true;
      for (j = 0; j < n+2; j++){
        points[j] = new Point(Rd.nextInt(), Rd.nextInt());
      }
      dfs(points, reached, 0);
      bw.write(reached[n+1]?"happy\n":"sad\n");
    }
    bw.flush();
  }
  
  public static void dfs(Point[] points, boolean[] reached, int cur){
    for (int i = 0; i < points.length; i++){
      if (!reached[i]){
        if (points[cur].reach(points[i])){
          reached[i] = true;
          dfs(points, reached, i);
        }
      }
    }
    return;
  }
}

class Point{
  int x, y;
  public Point(int xcor, int ycor){
    x = xcor;
    y = ycor;
  }
  
  public int dist(Point other){
    return (int)(Math.abs(this.x-other.x) + Math.abs(this.y-other.y));
  }
  
  public boolean reach(Point other){
    return this.dist(other) <= 1000;
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