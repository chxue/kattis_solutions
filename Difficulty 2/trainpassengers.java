import java.util.*;

class trainpassengers{
  //Difficulty: 1.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int c = sc.nextInt(), n = sc.nextInt(), current = 0;
    for (int i = 0; i < n; i++){
      current -= sc.nextInt();
      if (current < 0){
        System.out.println("impossible");
        return;
      }
      current += sc.nextInt();
      if (current > c){
        System.out.println("impossible");
        return;
      }
      if (sc.nextInt() > 0 && current < c){
        System.out.println("impossible");
        return;
      }
    }
    
    if (current != 0){
      System.out.println("impossible");
    } else {
      System.out.println("possible");
    }
  }
}