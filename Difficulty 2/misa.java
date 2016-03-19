import java.util.*;

class misa{
  //Difficulty: 1.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt(), s = sc.nextInt(); sc.nextLine();
    boolean[][] seats = new boolean[r+2][s+2];
    for (int i = 1; i < r+1; i++){
      String line = sc.nextLine();
      for (int j = 1; j < s+1; j++){
        if (line.charAt(j-1) == 'o'){
          seats[i][j] = true;
        }
      }
    }
    int max = 0,handshakes = 0;
    for (int i = 1; i < r+1; i++){
      for (int j = 1; j < s+1; j++){
        if (!seats[i][j]){
          int misa = neighbors(seats, i, j);
          if (misa > max){
            max = misa;
          }
        } else {
          handshakes += makeHandshakes(seats,i,j);
        }
      }
    }
    System.out.println(handshakes + max);
  }
  public static int neighbors(boolean[][] seats, int row, int col){
    int total = 0;
    for (int i = row-1; i < row+2; i++){
      for (int j = col-1; j < col+2; j++){
        if (seats[i][j]){
          total++;
        }
      }
    }
    return total;
  }
  
  public static int makeHandshakes(boolean[][] seats, int row, int col){
    int total = 0;
    if (seats[row][col+1]){
      total++;
    }
    if (seats[row+1][col]){
      total++;
    }
    if (seats[row+1][col+1]){
      total++;
    }
    if (seats[row-1][col+1]){
      total++;
    }
    return total;
    
  }
      
}