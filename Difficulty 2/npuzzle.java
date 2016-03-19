import java.util.*;

class npuzzle{
  //Difficulty: 2.0
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int sum = 0;
    for (int i = 0; i < 4; i++){
      String line = sc.nextLine();
      for (int j = 0; j < 4; j++){
        int ord = line.charAt(j) - 'A';
        if (ord >= 0){
          sum += Math.abs(ord/4-i) + Math.abs(ord%4-j);
        }
      }
    }
    System.out.println(sum);
  }
}