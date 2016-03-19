import java.util.*;

class plot{
  //Difficulty: 1.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] poly = new int[n+1];
    for (int i = 0; i < n+1; i++){
      poly[n-i] = sc.nextInt();
    }
    long p = 0;
    long[] diff = new long[n+1];
    for (int i = 0; i < n+1; i++){
      long nextP = compute(poly, i);
      diff[i] = nextP - p;
      p = nextP;
    }
    for (int i= 2; i < n+1; i++){
      for (int j = 1; j < i; j++){
        diff[i] -= choose(i-1,j-1)*diff[j];
      }
    }
    for (int i = 0; i < n+1; i++){
      System.out.print(diff[i]);
      if (i < n){
        System.out.print(" ");
      }
    }
  }
  
  public static long compute(int[] poly, int x){
    long sum = 0;
    for (int i = 0; i < poly.length; i++){
      sum += (long)Math.pow(x, i) * poly[i];
    }
    return sum;
  }
  
  public static int choose(int a, int b){
    if (b > a/2){
      b = a -b;
    }
    int product = 1;
    for (int i = 0; i < b; i++){
      product = product * (a-i) / (i+1);
    }
    return product;
  }
}