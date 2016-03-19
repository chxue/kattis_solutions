import java.util.*;
import java.io.*;

class pathtracing{
  //Difficulty: 2.5
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    List<String> moves = new ArrayList<String>();
    int col = 0, row = 0, l = 0, r = 0, t = 0, b = 0;
    while (sc.hasNextLine()){
      String move = sc.nextLine();
      if (move.equals("end"))
        break;
      moves.add(move);
      if (move.equals("down")){
        row++;
      } else if (move.equals("up")){
        row--;
      } else if (move.equals("left")){
        col--;
      } else {
        col++;
      }
      if (col > r)
        r = col;
      if (col < l)
        l = col;
      if (row < t)
        t = row;
      if (row > b)
        b = row;
      
    }
    int w = r-l+3, h = b-t+3, sCol = -l+1, sRow = -t+1;
    char[][] map = new char[h][w];
    for (int i = 0; i < h; i++){
      for (int j = 0; j < w; j++){
        if (i == 0 || i == h-1 || j == 0 || j == w-1){
          map[i][j] = '#';
        } else {
          map[i][j] = ' ';
        }
      }
    }
    map[sRow][sCol] = 'S';
    for (String s: moves){
      if (s.equals("down")){
        sRow++;
      } else if (s.equals("up")){
        sRow--;
      } else if (s.equals("left")){
        sCol--;
      } else {
        sCol++;
      }
      if (map[sRow][sCol]!='S') //Do not overwrite 'S'
        map[sRow][sCol] = '*';
    }
    map[sRow][sCol] = 'E';
    for (char[] array: map){
      bw.write(new String(array));
      bw.newLine();
    }
    
    bw.flush();
  }
}