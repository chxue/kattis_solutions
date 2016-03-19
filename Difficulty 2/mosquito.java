import java.util.*;

class mosquito{
  //Difficulty: 2.0
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      int m = sc.nextInt(), p = sc.nextInt(),
        l = sc.nextInt(), e = sc.nextInt(),
        r = sc.nextInt(), s = sc.nextInt(), n = sc.nextInt();
      while (n-- > 0){
        int newM = p/s, newP = l/r, newL = m*e;
        m = newM; p = newP; l = newL;
      }
      System.out.println(m);
    }
  }
}