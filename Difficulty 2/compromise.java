import java.util.*;

class compromise{
  //Difficulty: 1.8 
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int n = sc.nextInt(), m = sc.nextInt();
      int[] disagree = new int[m];
      for (int j = 0; j < n; j++){
        String agreement = sc.next();
        for (int k = 0; k < m; k++){
          if (agreement.charAt(k) == '0'){
            disagree[k]++;
          } else {
            disagree[k]--;
          }
        }
      }
      String output = "";
      for (int j = 0; j < m; j++){
        if (disagree[j] >= 0){
          output += "0";
        } else {
          output += "1";
        }
      }
      System.out.println(output);
    }
  }
}