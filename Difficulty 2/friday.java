import java.util.*;

class friday{
  //Difficulty: 1.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      sc.nextInt();
      int n = sc.nextInt(), passed = 0, count = 0;
      for (int j = 0; j < n; j++){
        int day = sc.nextInt();
        if (day >= 13 && (13 + passed) % 7 == 6){
          count++;
        }
        passed += day;
      }
      System.out.println(count);
    }
    
  }
}