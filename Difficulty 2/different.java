import java.util.*;

class different{
  //Difficulty: 1.9
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLong()){
      long a = scanner.nextLong(), b = scanner.nextLong(), c = 0;
      if (a < b){
        c = b - a;
      } else {
        c = a - b;
      }
      System.out.println(c);
    }
  }
}