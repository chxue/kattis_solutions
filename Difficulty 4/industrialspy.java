import java.util.*;

class industrialspy{
  //Difficulty: 3.5
  public static int[] PRIMES = new int[10000000];
  public static int COUNT = 0;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      String s = sc.next();
      int[] inventory = inventory(s);
      COUNT = 0;
      dfs(inventory, "");
      System.out.println(COUNT);
    }
  }
  
  public static void dfs(int[] inventory, String num){
    //System.out.println(num);
    if (isPrime(num)){
      COUNT++;
    }
    for (int i = 0; i < 10; i++){
      if (inventory[i] > 0){
        if (num != "" || i !=0){
          inventory[i]--;
          dfs(inventory, num+i);
          inventory[i]++;
        }
      }
    }
    return;
  }
  
  public static int[] inventory(String s){
    int[] inventory = new int[10];
    for (int i = 0; i < s.length(); i++){
      inventory[Character.getNumericValue(s.charAt(i))]++;
    }
    return inventory;
  }
  
  public static boolean isPrime(String num){
    if (num == ""){
      return false;
    }
    int n = Integer.parseInt(num);
    if (n < 2){
      return false;
    }
    if (PRIMES[n] == -1){
      return false;
    }
    if (PRIMES[n] == 1){
      return true;
    }
    if (n % 2 == 0 && n != 2){
      PRIMES[n] = -1;
      return false;
    }
    for (int i = 3; i*i<=n; i+=2){
      if (n % i== 0){
        PRIMES[n] = -1;
        return false;
      }
    }
    PRIMES[n] = 1;
    return true;
  } 
}