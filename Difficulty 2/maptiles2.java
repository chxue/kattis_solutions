import java.util.*;

class maptiles2{
  //Difficulty: 1.4
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String key = sc.next();
    int lvl = key.length(), l = (int)Math.pow(2, lvl), left = 0, top = 0, right = l, bot = l;
    for (int i = 0; i < lvl; i++){
      int pos = key.charAt(i) - '0', change = (right-left)/2;
      if (pos == 0){
        right -= change;
        bot -= change;
      } else if (pos == 1){
        left += change;
        bot -= change;
      } else if (pos == 2){
        right -= change;
        top += change;
      } else {
        left += change;
        top += change;
      }
    }
    System.out.format("%d %d %d", lvl, left, top);
  }
}