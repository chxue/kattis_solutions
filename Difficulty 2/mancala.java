import java.util.*;

class mancala{
  //Difficulty: 1.9
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0 ; i < t; i++){
      int numT = sc.nextInt();
      int n = sc.nextInt();
      int[] bins = new int[100];
      int index = 0, maxIndex = 0;
      for (int j = 0; j < n; j++){
        while (bins[index] > 0){
          bins[index]--;
          index++;
        }
        if (index > maxIndex){
          maxIndex = index;
        }
        bins[index] = index+1;
        index = 0;
      }
      StringBuilder out = new StringBuilder();
      for (int j = 0; j < maxIndex+1; j++){
        out.append(bins[j] + " ");
      }
      System.out.println(numT + " " + (maxIndex+1));
      System.out.println(out);
      
    }
  }
}