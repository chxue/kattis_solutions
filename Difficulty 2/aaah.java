import java.util.*;

class aaah{
  //Difficulty: 1.6
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.next(), s2 = scanner.next();
    if (s1.length() < s2.length()){
      System.out.println("no");
    } else {
      System.out.println("go");
    }
  }
}