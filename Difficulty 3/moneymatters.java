import java.util.*;

class moneymatters{
  //Difficulty: 2.9
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), m = sc.nextInt();
    int[] owe = new int[n], friend = new int[n];
    
    for (int i = 0; i < n; i++){
      owe[i] = sc.nextInt();
      friend[i] = i;
    }
    for (int i = 0; i < m; i++){
      int a = sc.nextInt(), b = sc.nextInt();
      if (friend[a] != friend[b]){
        int head = friend[b];
        for (int j = 0; j < n; j++){
          if (friend[j] == head){
            friend[j] = friend[a];
          }
        }
      }
    }
    int[] sum = new int[n];
    for (int i = 0; i < n; i++){
      sum[friend[i]] += owe[i];
    }
    boolean possible = true;
    for (int i: sum){
      if (i != 0){
        possible = false;
        break;
      }
    }
    System.out.println(possible? "POSSIBLE": "IMPOSSIBLE");
  }
  
}