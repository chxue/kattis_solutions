import java.util.*;

class parking2{
  //Difficulty: 1.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int n = sc.nextInt(), min = 100, max = -1;
      for (int j = 0; j < n; j++){
        int next = sc.nextInt();
        if (next < min){
          min = next;
        }
        if (next > max){
          max = next;
        }
      }
      System.out.println(2 * (max - min));
    }
  }
}