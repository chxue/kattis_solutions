import java.util.*;

class hidingplaces{
  //Difficulty: 1.8
  public static class BoardCell implements Comparable<BoardCell>{
    int x, y;
    String name;
    public BoardCell(String name, int x, int y){
      this.name = name;
      this.x = x;
      this.y = y;
    }
    
    public BoardCell[] neighbors(BoardCell[][] board){
      BoardCell[] neighbors = new BoardCell[8];
      int x = this.x, y = this.y, pointer = 0;
      int[] xs = {x-2, x-2, x-1, x-1, x+1, x+1, x+2, x+2};
      int[] ys = {y-1, y+1, y-2, y+2, y-2, y+2, y-1, y+1};
      for (int i = 0; i < 8; i++){
        if (inRange(xs[i])&&inRange(ys[i])){
          neighbors[pointer++] = board[xs[i]][ys[i]];
        }
      }
      return neighbors;
    }
    
    public int compareTo(BoardCell other){
      return (other.y - this.y) * 9 + (this.x - other.x);
    }
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    BoardCell[][] board = new BoardCell[8][8];
    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++){
        board[i][j] = new BoardCell(toString(i,j), i, j);
      }
    }
    BoardCell[][][] neighbors = new BoardCell[8][8][8];
    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++){
        neighbors[i][j] = board[i][j].neighbors(board);
      }
    }
    
    for (int i = 0; i < t; i++){
      boolean[][] visited = new boolean[8][8];
      int[] point = toArray(sc.next());
      int x = point[0], y = point[1], step = 0;
      Set<BoardCell> visitedSet = new TreeSet<BoardCell>();
      visitedSet.add(board[x][y]); visited[x][y] = true;
      while (true){
        Set<BoardCell> toVisit = new TreeSet<BoardCell>();
        for (BoardCell b: visitedSet){
          visited[b.x][b.y] = true;
          for (BoardCell n: neighbors[b.x][b.y]){
            if (n != null && !visited[n.x][n.y]){
              toVisit.add(n);
            }
          }
        }
        if (toVisit.size() == 0){
          System.out.println(step + setToString(visitedSet));
          break;
        }
        visitedSet = toVisit;
        step++;
      }
      
      
    }
  }
  
  public static int[] toArray(String pos){
    int[] point = new int[2];
    point[0] = pos.charAt(0) - 'a';
    point[1] = Character.getNumericValue(pos.charAt(1)) - 1;
    return point;
  }
  
  public static String toString(int x, int y){
    String pos = "";
    pos += (char)('a'+x);
    pos += (y+1);
    return pos;
  }
  
  public static String setToString(Set<BoardCell> cells){
    String output = "";
    for (BoardCell b: cells){
      output+= " " + b.name;
    }
    return output;
  }
  public static boolean inRange(int num){
    return num >= 0 && num < 8;
  }
}