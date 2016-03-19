import java.util.*;

class heliocentric{
  //Difficulty: 1.8
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = 1;
    while (sc.hasNextInt()){
      int a = sc.nextInt(), b = sc.nextInt();
      int p = (a-b)*32 % 687;
      while (p < 0){
        p+=687;
      }
      if (p == 0 && a > 0){
        p+= 687;
      }
      System.out.format("Case %d: %d\n", t++, p*365 - a);
    }
  }
}