import java.util.*;

class cookieselection{
  //Difficulty: 4.7
  //important lesson: using two heaps to find median quickly.
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Queue<Integer> left = new PriorityQueue<Integer>(10, Collections.reverseOrder());
    Queue<Integer> right = new PriorityQueue<Integer>();
    while (sc.hasNextLine()){
      String input = sc.nextLine();
      
      if (input.equals("#")){
        System.out.println(getMedian(left, right));
      } else {
        int cookie = Integer.parseInt(input);
        if (right.size() == 0){
          right.add(cookie);
        } else if (cookie < right.peek()){
          left.add(cookie);
        } else {
          right.add(cookie);
        }
      }
    }
  }
  
  public static int getMedian(Queue<Integer> left, Queue<Integer> right){
    while (left.size() < right.size() -1){
      left.add(right.poll());
    }
    while (right.size() < left.size()){
      right.add(left.poll());
    }
    return right.poll();
  }
}