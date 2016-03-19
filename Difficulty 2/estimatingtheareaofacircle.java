import java.util.*;

class estimatingtheareaofacircle{
  //Difficulty: 1.5
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()){
      double r = sc.nextDouble(), m = sc.nextDouble(), c = sc.nextDouble();
      if (r == 0){
        return;
      }
      System.out.format("%.7f %.7f\n", Math.PI * r * r, 4 * r * r * c /m);
    }
  }
}