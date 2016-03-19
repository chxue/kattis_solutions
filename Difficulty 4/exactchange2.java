import java.util.*;
class exactchange2{
  //Difficulty: 3.9
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int target = sc.nextInt(), n = sc.nextInt();
      
      int[] coins = new int[n];
      int maxSum = 0;
      for (int j = 0; j < n; j++){
        coins[j] = sc.nextInt();
        maxSum += coins[j];
      }
      maxSum++;
      
      int[] dp = new int[maxSum];
      
      dp[0] = 0;
      
      for (int k=1; k < maxSum; k++)
        dp[k] = n+1;
      
      for (int C: coins){
        for (int v = maxSum - C - 1; v >= 0; v--)
          if (dp[v] < n+1)
          dp[v+C] = Math.min(dp[v+C], dp[v]+1);
      }
      
      for (int k = target; k < maxSum; k++){
        if (dp[k] < n+1){
          System.out.println(k + " " + dp[k]);
          break;
        }
      }
    }
  }
  
    
}