import java.util.*;

class prsteni{
  //Difficulty: 1.8
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int first = sc.nextInt();
    for (int i = 0; i < n-1; i++){
      int r = sc.nextInt(), gcd = gcd(first, r);
      System.out.format("%d/%d\n",first/gcd, r/gcd);
    }
  }
  public static int gcd(int a, int b){
    if (a > b){
      int temp = a;
      a = b;
      b = temp;
    }
    if (a == 0){
      return b;
    }
    return gcd(b%a, a);
  }
}