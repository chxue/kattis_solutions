import java.util.*;

class billiard{
  //Difficulty: 1.4
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      int a = sc.nextInt(), b = sc.nextInt(), s = sc.nextInt(),
        m = sc.nextInt(), n = sc.nextInt();
      if (a == 0){
        return;
      }
      double width = a * m, height = b * n;
      System.out.format("%.2f %.2f\n", Math.atan(height*1.0/width)*180/Math.PI,
                       Math.sqrt(width*width + height*height)/s);
    }
  }
}