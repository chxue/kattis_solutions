import java.util.*;

class volim{
  //Difficulty: 1.9
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt() -1, n = sc.nextInt(), t = 0;
    for (int i = 0; i < n; i++){
      int time = sc.nextInt();
      String status = sc.next();
      if (t + time > 210){
        System.out.println(k%8+1);
        return;
      }
      t += time;
      if (status.equals("T")){
        k++;
      }
    }
  }
}