import java.util.*;

class pet{
  //Difficulty: 1.4
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int max = 0, maxIndex = 0;
    for (int i = 1; i <= 5; i++){
      int sum = 0;
      for (int j = 0; j < 4; j++){
        sum += sc.nextInt();
      }
      if (sum > max){
        max = sum;
        maxIndex = i;
      }
    }
    System.out.format("%d %d", maxIndex, max);
  }
}