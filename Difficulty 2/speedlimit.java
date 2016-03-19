import java.util.*;

class speedlimit{
  //Difficulty: 1.3
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      int n = sc.nextInt();
      if (n < 0){
        return;
      }
      int t = 0, distance = 0;
      for (int i = 0; i < n; i++){
        int speed = sc.nextInt(), time = sc.nextInt();
        distance += speed * (time - t);
        t = time;
      }
      System.out.println(distance + " miles");
    }
  }
}