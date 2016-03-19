import java.util.*;

class justaminute{
  //Difficulty: 1.8
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int display = 0, actual = 0;
    for (int i = 0; i < t; i++){
      display += sc.nextInt();
      actual += sc.nextInt();
    }
    double average = actual*1.0/(display * 60);
    System.out.println(average <= 1? "measurement error": average);
  }
}