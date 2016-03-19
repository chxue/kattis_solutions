import java.io.*;
import java.util.*;
//author: Andrew Wu
class cantinaofbabel{
  //Difficulty: 4.3
  public static void main(String args[]) throws Exception {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    int time = Integer.parseInt(br.readLine());
    Graph g = new Graph();
    for (int i = 0; i < time; i++){
      String[] s = br.readLine().split(" ");
      String speak = s[1];
      Set<String> underst = new HashSet<String>();
      for (int j = 1; j < s.length; j++){
        underst.add(s[j]);
      }
      g.add(speak, underst);
    }
    g.makeGraph();
    int max = Collections.max(new SCCTarjan().scc(g.graph));
    System.out.println(time - max);
  }
  
  
  
  private static class Graph {
    List<List<Integer>> graph;
    public List<Node> adjacency;
    public int size;

    
    public Graph(){
      this.adjacency = new ArrayList<Node>();
      this.size = 0;
    }
    
    public void add(String speak, Set<String> underst){
      Node n = new Node(speak, underst, size);
      for (int i = 0; i< this.adjacency.size(); i++){
        if (underst.contains(adjacency.get(i).speak)){
          adjacency.get(i).nexts.add(this.size);
        }
        if (adjacency.get(i).understand.contains(speak)){
          n.nexts.add(i);
        }
      }
      adjacency.add(n);
      size++;
    }
    
    
    
    public void makeGraph(){
      this.graph = new ArrayList<List<Integer>>();
      for (int i = 0; i < adjacency.size(); i++){
        graph.add(adjacency.get(i).nexts);
      }
    }
    
    
    private static class Node{
      String speak;
      Set<String> understand;
      List<Integer> nexts;
      
      public Node(String speak, Set<String> understand, int index){
        this.speak = speak;
        this.understand = understand;
        this.nexts = new ArrayList<Integer>();
      }
    }
    
    public int getSize(){
      return this.adjacency.size();
    }
  }
  

//https://sites.google.com/site/indy256/algo/scc_tarjan
private static class SCCTarjan {

  List<List<Integer>> graph;
  boolean[] visited;
  Stack<Integer> stack;
  int[] lowlink;
  int index;
  SortedSet<Integer> components;

  public SortedSet<Integer> scc(List<List<Integer>> graph) {
    int n = graph.size();
    this.graph = graph;
    visited = new boolean[n];
    stack = new Stack<Integer>();
    index = 0;
    lowlink = new int[n];
    components = new TreeSet<Integer>();
    for (int i = 0; i < n; i++){
      if (!visited[i]){
        dfs(i);
      }
    }
    return components;
  }

  private void dfs(int u) {
    lowlink[u] = index++;
    visited[u] = true;
    stack.add(u);
    boolean isComponentRoot = true;

    for (int v : graph.get(u)) {
      if (!visited[v])
        dfs(v);
      if (lowlink[u] > lowlink[v]) {
        lowlink[u] = lowlink[v];
        isComponentRoot = false;
      }
    }

    if (isComponentRoot) {
      List<Integer> component = new ArrayList<Integer>();
      while (true) {
        int x = stack.pop();
        component.add(x);
        lowlink[x] = Integer.MAX_VALUE;
        if (x == u)
          break;
      }
      components.add(component.size());
    }
  }
}
}