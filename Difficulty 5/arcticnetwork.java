
import java.util.*;
import java.io.*;

class arcticnetwork{
  //Difficulty: 4.9
  //important lesson: prim's algorithm. https://sites.google.com/site/indy256/algo/mst_prim_simple
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, j;
    while (t-- > 0){
      int p = Rd.nextInt(), s = Rd.nextInt();
      List<Point> outposts = new ArrayList<Point>();
      double[][] d = new double[s][s];
      for (i = 0; i < s; i++){
        outposts.add(new Point(Rd.nextDouble(), Rd.nextDouble()));
      }
      for (i = 0; i < s-1; i++){
        for (j = i; j < s; j++){
          d[i][j] = d[j][i] = dist(outposts.get(i), outposts.get(j));
        }
      }
      bw.write(String.format("%.2f\n",mstPrim(d, p-1)));
    }
    bw.flush();
  }
  
  public static double dist(Point p1, Point p2){
    double xDiff = p1.x-p2.x, yDiff = p1.y-p2.y;
    return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
  }
  
  
  public static double mstPrim(double[][] d, int k) {
    int n = d.length;
    double[] dist = new double[n];
    Queue<Double> added = new PriorityQueue<Double>(n, Collections.reverseOrder()); 
    Arrays.fill(dist, Double.MAX_VALUE);
    dist[0] = 0;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      int u = -1;
      for (int j = 0; j < n; j++) {
        if (!visited[j] && (u == -1 || dist[u] > dist[j]))
          u = j;
      }
      added.add(dist[u]);
      visited[u] = true;
      for (int j = 0; j < n; j++) {
        if (!visited[j] && dist[j] > d[u][j]) {
          dist[j] = d[u][j];
        }
      }
    }
    while (k-- > 0){
      added.poll();
    }
    return added.poll();
  }
}

class Point{
  double x, y;
  public Point(double x, double y){
    this.x = x;
    this.y = y;
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