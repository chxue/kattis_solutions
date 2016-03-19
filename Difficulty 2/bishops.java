import java.util.*;

class bishops{
  //Difficulty: 2.0
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      int n = sc.nextInt();
      System.out.println(n == 1? 1: 2*n-2);
    }
  }
}