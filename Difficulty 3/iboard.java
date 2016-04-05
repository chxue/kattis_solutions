
import java.util.*;
import java.io.*;

class iboard{
  //Difficulty: 2.9 
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (sc.hasNextLine()){
      String next = sc.nextLine();
      bw.write(free(next)? "free\n":"trapped\n");
    }
    bw.flush();
  }
  
  public static boolean free(String s){
    if (s.length() % 2 == 1){
      return false;
    }
    int total = 0, i, res = 0;
    for (i = 0; i < s.length(); i++){
      total ^= (int) s.charAt(i);
    }
    while (total != 0){
      res += total%2;
      total /= 2;
    }
    return res % 2 == 0;
  }
}
