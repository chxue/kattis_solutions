import java.util.*;

class rijeci{
  //Difficulty: 1.4
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(), a = 1, b = 0;
    for (int i = 0; i < t; i++){
      int temp = b;
      b = a + b;
      a = temp;
    }
    System.out.println(a + " " + b);
  }
}