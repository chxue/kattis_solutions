
import java.util.*;
import java.io.*;

class getshorty{
  //Difficulty: 3.1
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    while (true){
      int n = Rd.nextInt(), m = Rd.nextInt(), i;
      List<List<Edge>> graph = new ArrayList<List<Edge>>();
      if (n == 0 && m == 0)
        break;
      for (i = 0; i < n; i++){
        graph.add(new ArrayList<Edge>());
      }
      for (i = 0; i < m; i++){
        int from = Rd.nextInt(), to = Rd.nextInt();
        double f = Rd.nextDouble();
        graph.get(from).add(new Edge(to, f));
        graph.get(to).add(new Edge(from, f));
      }
      Queue<Node> toVisit = new PriorityQueue<Node>();
      boolean[] visited = new boolean[n];
      toVisit.add(new Node(0, 1));
      while (toVisit.peek() != null){
        Node node = toVisit.poll();
        if (node.n == n-1){
          bw.write(String.format("%.4f\n", node.f));
          break;
        }
        if (!visited[node.n]){
          for (Edge e: graph.get(node.n)){
            if (!visited[e.to]){
              toVisit.add(new Node(e.to, node.f*e.f));
            }
          }
        }
        visited[node.n] = true;
      }
    }
    bw.flush();
  }
}

class Edge{
  int to;
  double f;
  public Edge(int t, double factor){
    to = t;
    f = factor;
  }
}

class Node implements Comparable<Node>{
  int n;
  double f;
  public Node(int num, double factor){
    n = num;
    f = factor;
  }
  
  public int compareTo(Node other){
    if (this.f == other.f)
      return 0;
    return this.f < other.f? 1: -1;
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