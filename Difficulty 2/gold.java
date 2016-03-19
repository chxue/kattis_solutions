import java.util.*;

class gold{
  //Difficulty: 2.0
  //important lesson: use r, c instead of x, y when dealing with matrices.
  public static int COUNT;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int w = sc.nextInt(), h = sc.nextInt(); sc.nextLine();
    char[][] map = new char[h][w];
    boolean[][] visited = new boolean[h][w];
    int px = -1, py = -1;
    COUNT = 0;
    for (int i = 0; i < h; i++){
      String line = sc.nextLine();
      for (int j = 0; j < w; j++){
        char c = line.charAt(j);
        map[i][j] = c;
        if (c == 'P'){
          px = j;
          py = i;
        }
      }
    }
    visited[py][px] = true;
    solve(map, visited, py, px);
    System.out.println(COUNT);
  }
  
  public static void solve(char[][] map, boolean[][] visited, int y, int x){
    visited[y][x] = true;
    if (map[y][x] == 'G'){
      COUNT++;
    }
    if (map[y][x] == '#' ||map[y+1][x] == 'T' || map[y-1][x] == 'T' || 
        map[y][x+1] == 'T'|| map[y][x-1] == 'T'){ //sense a trap or walk into a wall
      return;
    }
    if (!visited[y+1][x]){
      solve(map, visited, y+1, x);
    }
    if (!visited[y-1][x]){
      solve(map, visited, y-1, x);
    }
    if (!visited[y][x+1]){
      solve(map, visited, y, x+1);
    }
    if (!visited[y][x-1]){
      solve(map, visited, y, x-1);
    }
    return;
  }
}