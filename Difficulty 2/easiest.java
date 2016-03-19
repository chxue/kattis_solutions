import java.util.*;

class easiest{
  //Difficulty: 1.4
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      int n = sc.nextInt(), num = sumDigits(n), i = 11;
      if (n == 0){
        return;
      }
      while (sumDigits(i * n) != num){
        i++;
      }
      System.out.println(i);
    }
  }
  public static int sumDigits(int num){
    int sum = 0;
    while (num > 0){
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }
}

