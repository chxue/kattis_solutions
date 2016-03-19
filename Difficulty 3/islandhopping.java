import java.util.*;
import java.io.*;

class islandhopping{
  //Difficulty: 2.1
  //important lesson: Kruskal's algorithm (priorityQueue + DSF)
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt();
    for (int i = 0; i < t; i++){
      int n = Rd.nextInt();
      double[][] islands = new double[n][2];
      for (int j = 0; j < n; j++){
        islands[j][0] = Rd.nextDouble();
        islands[j][1] = Rd.nextDouble();
      }
      bw.write(String.format("%.3f\n",solve(islands, n)));
    }
    bw.flush();
  }
  
  public static double solve(double[][] islands, int n){
    int[] head = new int[n];
    for (int i = 0;i < n; i++){
      head[i] = i;
    }
    
    Queue<Edge> q = new PriorityQueue<Edge>();
    for (int i = 0; i < n-1; i++){
      for (int j = i+1; j < n; j++){
        double xDiff = islands[i][0] - islands[j][0],
          yDiff = islands[i][1] - islands[j][1];
        q.add(new Edge(i, j, Math.sqrt(xDiff*xDiff + yDiff*yDiff)));
      }
    }
    double total = 0.0;
    for (int i = 0; i < n-1; i++){
      boolean added = false;
      while (!added){
        Edge e = q.poll();
        if (head[e.v1] != head[e.v2]){
          union(head, head[e.v1], head[e.v2]);
          added = true;
          total += e.len;
        }
      }
    }
    return total;
  }
  
  public static void union(int[] head, int h1, int h2){
    for (int i = 0; i < head.length; i++){
      if (head[i] == h2)
        head[i] = h1;
    }
    return;
  }
}

class Edge implements Comparable<Edge>{
  int v1, v2;
  double len;
  public Edge(int u, int v, double length){
    v1 = u;
    v2 = v;
    len = length;
  }
  
  public int compareTo(Edge other){
    if (this.len < other.len)
      return -1;
    if (this.len == other.len)
      return 0;
    return 1;
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
}