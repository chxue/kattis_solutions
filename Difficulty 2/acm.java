import java.util.*;

class acm{
  //Difficulty: 1.4
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int time = 0, count = 0;
    Map<String, Integer> wrong = new TreeMap<String, Integer>();
    while (sc.hasNextInt()){
      int min = sc.nextInt();
      if (min == -1){
        System.out.println(count + " " + time);
        return;
      }
      String problem = sc.next();
      String result = sc.next();
      if (result.equals("right")){
        time += min;
        count ++;
        if (wrong.keySet().contains(problem)){
          time += wrong.get(problem) * 20;
        }
      } else {
        if (!wrong.keySet().contains(problem)){
          wrong.put(problem, 0);
        }
        wrong.put(problem, wrong.get(problem)+1);
      }
    }
  }
  
  
}