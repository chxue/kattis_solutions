import java.util.*;

class pauleigon{
  //Difficulty: 1.6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), p = sc.nextInt(), q = sc.nextInt();
    System.out.println((p+q)/n%2==0?"paul":"opponent");
  }
}