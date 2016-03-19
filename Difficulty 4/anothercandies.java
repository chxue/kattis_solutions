import java.util.*;

class anothercandies{
  //Difficulty: 2.6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int n = sc.nextInt();
      long sum = 0;
      for (int j = 0; j < n; j++){
        sum += sc.nextLong()%n;
      }
      System.out.println(sum % n == 0? "YES":"NO");
    }
  }
}