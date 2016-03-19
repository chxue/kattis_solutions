import java.util.*;

class I8queens{
  //Difficulty: 3.5
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    List<int[]> cors = new ArrayList<int[]>();
    for (int i = 0; i < 8; i++){
      String line = sc.nextLine();
      for (int j = 0; j < 8; j++){
        if (line.charAt(j) == '*'){
          int[] cor = {i, j};
          cors.add(cor);
        }
      }
    }

    System.out.println(solve(cors)?"valid":"invalid");
    
  }
  
  public static boolean solve(List<int[]> cors){
    int size = cors.size();
    if (size < 8){
      return false;
    }
    for (int i = 0; i < size-1; i++){
      for (int j = i+1; j < size; j++){
        if (conflict(cors.get(i), cors.get(j))){
          return false;
        }
      }
    }
    return true;
  }
  public static boolean conflict(int[] cor1, int[] cor2){
    return (cor1[0] == cor2[0]) || (cor1[1] == cor2[1]) ||
      (Math.abs(cor1[0]-cor2[0]) == Math.abs(cor1[1]-cor2[1]));
  }
}