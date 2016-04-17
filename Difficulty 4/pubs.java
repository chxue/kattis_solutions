
import java.util.*;
import java.io.*;

class pubs{
  //Difficulty: 3.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt(), m = Rd.nextInt(), i;
    List<List<Integer>> graph = new ArrayList<List<Integer>>();
    Node[] nodes = new Node[n];
    for (i = 0; i < n; i++){
      graph.add(new ArrayList<Integer>());
      nodes[i] = new Node();
    }
    for (i = 0; i < m; i++){
      int from = Rd.nextInt()-1, to = Rd.nextInt()-1;
      graph.get(from).add(to);
      graph.get(to).add(from);
    }
    for (i = 0; i < n; i++){
      if (graph.get(i).size() == 0){
        System.out.println("Impossible");
        return;
      }
    }
    Queue<Integer> toVisit = new LinkedList<Integer>();
    for (i = 0; i < n; i++){
      if (nodes[i].dist == -1){
        toVisit.add(i);
        nodes[i].dist = 0;
        while (toVisit.peek() != null){
          int next = toVisit.poll();
          for (int v: graph.get(next)){
            if (nodes[v].dist == -1){
              nodes[v].dist = nodes[next].dist+1;
              toVisit.add(v);
            }
          }
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (i = 0; i < n; i++){
      if (nodes[i].dist % 2 == 0){
        sb.append("pub");
      } else {
        sb.append("house");
      }
      sb.append(" ");
    }
    bw.write(sb.toString());
    bw.flush();
  }
}

class Node{
  int dist;
  public Node(){
    dist = -1;
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