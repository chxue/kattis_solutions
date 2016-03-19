import java.util.*;
import java.io.*;

class bazen{
  //Difficulty: 1.9
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int x = sc.nextInt(), y = sc.nextInt();
    double x1 = 0.0, y1 = 0.0;
    if (x == 0){
      if (y <= 125){
        x1 = 250.0 * 125/(250-y);
        y1 = 250-x1;
      } else {
        x1 = 250.0 * 125/y;
        y1 = 0;
      }
    } else if (y == 0){
      if (x <= 125){
        y1 = 250.0*125/(250-x);
        x1 = 250-y1;
      } else {
        y1 = 250.0*125/x;
        x1 = 0;
      }
    } else {
      if (x <= 125){
        x1 = 250-250.0*125/y;
        y1 = 0;
      } else {
        x1 = 0;
        y1 = 250-250.0*125/x;
      }
    }
    bw.write(String.format("%.2f %.2f", x1, y1));
    bw.flush();
  }
}