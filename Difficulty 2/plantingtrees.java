import java.util.*;

class plantingtrees{
  //Difficulty: 1.9
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] seeds = new int[n];
    for (int i = 0; i < n; i++){
      seeds[i] = sc.nextInt();
    }
    int max = 0;
    Arrays.sort(seeds);
    for (int i = 0; i < n; i++){
      int days = seeds[i] + (n-i) + 1;
      if (days > max){
        max = days;
      }
    }
    System.out.println(max);
  }
}