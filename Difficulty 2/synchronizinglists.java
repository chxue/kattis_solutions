import java.util.*;

class synchronizinglists{
  //Difficulty: 1.8
  //important lesson: when the order doesn't matter, use HashMap instead of TreeMap
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while (n != 0){
      int[] list = new int[n];
      PriorityQueue<Integer> a = new PriorityQueue<Integer>(),
      b = new PriorityQueue<Integer>();
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i < n; i++){
        int in = sc.nextInt();
        list[i] = in;
        a.add(in);
      }
      for (int i = 0; i < n; i++){
        int in = sc.nextInt();
        b.add(in);
      }
      for (int i = 0; i < n; i++){
        map.put(a.poll(), b.poll());
      }
      for (int i = 0; i < n; i++){
        System.out.println(map.get(list[i]));
      }
      n = sc.nextInt();
      if (n == 0){
        return;
      }
      System.out.println();
    }
  }
}