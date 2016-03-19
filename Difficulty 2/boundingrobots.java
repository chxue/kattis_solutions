import java.util.*;
import java.io.*;

class boundingrobots{
  //Difficulty: 1.7
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      int width = sc.nextInt(), height = sc.nextInt();
      if (width == 0)
        return;
      int xReal = 0, yReal = 0, xRobot = 0, yRobot = 0;
      int n = sc.nextInt();
      for (int i = 0 ; i < n; i++){
        String command = sc.next();
        int steps = sc.nextInt();
        if (command.equals("u")){
          yReal += steps;
          yRobot += steps;
        } else if (command.equals("d")){
          yReal -= steps;
          yRobot -= steps;
        } else if (command.equals("l")){
          xReal -= steps;
          xRobot -= steps;
        } else {
          xReal += steps;
          xRobot += steps;
        }
        if (xReal < 0)
          xReal = 0;
        if (xReal >= width)
          xReal = width -1;
        if (yReal < 0)
          yReal = 0;
        if (yReal >= height)
          yReal = height-1;
      }
      bw.write(String.format("Robot thinks %d %d\nActually at %d %d\n\n", xRobot, yRobot, xReal, yReal));
      bw.flush();
    }
  }
}