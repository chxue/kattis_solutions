import java.util.*;

class reversebinary{
  //Difficulty: 1.3
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (n ==0){
      System.out.println(0);
      return;
    }
    int numDigits = (int)(Math.log(n)/Math.log(2))+1,
      reversed = 0;
    for (int i = 0; i < numDigits; i++){
      reversed += n%2 * Math.pow(2, numDigits-i-1);
      n/=2;
    }
    System.out.println(reversed);
  }
}