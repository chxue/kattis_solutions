
import java.util.*;
import java.io.*;

class chartingprogress{
  //Difficulty: 2.6 
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    boolean end = false;
    while (true){
      String next = "init";
      int n = 81, pos = 81, i, ast;
      while (true){
        if (!sc.hasNextLine()){
          bw.flush();
          return;
        }
        next = sc.nextLine();
        if (next.equals(""))
          break;
        
        ast = 0;
        if (n == 81){
          n = next.length();
          pos = n;
        }
        for (i = 0; i < n; i++){
          if (next.charAt(i) == '*'){
            ast++;
          }
        }
        bw.write(makeString(ast, n, pos));
        bw.newLine();
        pos -= ast;
      }
      bw.newLine();
    }
  }
  
  public static String makeString(int ast, int l, int n){
    char[] s = new char[l];
    Arrays.fill(s, '.');
    for (int i = 0; i < ast; i++){
      s[n-i-1] = '*';
    }
    return new String(s);
  }
}