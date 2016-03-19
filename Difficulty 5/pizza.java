import java.util.*;

class pizza{
  //Difficulty: 4.6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int x = sc.nextInt(), y = sc.nextInt();
      int[][] map = new int[y][x], dist = new int[y][x];
      int[] colSum = new int[x], rowSum = new int[y];
      for (int j = 0; j < y; j++){
        for (int k = 0; k < x; k++){
          map[j][k] = sc.nextInt();
          colSum[k] += map[j][k];
          rowSum[j] += map[j][k];
        }
      }
      dist[0][0] = sumDist(map); 
      int minDist = dist[0][0];
      for (int j = 0; j < y; j++){
        for (int k = 0; k < x; k++){
          if (j != 0 || k != 0){
            if (k == 0){
              dist[j][k] = dist[j-1][k] + sum(rowSum, 0, j) - sum(rowSum, j, y);
            } else {
              dist[j][k] = dist[j][k-1] + sum(colSum, 0, k) - sum(colSum, k, x);
            }
            if (dist[j][k] < minDist){
              minDist = dist[j][k];
            }
          }
        }
      }
      System.out.println(minDist + " blocks");
    }
  }
  
  public static int sumDist(int[][] map){
    int sum = 0;
    for (int i = 0; i < map.length; i++){
      for (int j = 0; j < map[0].length; j++){
        sum += map[i][j] * (i + j);
      }
    }
    return sum;
  }
  
  public static int sum(int[] array, int start, int end){
    int sum = 0;
    for (int i = start; i < end; i++){
      sum += array[i];
    }
    return sum;
  }
}