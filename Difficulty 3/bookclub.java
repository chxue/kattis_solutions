
import java.util.*;
import java.io.*;

class bookclub{
  //Difficulty: 2.8
  //important lesson: contruct a flow network to solve this problem.
  //Dinic's Algorithm Introduction: https://www.youtube.com/watch?v=uM06jHdIC70
  //Dinic's Algorithm Implementation: https://sites.google.com/site/indy256/algo/dinic_flow
  
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt(), m = Rd.nextInt(),i;
    List<List<Edge>> graph = createGraph(2*n + 2);
    int source = 2*n, sink = 2*n+1;
    for (i = 0; i < n; i++){
      addEdge(graph, source, i, 1);
      addEdge(graph, i+n, sink, 1);
    }
    for (i = 0; i < m; i++){
      addEdge(graph, Rd.nextInt(), Rd.nextInt()+n, 1);
    }
    bw.write(maxFlow(graph, source, sink) == n? "YES":"NO");
    bw.flush();
  }
  static class Edge {
    int t, rev, cap, f;

    public Edge(int t, int rev, int cap) {
      this.t = t;
      this.rev = rev;
      this.cap = cap;
    }
  }

  public static List<List<Edge>> createGraph(int nodes) {
    List<List<Edge>> graph = new ArrayList<List<Edge>>();
    for (int i = 0; i < nodes; i++)
      graph.add(new ArrayList<Edge>());
    return graph;
  }

  public static void addEdge(List<List<Edge>> graph, int s, int t, int cap) {
    graph.get(s).add(new Edge(t, graph.get(t).size(), cap));
    graph.get(t).add(new Edge(s, graph.get(s).size() - 1, 0));
  }

  static boolean dinicBfs(List<List<Edge>> graph, int src, int dest, int[] dist) {
    Arrays.fill(dist, -1);
    dist[src] = 0;
    int[] Q = new int[graph.size()];
    int sizeQ = 0;
    Q[sizeQ++] = src;
    for (int i = 0; i < sizeQ; i++) {
      int u = Q[i];
      for (Edge e : graph.get(u)) {
        if (dist[e.t] < 0 && e.f < e.cap) {
          dist[e.t] = dist[u] + 1;
          Q[sizeQ++] = e.t;
        }
      }
    }
    return dist[dest] >= 0;
  }

  static int dinicDfs(List<List<Edge>> graph, int[] ptr, int[] dist, int dest, int u, int f) {
    if (u == dest)
      return f;
    for (; ptr[u] < graph.get(u).size(); ++ptr[u]) {
      Edge e = graph.get(u).get(ptr[u]);
      if (dist[e.t] == dist[u] + 1 && e.f < e.cap) {
        int df = dinicDfs(graph, ptr, dist, dest, e.t, Math.min(f, e.cap - e.f));
        if (df > 0) {
          e.f += df;
          graph.get(e.t).get(e.rev).f -= df;
          return df;
        }
      }
    }
    return 0;
  }

  public static int maxFlow(List<List<Edge>> graph, int src, int dest) {
    int flow = 0;
    int[] dist = new int[graph.size()];
    while (dinicBfs(graph, src, dest, dist)) {
      int[] ptr = new int[graph.size()];
      while (true) {
        int df = dinicDfs(graph, ptr, dist, dest, src, Integer.MAX_VALUE);
        if (df == 0)
          break;
        flow += df;
      }
    }
    return flow;
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