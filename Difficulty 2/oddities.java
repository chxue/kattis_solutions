import java.util.*;

class oddities{
  //Difficulty: 1.3
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int n = sc.nextInt();
      System.out.format("%d is %s\n", n, n%2 == 0? "even": "odd");
    }
  }
}