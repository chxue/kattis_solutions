import java.util.*;

class flowlayout{
  //Difficulty: 1.9
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      int width = sc.nextInt(), currentw = 0, 
        currenth = 0, totalw = 0, totalh = 0;
      if (width == 0){
        return;
      }
      
      while (sc.hasNextInt()){
        int w = sc.nextInt(), h = sc.nextInt();
        if (w == -1){
          if (currentw > totalw){
            totalw = currentw;
          }
          totalh += currenth;
          break;
        }
        if (currentw + w> width){
          if (currentw > totalw){
            totalw = currentw;
          }
          currentw = w;
          totalh += currenth;
          currenth = h;
        } else {
          if (h > currenth){
            currenth = h;
          }
          currentw += w;
        }
      }
      
      System.out.format("%d x %d\n", totalw, totalh);
    }
  }
}