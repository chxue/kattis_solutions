import java.util.*;
import java.io.*;

class shopaholic{
  //Difficulty: 2.5
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = sc.nextInt();
    int[] items = new int[n];
    for (int i = 0; i < n; i++){
      items[i] = sc.nextInt();
    }
    Arrays.sort(items);
    long sum = 0;
    for (int i = n-3; i >= 0; i-= 3){
      sum += items[i];
    }
    bw.write(Long.toString(sum));
    bw.flush();
  }
}