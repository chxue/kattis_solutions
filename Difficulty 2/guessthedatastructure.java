import java.util.*;

class guessthedatastructure{
  //Difficulty: 2.0
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      int n = sc.nextInt();
      Stack<Integer> s = new Stack<Integer>();
      Queue<Integer> q = new LinkedList<Integer>();
      Queue<Integer> p = new PriorityQueue<Integer>(n, Collections.reverseOrder());
      boolean[] structures = new boolean[3];
      String[] names = {"stack","queue","priority queue"};
      Arrays.fill(structures, true);
      for (int i = 0; i < n; i++){
        int op = sc.nextInt();
        int num = sc.nextInt();
        if (op == 1){
          s.add(num);
          q.add(num);
          p.add(num);
        } else {
          if (structures[0] && (s.empty() || s.pop() != num)){
            structures[0] = false;
          }
          if (structures[1] && (q.peek() == null || q.poll() != num)){
            structures[1] = false;
          }
          if (structures[2] && (p.peek() == null || p.poll() != num)){
            structures[2] = false;
          }
        }
      }
      String out = "";
      for (int i = 0; i < 3; i++){
        if (structures[i]){
          if (out.length() > 0){
            out = "not sure";
            break;
          } else {
            out = names[i];
          }
        }
      }
      System.out.println(out.length() == 0? "impossible":out);
    }
  }
}