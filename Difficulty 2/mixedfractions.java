import java.util.*;

class mixedfractions{
  //Difficulty: 1.3
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      int num = sc.nextInt(), den = sc.nextInt();
      if (den == 0){
        return;
      }
      System.out.format("%d %d / %d\n", num/den, num%den, den);
    }
  }
}