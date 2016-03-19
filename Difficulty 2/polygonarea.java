import java.util.*;

class polygonarea{
  //Difficulty: 1.9
  /* Important lesson:
   * Computing the area of a polygon.
   * Given the coordinates of a polygon in (counter)clockwise order,
   * the area of a polygon is
   * |(x1y2-y1x2)+(x2y3-y2x3)+...+(xny1-ynx1)|/2
   */
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      int n = sc.nextInt();
      if (n == 0){
        return;
      }
      int[][] cors = new int[n][2];
      for (int i = 0; i < n; i++){
        cors[i][0] = sc.nextInt();
        cors[i][1] = sc.nextInt();
      }
      double area = 0;
      for (int i = 0; i < n; i++){
        area += cors[i][0]*cors[(i+1)%n][1]-cors[i][1]*cors[(i+1)%n][0];
      }
      System.out.format("%s %.1f\n", area<0?"CW":"CCW", Math.abs(area/2));
    }
  }
}