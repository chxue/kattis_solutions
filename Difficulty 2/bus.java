import java.util.*;

class bus{
  //Difficulty: 1.5
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int k = sc.nextInt();
      double n = 0;
      for (int j = 0; j < k; j++){
        n = (n + 0.5)*2;
      }
      System.out.println((int)n);
    }
  }
}