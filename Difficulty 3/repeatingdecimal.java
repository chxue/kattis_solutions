import java.util.*;
import java.io.*;

class repeatingdecimal{
  //Difficulty: 2.6
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (sc.hasNextInt()){
      int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
      bw.write(solve(a,b,c) + "\n");
      bw.flush();
    }
    bw.flush();
  }
  
  public static String solve(int a, int b, int c){
    StringBuilder sb = new StringBuilder();
    sb.append("0.");
    a *= 10;
    while (c > 0){
      sb.append(a/b);
      a = (a%b)*10;
      c--;
    }
    return sb.toString();
  }
}