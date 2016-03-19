import java.util.*;
import java.io.*;

class engineeringenglish{
  //Difficulty: 2.6
  public static Set<String> appeared = new HashSet<String>();
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    while (sc.hasNext()){
      String s = sc.next(), lower = s.toLowerCase();
      if (appeared.contains(lower)){
        bw.write(". ");
      } else {
        appeared.add(lower);
        bw.write(s + " ");
      }
      bw.flush();
    }
    bw.flush();
  }
}