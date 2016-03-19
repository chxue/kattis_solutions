import java.util.*;

class closingtheloop{
  //Difficulty: 1.5
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 1; i <= t; i++){
      int n = sc.nextInt();
      PriorityQueue<Integer> blue = new PriorityQueue<Integer>(1,Collections.reverseOrder()), 
        red = new PriorityQueue<Integer>(1, Collections.reverseOrder());
      for (int j = 0; j < n; j++){
        String rope = sc.next();
        int length = Integer.parseInt(rope.substring(0, rope.length()-1));
        char color = rope.charAt(rope.length()-1);
        if (color == 'R'){
          red.add(length);
        } else {
          blue.add(length);
        }
      }
      int sum = 0;
      while (blue.peek() != null && red.peek() != null){
        sum += blue.poll() + red.poll() - 2;
      }
      System.out.format("Case #%d: %d\n",i, sum);
    }
  }
}