import java.util.*;
import java.io.*;

class sumoftheothers{
  //Difficulty: 1.9
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (sc.hasNextLine()){
      String[] integers = sc.nextLine().split(" ");
      int sum = 0;
      for (String s: integers){
        sum += Integer.parseInt(s);
      }
      bw.write(sum/2 + "\n");
    }
      
    bw.flush();
  }
}