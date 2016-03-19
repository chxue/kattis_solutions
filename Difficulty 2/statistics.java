import java.util.*;

class statistics{
  //Difficulty: 1.8
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = 1;
    while (sc.hasNextInt()){
      int n = sc.nextInt();
      int max = -1000001, min = 1000001;
      for (int i = 0; i < n; i++){
        int next = sc.nextInt();
        if (next > max){
          max = next;
        }
        if (next < min){
          min = next;
        }
      }
      System.out.format("Case %d: %d %d %d\n", t++, min, max, max-min);
    }
  }
}