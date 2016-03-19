import java.util.*;

class judging{
  //Difficulty: 2.5
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Map<String, Integer> results = new HashMap<String, Integer>();
    for (int i = 0; i < n; i++){
      String input = sc.next();
      if (!results.keySet().contains(input)){
        results.put(input, 1);
      } else {
        results.put(input, results.get(input)+1);
      }
    }
    int sum = 0;
    for (int i = 0; i < n; i++){
      String input = sc.next();
      if (results.keySet().contains(input)){
        if (results.get(input)>0){
          results.put(input, results.get(input)-1);
          sum++;
        }
      }
    }
    System.out.println(sum);
  }
}