import java.util.*;
import java.io.*;

class ratings{
  //Difficulty: 2.6
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    while (true){
      int n = sc.nextInt();
      if (n == 0){
        break;
      }
      int[] ratings = new int[n];
      int sum = 0;
      for (int i = 0; i < n; i++){
        ratings[i] = sc.nextInt();
        sum += ratings[i];
      }
      bw.write(noBetter(ratings, sum) + "\n");
    }
    bw.flush();
  }
  
  public static long noBetter(int[] ratings, int sum){
    int l = ratings.length;
    return choose(sum+l-1, l) + partition(ratings, sum, 0);
  }
  
  public static long partition(int[] ratings, int sum, int start){
    if (start == ratings.length-1)
      return 1;
    int n = ratings.length - start;
    return choose(sum+n-1, n-1) - choose(sum+n-1-ratings[start], n-1) + 
      partition(ratings, sum - ratings[start], start+1);
  }
  public static long choose(int n, int k){
    long product = 1;
    for (int i = n; i > n-k; i--){
      product = product * i / (n-i+1);
    }
    return product;
  }
    
}