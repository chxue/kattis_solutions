import java.util.*;

class absurdistan3{
  //Difficulty: 6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<List<Integer>> graph = new ArrayList<List<Integer>>(); 
    int[] degree = new int[n];
    for (int i = 0; i < n; i++){
      graph.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < n; i++){
      int v1 = sc.nextInt() -1, v2 = sc.nextInt() -1;
      graph.get(v1).add(v2);
      graph.get(v2).add(v1);
      degree[v1]++;
      degree[v2]++;
    }
    solve(graph, degree);
  }
  
  public static void solve(List<List<Integer>> graph, int[] degree){
    int index = leaf(degree);
    int n = degree.length;
    while (index != -1){
      degree[index]--;
      for (int v: graph.get(index)){
        if (degree[v] > 0){
          degree[v]--;
          System.out.println((index+1) + " " + (v+1));
          n--;
          break;
        }
      }
      index = leaf(degree);
    }
    while (n > 0){
      index = 0;
      while (degree[index] == 0){
        index++;
      }
      while (degree[index] != 0){
        degree[index] --;
        
        for (int v: graph.get(index)){
          if (degree[v] > 0){
            remove(graph.get(index), v);
            remove(graph.get(v), index);
            degree[v]--;
            System.out.println((index + 1) + " " + (v+1));
            n--;
            index = v;
            break;
          }
        }
      }
    }
  }
  
  public static int leaf(int[] degree){
    for (int i = 0; i < degree.length; i++){
      if (degree[i] == 1){
        return i;
      }
    }
    return -1;
  }
  
  public static void remove(List<Integer> list, int el){
    for (int i = 0; i < list.size(); i++){
      if (list.get(i) == el){
        list.remove(i);
        return;
      }
    }
    return;
  }
}