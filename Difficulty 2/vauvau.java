import java.util.*;

class vauvau{
  //Difficulty: 1.9
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] pattern = new int[4];
    for (int i = 0; i < 4; i++){
      pattern[i] = sc.nextInt();
    }
    int dogA = pattern[0] + pattern[1],
      dogB = pattern[2] + pattern[3];
    for (int i = 0; i < 3; i++){
      double arrive = sc.nextDouble()-0.5, count = 0;
      if (arrive % dogA < pattern[0]){
        count++;
      }
      if (arrive % dogB < pattern[2]){
        count++;
      }
      System.out.println(count==0? "none":
                           count==1? "one": "both");
    }
  }
}