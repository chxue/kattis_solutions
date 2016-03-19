import java.util.*;
class numbersetseasy{
  //Difficulty: 3.4
  public static final Primes ps = new Primes(1000);
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int a = sc.nextInt(), b = sc.nextInt(), p = sc.nextInt();
      int[] set = new int[b+1];
      for (int j = a; j <= b; j++){
        set[j] = j;
      }
      for (int j = a; j < b; j++){
        for (int k = j+1; k <= b; k++){
          if (set[j] != set[k]){
            if (union(j, k, p)){
              if (set[j] < set[k]){
                int temp = set[k];
                for (int s = a; s <= b; s++){
                  if (set[s] == temp){
                    set[s] = set[j];
                  }
                }
              } else {
                int temp = set[j];
                for (int s = a; s <= b; s++){
                  if (set[s] == temp){
                    set[s] = set[k];
                  }
                }
              }
            }
          }
        }
      }
      Set<Integer> heads = new HashSet<Integer>();
      for (int j = a; j <= b; j++){
        heads.add(set[j]);
      }
      System.out.format("Case #%d: %d\n", i+1, heads.size());
    }
  }
  
  public static boolean union(int a, int b, int p){
    int gcd = gcd(a, b);
    for (int i = p; i <= gcd; i++){
      if (gcd % i == 0 && ps.get(i)){
        return true;
      }
    }
    return false;
  }
  
  public static int gcd(int a, int b){
    if (a == 0){
      return b;
    }
    if (a > b){
      int temp = a;
      a = b;
      b = temp;
    }
    return gcd(b-a, a);
  }
  
}

class Primes{
  boolean[] isPrime;
  public Primes(int size){
    isPrime = new boolean[size];
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;
    for (int i = 3; i < size; i+=2){
      if (isPrime[i]){
        for (int j = i * i; j < size; j+=2 * i){
          isPrime[j] = false;
        }
      }
    }
  }
  
  public boolean get(int n){
    if (n == 2){
      return true;
    }
    if (n % 2 == 0){
      return false;
    }
    return isPrime[n];
  }
}