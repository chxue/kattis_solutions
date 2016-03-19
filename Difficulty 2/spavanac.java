import java.util.*;

class spavanac{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int h = sc.nextInt();
    int m = sc.nextInt();
    m -= 45;
    if (m < 0){
      h --;
      m += 60;
    }
    System.out.format("%d %d", (h+24)%24, m);
  }
}