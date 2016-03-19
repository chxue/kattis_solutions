import java.util.*;

class conundrum{
  //Difficulty: 1.3
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    char[] per = {'P','E','R'};
    String cipher = sc.next();
    int days = 0;
    for (int i = 0; i < cipher.length(); i++){
      if (cipher.charAt(i) != per[i%3]){
        days++;
      }
    }
    System.out.println(days);
  }
}