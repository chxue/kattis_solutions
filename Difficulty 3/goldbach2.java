import java.util.*;

class goldbach2{
  //Difficulty: 2.3
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    boolean[] composite = new boolean[32001];
    for (int i = 3; i < 32001; i+=2){
      if (!composite[i]){
        int k = 3 * i;
        while (k < 32001){
          composite[k] = true;
          k += 2 * i;
        }
      }
    }
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      List<Tuple> l = new ArrayList<Tuple>();
      int n = sc.nextInt();
      if (n == 4){
        l.add(new Tuple(2, 2));
      } else {
        for (int j = 3; j <= n/2; j+=2){
          if (!composite[j] && !composite[n-j]){
            l.add(new Tuple(j, n-j));
          }
        }
      }
      System.out.format("%d has %d representation(s)\n", n, l.size());
      for (Tuple tuple: l){
        System.out.println(tuple.toString());
      }
      System.out.println();
    }
    
  }
  
}

class Tuple{
  int a, b;
  public Tuple(int a, int b){
    this.a = a;
    this.b = b;
  }
  
  public String toString(){
    return a + "+" + b;
  }
}