import java.util.*;
import java.io.*;

class golombrulers{
  //Difficulty: 2.0
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (sc.hasNextLine()){
      String[] line = sc.nextLine().split(" ");
      int[] ruler = new int[line.length];
      int max = 0;
      for (int i = 0; i < line.length; i++){
        ruler[i] = Integer.parseInt(line[i]);
        if (ruler[i] > max)
          max = ruler[i];
      }
      int[] reach = new int[max+1];
      for (int i = 0; i < ruler.length-1; i++){
        for (int j = i+1; j < ruler.length; j++){
          reach[Math.abs(ruler[i] - ruler[j])]++;
        }
      }
      solve(reach, bw);
      bw.flush();
    }
  }
  
  public static void solve(int[] reach, BufferedWriter bw) throws IOException{
    List<Integer> missing = new ArrayList<Integer>();
    for (int i = 1; i < reach.length; i++){
      if (reach[i] > 1){
        bw.write("not a ruler\n");
        return;
      }
      if (reach[i] == 0){
        missing.add(i);
      }
    }
    if (missing.size() == 0){
      bw.write("perfect\n");
      return;
    }
    bw.write("missing");
    for (int i: missing){
      bw.write(" " + i);
    }
    bw.newLine();
  }
}