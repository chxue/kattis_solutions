
import java.util.*;
import java.io.*;

class minspantree{
  //Difficulty: 4.2
  //Kruskal's Algorithm. Prim's algorithm is faster but uses more complicated data structures.
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int i;
    while (true){
      int n = Rd.nextInt(), m = Rd.nextInt();
      if (n == 0 && m == 0)
        break;
      
      Queue<Edge> edges = new PriorityQueue<Edge>(m+1, new WeightComparator());
      List<Edge> minSpanTree = new ArrayList<Edge>();
      int[] head = new int[n];
      for (i = 0; i < n; i++){
        head[i] = i;
      }
      long weight = 0;
      for (i = 0; i < m; i++){
        edges.add(new Edge(Rd.nextInt(), Rd.nextInt(), Rd.nextInt()));
      }
      if (m < n-1){
        bw.write("Impossible\n");
        continue;
      }
      while (edges.peek() != null){
        Edge e = edges.poll();
        if (!find(head, e.u, e.v)){
          union(head, e.u, e.v);
          minSpanTree.add(e);
          weight += e.w;
        }
      }
      int h = getHead(head, 0);
      boolean possible = true;
      for (i = 0; i < n; i++){
        if (getHead(head, i) != h){
          bw.write("Impossible\n");
          possible = false;
          break;
        }
      }
      if (possible) {
        bw.write(weight + "\n");
        Collections.sort(minSpanTree, new LexComparator());
        for (Edge e: minSpanTree){
          bw.write(String.format("%d %d\n", e.u, e.v));
        }
      }
        
    }
    bw.flush();
  }
  
  public static class WeightComparator implements Comparator<Edge>{
    public int compare(Edge e1, Edge e2){
      return e1.w - e2.w;
    }
  }
  
  public static class LexComparator implements Comparator<Edge>{
    public int compare(Edge e1, Edge e2){
      if (e1.u < e2.u)
        return -1;
      if (e1.u > e2.u)
        return 1;
      return e1.v - e2.v;
    }
  }
  
  public static void union(int[] head, int a, int b){
    int aHead = getHead(head, a), bHead = getHead(head, b);
    if (aHead != bHead)
        head[aHead] = bHead;
  }
  
  public static boolean find(int[] head, int a, int b){
    return getHead(head, a) == getHead(head, b);
  }
  
  public static int getHead(int[] head, int i){
    while (head[i] != i){
      head[i] = head[head[i]];
      i = head[i];
    }
    return i;
  }
}

class Edge{
  int u, v, w;
  public Edge(int u, int v, int w){
    if (u > v){
      int temp = u;
      u = v;
      v = temp;
    }
    this.u = u;
    this.v = v;
    this.w = w;
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