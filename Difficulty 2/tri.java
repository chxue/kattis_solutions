import java.util.*;

class tri{
  //Difficulty: 1.4
  //Is there a more elegant solution?
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
    char operator1 = '=', operator2 = '=';
    if (a+b==c){
      operator1 = '+';
    } else if (a-b==c){
      operator1 = '-';
    } else if (a*b==c){
      operator1 = '*';
    } else if (a/b==c){
      operator1 = '/';
    } else if (a==b+c){
      operator2 = '+';
    } else if (a==b-c){
      operator2 = '-';
    } else if (a==b*c){
      operator2 = '*';
    } else {
      operator2 = '/';
    }
    System.out.format("%d%c%d%c%d", a, operator1, b, operator2, c);
  }
}