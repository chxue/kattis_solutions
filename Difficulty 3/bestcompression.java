import java.util.*;
import java.io.*;

class bestcompression{
  //Difficulty: 2.1
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    long n = sc.nextLong(), b = sc.nextLong();
    bw.write(n <= Math.pow(2, b+1)-1? "yes":"no");
    bw.flush();
  }
}