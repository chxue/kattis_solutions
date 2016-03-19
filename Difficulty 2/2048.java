import java.util.*;

class Id2048{
  //Difficulty: 1.9
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[][] mat = new int[4][4];
    for (int i = 0; i < 4; i++){
      for (int j = 0; j < 4; j++){
        mat[i][j] = sc.nextInt();
      }
    }
    int rot = sc.nextInt();
    print(solve(mat, rot));
  }
  
  public static int[][] solve(int[][] mat, int rot){
    int[][] output = new int[4][4];
    for (int i = 0; i < 4; i++){
      int[] rc = new int[4];
      int pointer = 0, r = -1, c = -1;
      boolean added = false, row;
      if (rot % 2 == 0){
        r = i;
        row = true;
      } else {
        c = i;
      }
      
      for (int j = 0; j < 4; j++){
        if (rot == 0){
          c = j;
        } else if (rot == 1){
          r = j;
        } else if (rot == 2){
          c = 3-j;
        } else {
          r = 3-j;
        }
        int next = mat[r][c];
        if (next != 0){
          if (pointer == 0 || added){
            rc[pointer++] = next;
            added = false;
          } else if (next == rc[pointer-1]){
            rc[pointer-1] += next;
            added = true;
          } else {
            
            rc[pointer++] = next;
          }
        }
      }
      for (int j = 0; j < 4; j++){
        if (rot == 0){
          c = j;
        } else if (rot == 1){
          r = j;
        } else if (rot == 2){
          c = 3-j;
        } else {
          r = 3-j;
        }
        output[r][c] = rc[j];
      }
      
    }
    return output;
  }
  
  public static void print(int[][] mat){
    for (int i = 0; i < mat.length; i++){
      for (int j = 0; j < mat[0].length; j++){
        System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }
  }
}