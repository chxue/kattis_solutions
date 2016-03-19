import java.util.*;

class acm2{
  //Difficulty: 1.5
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), first = sc.nextInt();
    Queue<Integer> time = new PriorityQueue<Integer>();
    int score = 0, total = 0, num = 0;
    
    for (int i = 0; i < n; i++){
      if (i == first){
        total += sc.nextInt();
      } else {
        time.add(sc.nextInt());
      }
    }

    while (time.peek()!= null && total <= 300){
      score += total;
      total += time.poll();
      num++;
    }
    if (total <= 300){
      score += total;
      num++;
    }
    System.out.println(num + " " + score);
  }
}