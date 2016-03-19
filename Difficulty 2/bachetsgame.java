import java.util.*;

class bachetsgame{
  //Difficulty: 2.0
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      int n = sc.nextInt(), m = sc.nextInt();
      int[] results = new int[n+1];
      int[] set = new int[m];
      for (int i = 0; i < m; i++){
        int added = sc.nextInt();
        set[i] = added;
        results[added] = 1;
      }
      for (int i = 1; i <= n; i++){
        if (results[i] == 0){
          results[i] = -1;
          for (int k: set){
            if (i > k && results[i-k]==-1){
              results[i] = 1;
              break;
            }
          }
        }
      }
      System.out.println(results[n] == 1? "Stan wins":"Ollie wins");
    }
  }
}