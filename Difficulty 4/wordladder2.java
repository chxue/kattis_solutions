import java.util.*;

class wordladder2{
  //Difficulty: 3.3
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] words = new String[n];
    for (int i = 0; i < n; i++){
      words[i] = sc.next();
    }
    int[] steps = new int[n];
    Arrays.fill(steps, 1000);
    steps[0] = 0;
    Queue<Integer> visited = new LinkedList<Integer>();
    visited.add(0);
    while (visited.peek()!= null){
      int current = visited.poll();
      for (int i = 0; i < n; i++){
        if (steps[i] == 1000){
          if (difference(words[current], words[i]) == 1){
            steps[i] = steps[current] + 1;
            visited.add(i);
          }
        }
      }
    }
    boolean reachable = steps[1]!=1000?true:false;
    Queue<String> missing = new PriorityQueue<String>();
    for (int i = 0; i < n; i++){
      if (difference(words[i], words[1]) == 2){
        if (steps[1] > steps[i]+2){
          reachable = false;
          clear(missing);
          steps[1] = steps[i] +2;
          add(words[i], words[1], missing);
        } else if (steps[1] == steps[i]+2){
          add(words[i], words[1], missing);
        }
      }  
    }
    if (reachable || missing.peek() == null){
      System.out.println(0);
    } else {
      System.out.println(missing.peek());
    }
    System.out.println(steps[1] == 1000? -1: steps[1]);
      
  }
  
  public static int difference(String s1, String s2){
    int diff = 0;
    for (int i = 0; i < s1.length(); i++){
      if (s1.charAt(i) != s2.charAt(i))
        diff++;
    }
    return diff;
  }
  
  public static void add(String s1, String s2, Queue<String> missing){
    char[] s1char = s1.toCharArray(), s2char = s2.toCharArray();
    for (int i = 0; i < s1char.length; i++){
      if (s1char[i] != s2char[i]){
        char temp = s1char[i];
        s1char[i] = s2char[i];
        missing.add(new String(s1char));
        s1char[i] = temp;
      }
    }
  }
  
  public static void clear(Queue<String> q){
    while (q.peek() != null)
      q.poll();
  }
}