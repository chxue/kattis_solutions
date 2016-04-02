
import java.util.*;
import java.io.*;

class gopher2{
  //Difficulty: 3.2
  //important lesson: Edmond's blossom algorithm for matching. https://sites.google.com/site/indy256/algo/edmonds_matching
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (sc.hasNextInt()){
      int n = sc.nextInt(), m = sc.nextInt(), d = sc.nextInt() * sc.nextInt(), d2 = d*d, i, j;
      Point[] gophers = new Point[n], holes = new Point[m];
      List<List<Integer>> graph = new ArrayList<List<Integer>>();
      for (i = 0; i < n+m; i++){
        graph.add(new ArrayList<Integer>());
      }
      for (i = 0; i < n; i++){
        gophers[i] = new Point(sc.nextDouble(), sc.nextDouble());
      }
      for (i = 0; i < m; i++){
        holes[i] = new Point(sc.nextDouble(), sc.nextDouble());
      }
      for (i = 0; i < n; i++){
        for (j = 0; j < m; j++){
          if (gophers[i].dist2(holes[j]) <= d2){
            graph.get(i).add(n+j);
            graph.get(n+j).add(i);
          }
        }
      }
      bw.write((n - maxMatching(graph)) + "\n");
    }
    bw.flush();
  }
  
  public static class Point{
    double x, y;
    public Point(double x, double y){
      this.x = x;
      this.y = y;
    }
    
    public double dist2(Point other){
      double xDif = this.x - other.x,
        yDif = this.y - other.y;
      return xDif*xDif + yDif*yDif;
    }
  }
  
  static int lca(int[] match, int[] base, int[] p, int a, int b) {
    boolean[] used = new boolean[match.length];
    while (true) {
      a = base[a];
      used[a] = true;
      if (match[a] == -1) break;
      a = p[match[a]];
    }
    while (true) {
      b = base[b];
      if (used[b]) return b;
      b = p[match[b]];
    }
  }

  static void markPath(int[] match, int[] base, boolean[] blossom, int[] p, int v, int b, int children) {
    for (; base[v] != b; v = p[match[v]]) {
      blossom[base[v]] = blossom[base[match[v]]] = true;
      p[v] = children;
      children = match[v];
    }
  }

  static int findPath(List<List<Integer>> graph, int[] match, int[] p, int root) {
    int n = graph.size();
    boolean[] used = new boolean[n];
    Arrays.fill(p, -1);
    int[] base = new int[n];
    for (int i = 0; i < n; ++i)
      base[i] = i;

    used[root] = true;
    int qh = 0;
    int qt = 0;
    int[] q = new int[n];
    q[qt++] = root;
    while (qh < qt) {
      int v = q[qh++];

      for (int to : graph.get(v)) {
        if (base[v] == base[to] || match[v] == to) continue;
        if (to == root || match[to] != -1 && p[match[to]] != -1) {
          int curbase = lca(match, base, p, v, to);
          boolean[] blossom = new boolean[n];
          markPath(match, base, blossom, p, v, curbase, to);
          markPath(match, base, blossom, p, to, curbase, v);
          for (int i = 0; i < n; ++i)
            if (blossom[base[i]]) {
              base[i] = curbase;
              if (!used[i]) {
                used[i] = true;
                q[qt++] = i;
              }
            }
        } else if (p[to] == -1) {
          p[to] = v;
          if (match[to] == -1)
            return to;
          to = match[to];
          used[to] = true;
          q[qt++] = to;
        }
      }
    }
    return -1;
  }

  public static int maxMatching(List<List<Integer>> graph) {
    int n = graph.size();
    int[] match = new int[n];
    Arrays.fill(match, -1);
    int[] p = new int[n];
    for (int i = 0; i < n; ++i) {
      if (match[i] == -1) {
        int v = findPath(graph, match, p, i);
        while (v != -1) {
          int pv = p[v];
          int ppv = match[pv];
          match[v] = pv;
          match[pv] = v;
          v = ppv;
        }
      }
    }

    int matches = 0;
    for (int i = 0; i < n; ++i)
      if (match[i] != -1)
        ++matches;
    return matches / 2;
  }
}