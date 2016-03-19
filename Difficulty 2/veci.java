import java.util.*;

class veci{
  //Difficulty: 2.0
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt(), index = 0, last = 0, cut = -1;
    List<Integer> list = new ArrayList<Integer>();
    while (x > 0){
      int current = x % 10;
      if (current < last && cut == -1){
        cut = index;
      }
      last = current;
      index++;
      list.add(current);
      x /= 10;
    }
    if (cut == -1){
      System.out.println(0);
      return;
    }
    Queue<Integer> queue = new PriorityQueue<Integer>();
    
    for (int i = 0; i <= cut; i++){
      queue.add(list.get(i));
    }
    StringBuilder s = new StringBuilder();
    for (int i = list.size()-1; i > cut; i--){
      s.append(list.get(i));
    }
    int valueAtCut = list.get(cut), sLength = s.length();
    while (queue.peek() != null){
      int i = queue.poll();
      if (i > valueAtCut){
        s.insert(sLength, i);
        valueAtCut = 10;
      } else{
        s.append(i);
      }
    }
    System.out.println(s);
  }
}