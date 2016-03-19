import java.util.*;

class sjecista{
  //Difficulty: 1.8
  //important lesson: n*1+(n-1)*2+(n-1)*3+...+1*n = n*(n+1)*(n+2)/6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt() - 3;
    System.out.println(solve(n));
  }
  public static int solve(int n){
    if (n == 0){
      return 0;
    }
    return n*(n+1)*(n+2) /6 + solve(n-1);
  }
}