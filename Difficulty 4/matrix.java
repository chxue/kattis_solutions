import java.util.*;
import java.io.*;

class matrix{
  //Difficulty: 3.8
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = 1;
    while (sc.hasNextLong()){
      bw.write(String.format("Case %d:\n", t++));
      long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong(), 
        d = sc.nextLong(), det = a*d - b*c;
      a /= det; b /= det; c /= det; d /= det;
      bw.write(String.format("%d %d\n%d %d\n", d, -b, -c, a));
    }
      
    bw.flush();
  }
}