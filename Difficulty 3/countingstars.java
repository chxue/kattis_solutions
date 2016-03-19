import java.util.*;
import java.io.*;

class countingstars{
  //Difficulty: 2.6
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int num = 1;
    while (sc.hasNextLine()){
      String[] line = sc.nextLine().split(" ");
      int row = Integer.parseInt(line[0]), col = Integer.parseInt(line[1]);
      char[][] map = new char[row][col];
      for (int i = 0; i< row; i++){
        map[i] = sc.nextLine().toCharArray();
      }
      bw.write(String.format("Case %d: %d\n", num++, solve(map)));
    }
    bw.flush();
  }
  
  public static int solve(char[][] map){
    int cnt = 0;
    for (int i = 0; i< map.length; i++){
      for (int j = 0; j < map[i].length; j++){
        if (map[i][j] == '-'){
          cnt++;
          flood(map, i, j);
        }
      }
    }
    return cnt;
  }
  
  public static void flood(char[][] map, int r, int c){
    if (map[r][c] == '#')
      return;
    map[r][c] = '#';
    if (r > 0)
      flood(map, r-1, c);
    if (r < map.length-1)
      flood(map, r+1, c);
    if (c > 0)
      flood(map, r, c-1);
    if (c < map[0].length-1)
      flood(map, r, c+1);
    return;
  }
}