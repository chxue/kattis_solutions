import java.util.*;

class commercials{
  //Difficulty: 1.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), c = sc.nextInt();
    int max = 0, current = 0;
    for (int i = 0; i < n; i++){
      current += sc.nextInt() - c;
      if (current > max){
        max = current;
      }
      if (current < 0){
        current = 0;
      }
    }
    System.out.println(max);
  }
}