import java.util.*;

class symmetricorder{
  //Difficulty: 1.3
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = 1;
    while (sc.hasNextInt()){
      int n = sc.nextInt();
      if (n == 0){
        return;
      }
      System.out.println("SET " + t++);
      String[] names = new String[n];
      for (int i = 0; i <= (n-1)/2; i++){
        names[i] = sc.next();
        if (2*i != (n-1)){
          names[n-i-1] = sc.next();
        }
      }
      for (int i = 0; i < n; i++){
        System.out.println(names[i]);
      }
    }
  }
}