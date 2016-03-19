import java.util.*;

class chess{
  //Difficulty: 2.9
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(); sc.nextLine();
    for (int k = 0; k < t; k++){
      char c1 = sc.next().charAt(0), r1 = sc.next().charAt(0),
        c2 = sc.next().charAt(0), r2 = sc.next().charAt(0);
      solve(c1, r1, c2, r2);
    }
  }
  public static void solve(char c1, char r1, char c2, char r2){
    if ((c1 + r1) % 2 != (c2 + r2) % 2){
      System.out.println("Impossible");
      return;
    }
    if (c1 == c2 && r1 == r2){
      System.out.format("0 %c %c\n", c1, r1);
      return;
    }
    if (reachable(c1, r1, c2, r2)){
      System.out.format("1 %c %c %c %c\n", c1, r1, c2, r2);
      return;
    }
    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++){
        char c3 = (char)('A'+i), r3 = (char)('1'+j);
        if (reachable(c1, r1, c3, r3) && reachable(c2, r2, c3, r3)){
          System.out.format("2 %c %c %c %c %c %c\n",c1, r1, c3, r3, c2 ,r2);
          return;
        }
      }
    }
  }
  public static boolean reachable(char c1, char r1, char c2, char r2){
    return Math.abs(c2 - c1) == Math.abs(r2 - r1);
  }
  
  
}