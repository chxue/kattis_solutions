
import java.util.*;
import java.io.*;

class coast{
  //Difficulty: 2.9
  public static int coast = 0, h, w;
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    h = Rd.nextInt();
    w = Rd.nextInt();
    int i, j;
    char[][] map = new char[h+2][w+2];
    
    for (i = 0; i < h+2; i++){
      Arrays.fill(map[i], '0');
      if (i > 0 && i < h+1){
        String line = Rd.next();
        for (j = 1; j < w+1; j++){
          map[i][j] = line.charAt(j-1);
        }
      }
    }
    flood(map, 0, 0);
    bw.write(coast + "\n");
    bw.flush();
  }
  public static void flood(char[][] map, int i, int j){
    if (map[i][j] == '1'){
      coast++;
      return;
    }
    if (map[i][j] == '2'){
      return;
    }
    map[i][j] = '2';
    if (i > 0){
      flood(map, i-1, j);
    }
    if (i < h+1){
      flood(map, i+1, j);
    }
    if (j > 0){
      flood(map, i, j-1);
    }
    if (j < w+1){
      flood(map, i, j+1);
    }
    return;
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
  
  static long nextLong() throws IOException{
    return Long.parseLong(next());
  }
  
}