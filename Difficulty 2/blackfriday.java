import java.util.*;

class blackfriday{
  //Difficulty: 1.6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] results = new int[n];
    for (int i = 0; i < n; i++){
      results[i] = sc.nextInt();
    }
    for (int i = 6; i > 0; i--){
      int index = 0;
      boolean unique = true;
      for (int j = 0; j < n; j++){
        if (results[j] == i){
          if (index == 0){
            index = j+1;
          } else {
            unique = false;
            break;
          }
        }
      }
      if (index != 0 && unique){
        System.out.println(index);
        return;
      }
    }
    System.out.println("none");
  }
}