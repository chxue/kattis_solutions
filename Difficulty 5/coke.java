import java.util.*;
class coke{
  //Difficulty: 4.5
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    for (int i = 0; i < num; i++){
      System.out.println(solve(scanner.nextInt(), scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
    }
    
  }
  
  public static int solve(int c, int n1, int n5, int n10){
    if (c == 0){
      return 0;
    }
    if (c <= n10){
        return c;
      }
    if (n1 < 3){
      if (n10 > 0){
        return 1 + solve(c-1, n1+2, n5, n10-1);
      }
      return 2 + solve(c-1, n1+2, n5-2, n10);
    }
    if (n5 > 0){
      if (n5 >= 2*(c-n10)){
        return 2*c - n10;
      }
      return 4 + solve(c-1, n1-3, n5-1, n10);
    }
    if (n10 > 0){
      if (n1 > 5){
        return 8 + solve(c-2, n1-6, n5, n10-1);
      }
      return 1 + solve(c-1, n1+2, n5, n10-1);
    }
    return 8 + solve(c-1, n1-8, n5, n10);
  }

}