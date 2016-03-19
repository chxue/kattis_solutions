import java.util.*;

class welcomehard{
  //Difficulty: 3.5
  public static char[] welcome = "welcome to code jam".toCharArray();
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(), l = welcome.length; sc.nextLine();
    for (int i = 0; i < t; i++){
      String in = sc.nextLine();
      String out = Long.toString(solve(in,l));
      System.out.format("Case #%d: %s\n", i+1, out.substring(out.length()-4));
    }
  }
  public static long solve(String in, int l){
    int n = in.length();
    long[][] record = new long[l+1][n+1];
    for (int i = 0; i < n+1; i++){
      record[l][i] = 1;
    }
    for (int i = l-1; i >= 0; i--){
      char c = welcome[i];
      for (int j = n-l+i; j >= 0; j--){
        if (in.charAt(j) == c){
          record[i][j] = record[i][j+1] + record[i+1][j];
          if (record[i][j] > 10000){
            record[i][j] %= 10000;
          }
        } else {
          record[i][j] = record[i][j+1];
        }
      }
    }
    return record[0][0]+10000;
  }
}