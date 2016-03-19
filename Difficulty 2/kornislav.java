import java.util.*;

class kornislav{
  //Difficulty: 1.6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Queue<Integer> edges = new PriorityQueue<Integer>();
    for (int i = 0; i < 4; i++){
      edges.add(sc.nextInt());
    }
    int edge1 = edges.poll(); edges.poll();
    int edge2 = edges.poll();
    System.out.println(edge1 * edge2);
  }
}