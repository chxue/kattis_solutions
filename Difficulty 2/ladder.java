import java.util.*;

class ladder{
  //Difficulty: 1.5
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int length = sc.nextInt();
    double angle = sc.nextDouble();
    double ladder = length/Math.sin(angle/180 * Math.PI);
    System.out.println((int)Math.ceil(ladder));
  }
}