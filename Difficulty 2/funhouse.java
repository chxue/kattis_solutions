import java.util.*;
import java.io.*;

class funhouse{
  //Difficulty: 2.0
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int num = 1;
    while (true){
      
      int w = Rd.nextInt(), h = Rd.nextInt();
      if (w == 0){
        break;
      }
      bw.write(String.format("HOUSE %d\n", num++));
      char[][] house = new char[h][w];
      int sr = 0, sc = 0;
      char dir = 'u';
      for (int i = 0; i < h; i++){
        String line = Rd.nextLine();
        for (int j = 0; j < w; j++){
          char c = line.charAt(j);
          house[i][j] = c;
          if (c == '*'){
            sr = i;
            sc = j;
          }
        }
      }
      if (sr == 0){
        dir = 'd';
      } else if (sc == 0){
        dir = 'r';
      } else if (sc == w-1){
        dir = 'l';
      }
      
      while (house[sr][sc] != 'x'){
        if (house[sr][sc] == '/'){
          if (dir == 'd'){
            dir = 'l';
          } else if (dir == 'u'){
            dir = 'r';
          } else if (dir == 'l'){
            dir = 'd';
          } else {
            dir = 'u';
          }
        } else if (house[sr][sc] == '\\'){
          if (dir == 'd'){
            dir = 'r';
          } else if (dir == 'u'){
            dir = 'l';
          } else if (dir == 'l'){
            dir = 'u';
          } else {
            dir = 'd';
          }
        }
        if (dir == 'd'){
          sr++;
        } else if (dir == 'u'){
          sr--;
        } else if (dir == 'l'){
          sc--;
        } else {
          sc++;
        }
      }
      house[sr][sc] = '&';
      for (char[] ca: house){
        bw.write(new String(ca));
        bw.newLine();
      }
    }
    bw.flush();
  }
}
class Rd{
  static BufferedReader reader;
  static StringTokenizer tokenizer;
  
  static void init(InputStream input) {
    reader = new BufferedReader(new InputStreamReader(input));
    tokenizer = new StringTokenizer("");
  }
  
  static String next() throws IOException {
    while (!tokenizer.hasMoreTokens()) {
      tokenizer = new StringTokenizer(reader.readLine() );
    }
    return tokenizer.nextToken();
  }
  
  static String nextLine() throws IOException {
    if (!tokenizer.hasMoreTokens()){
      return reader.readLine();
    }
    StringBuilder s = new StringBuilder();
    while (tokenizer.hasMoreTokens()){
      s.append(tokenizer.nextToken()+" ");
    }
    String out = s.toString();
    return out.substring(0, out.length()-1);
  }
  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
  
  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }
}