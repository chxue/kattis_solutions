import java.util.*;

class ants{
  //Difficulty: 2.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int l = sc.nextInt(), n = sc.nextInt(), min = 0, max = 0;
      for (int j = 0; j < n; j++){
        int left = sc.nextInt(), right = l - left, near, far;
        if (left < l/2){
          near = left;
        } else {
          near = right;
        }
        far = l - near;
        if (near > min){
          min = near;
        }
        if (far > max){
          max = far;
        }
        
      }
      System.out.println(min + " " + max);
    }
          
  }
}