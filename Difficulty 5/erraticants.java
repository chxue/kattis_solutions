import java.util.*;

class erraticants{
  //Difficulty: 4.3
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int n = sc.nextInt(), step = 1, x = n, y = n;
      int[][] map = new int[2*n + 1][2*n + 1];
      for (int j = 0; j < n; j++){
        map[x][y] = step;
        int newx = x, newy = y;
        String direction = sc.next();
        if (direction.equals("N")){
          newy -= 1;
        } else if (direction.equals("S")){
          newy += 1;
        } else if (direction.equals("W")){
          newx -= 1;
        } else {
          newx += 1;
        }
        if (map[newx][newy] != 0){
          map[x][y] = Math.min(map[x][y], map[newx][newy]+1);
          step = Math.min(step+1, map[newx][newy]);
        } else {
          step++;
        }
        x = newx;
        y = newy;
      }
      System.out.println(step-1);
    }
  }
}