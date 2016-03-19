import java.util.*;
import java.io.*;

class securedoors{
  //Difficulty: 2.0
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = sc.nextInt();
    Set<String> inside = new HashSet<String>();
    for (int i = 0; i < n; i++){
      String command = sc.next(), name = sc.next();
      if (command.equals("entry")){
        bw.write(String.format("%s entered", name));
        if (inside.contains(name)){
          bw.write(" (ANOMALY)");
        } else {
          inside.add(name);
        }
        bw.write("\n");
      } else {
        bw.write(String.format("%s exited", name));
        if (inside.contains(name)){
          inside.remove(name);
        } else {
          bw.write(" (ANOMALY)");
        }
        bw.write("\n");
      }
    }
    bw.flush();
  }
}