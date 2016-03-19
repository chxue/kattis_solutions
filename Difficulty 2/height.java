import java.util.*;

class height{
  //Difficulty: 1.4
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int s = sc.nextInt(), steps = 0;
      int[] heights = new int[20];
      for (int j = 0; j < 20; j++){
        heights[j] = sc.nextInt();
      }
      for (int j = 0; j < 20; j++){
        for (int k = 0; k < j; k++){
          if (heights[k] > heights[j]){
            steps++;
          }
        }
      }
      System.out.println(s + " " + steps);
    }
  }
}