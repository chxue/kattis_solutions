import java.util.*;

class numbertree{
  //Difficulty: 1.6
  //important lesson: use long instead of int when the number is too huge
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] info = sc.nextLine().split(" ");
    int layer = Integer.parseInt(info[0]);
    long root = 0;
    if (info.length > 1){
      String path = info[1];
      for (int i = 0; i < path.length(); i++){
        if (path.charAt(i) == 'L'){
          root = 2 * root + 1;
        } else {
          root = 2 * root + 2;
        }
      }
    }
    System.out.println((long)Math.pow(2, layer + 1)-1-root);
  }
}