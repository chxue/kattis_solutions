import java.util.*;

class halfacookie{
  //Difficulty: 2.0
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextDouble()){
      double r = sc.nextDouble(), x = sc.nextDouble(), y = sc.nextDouble();
      double hitR = Math.sqrt(x*x + y*y);
      if (hitR >= r){
        System.out.println("miss");
        continue;
      }
      double theta = Math.acos(hitR/r);
      double a = theta * r * r - Math.sin(theta) * r * hitR,
      b = Math.PI * r * r - a;
      System.out.println(a > b? a + " " + b: b + " " + a);
    }
  }
}