import java.util.*;
import java.io.*;

class weakvertices{
  //Difficulty: 1.8
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      int n = sc.nextInt();
      if (n == -1){
        return;
      }
      int[][] mat = new int[n][n];
      for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
          mat[i][j] = sc.nextInt();
        }
      }
      boolean[] weak = new boolean[n];
      Arrays.fill(weak, true);
      for (int i = 0; i < n; i++){
        if (weak[i]){
          for (int j = 0; j < n-1; j++){
            if (mat[i][j] == 1){
              for (int k = j+1; k < n; k++){
                if (mat[i][k] == 1 && mat[j][k] == 1){
                  weak[i] = false;
                  weak[j] = false;
                  weak[k] = false;
                }
              }
            }
          }
        }
      }
      for (int i = 0; i < n; i++){
        if (weak[i])
          bw.write(i + " ");
      }
      bw.write("\n");
      bw.flush();
    }
  }
}