import java.util.*;

public class listgame{
  
  //Difficulty: 2.9
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    System.out.println(primeFactors(s.nextInt()));
  
  }
  
  public static int solve(int num){
    int count = 0;
    for (int i = 2; i  <= num; i++){
      while (num % i == 0){
        num/=i;
        count ++;
      }
    }
    return count;
  }

  public static int primeFactors(int n) {
    // Print the number of 2s that divide n
    int result = 0;
    while (n%2 == 0){
      result++;
      n = n/2;
    }
 
    // n must be odd at this point.  So we can skip one element (Note i = i +2)
    for (int i = 3; i * i <= n; i = i+2){
        // While i divides n, print i and divide n
        while (n%i == 0){
           result++;
            n = n/i;
        }
    }
 
    // This condition is to handle the case whien n is a prime number
    // greater than 2
    if (n > 2)
        result++;
    return result;
}
}