
import java.util.*;
import java.io.*;

class shortestpath1{
  //Difficulty: 3.2
  //important lesson: using first 4 bytes to store distance and last 4 bytes to store vertex
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    boolean start = true;
    while (true){
      int n = Rd.nextInt(), m = Rd.nextInt(), q = Rd.nextInt(), s = Rd.nextInt(), i, j;
      if (n == 0)
        break;
      if (start){
        start = false;
      } else {
        bw.newLine();
      }
      List<List<Edge>> edges = new ArrayList<List<Edge>>();
      for (i = 0; i < n; i++){
        edges.add(new ArrayList<Edge>());
      }
      for (i = 0; i < m; i++){
        edges.get(Rd.nextInt()).add(new Edge(Rd.nextInt(), Rd.nextInt()));
      }
      int[] prio = new int[n];
      shortestPaths(edges, s, prio);
      for (i = 0;i < q; i++){
        int res = prio[Rd.nextInt()];
        bw.write(res == Integer.MAX_VALUE? "Impossible\n": res + "\n");
      }
    }
    bw.flush();
  }
  
  public static class Edge {
    int t, cost;

    public Edge(int t, int cost) {
      this.t = t;
      this.cost = cost;
    }
  }
  
  public static void shortestPaths(List<List<Edge>> edges, int s, int[] prio) {
    Arrays.fill(prio, Integer.MAX_VALUE);
    prio[s] = 0;
    PriorityQueue<Long> q = new PriorityQueue<Long>();
    q.add((long) s);
    while (!q.isEmpty()) {
      long cur = q.remove();
      int curu = (int) cur;
      if (cur >>> 32 != prio[curu])
        continue;
      for (Edge e : edges.get(curu)) {
        int v = e.t;
        int nprio = prio[curu] + e.cost;
        if (prio[v] > nprio) {
          prio[v] = nprio;
          q.add(((long) nprio << 32) + v);
        }
      }
    }
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