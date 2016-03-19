import java.util.*;

class peg{
  //Difficulty: 1.6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    char[][] board = new char[7][7];
    for (int i = 0; i < 7; i++){
      String row = sc.nextLine();
      for (int j = 0; j < 7; j++){
        board[i][j] = row.charAt(j);
      }
    }
    System.out.println(solve(board));
  }
  
  public static int solve(char[][] board){
    int count = 0;
    for (int i = 0; i < 7; i++){
      for (int j = 0; j < 7; j++){
        if (board[i][j] == 'o'){
          //move up:
          if (inRange(i-2) && board[i-1][j] == 'o' && board[i-2][j] == '.'){
            count++;
          }
          //move right:
          if (inRange(j+2) && board[i][j+1] == 'o' && board[i][j+2] == '.'){
            count++;
          }
          //move down:
          if (inRange(i+2) && board[i+1][j] == 'o' && board[i+2][j] == '.'){
            count++;
          }
          //move left:
          if (inRange(j-2) && board[i][j-1] == 'o' && board[i][j-2] == '.'){
            count++;
          }
        }
      }
    }
    return count;
  }
  
  public static boolean inRange(int num){
    return (num >=0) && (num < 7);
  }
}