
import java.util.*;
import java.io.*;

class p10kindsofpeople{
  //Difficulty: 5.5
  //static int ID = 1;
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int r = Rd.nextInt(), c = Rd.nextInt(), i, j, id = 1;
    char[][] map = new char[r][c];
    int[][] idMap = new int[r][c];
    for (i = 0; i < r; i++)
      map[i] = Rd.nextLine().toCharArray();
    for (i = 0; i < r; i++){
      for (j = 0; j < c; j++){
        if (idMap[i][j] == 0){
          dfs(map, idMap, i, j, id);
          id++;
        }
      }
    }
    int n = Rd.nextInt();
    for (i = 0; i < n; i++){
      int sr = Rd.nextInt()-1, sc = Rd.nextInt()-1, 
        er = Rd.nextInt()-1, ec = Rd.nextInt()-1;
      if (idMap[sr][sc] == idMap[er][ec])
        bw.write(map[sr][sc] == '0'? "binary":"decimal");
      else
        bw.write("neither");
      bw.newLine();
    }
    
    bw.flush();
  }
  
  public static void dfs(char[][] map, int[][] idMap, int r, int c, int id){
    if (idMap[r][c] != 0)
      return;
    idMap[r][c] = id;
    char zone = map[r][c];
    if (r > 0 && map[r-1][c] == zone)
      dfs(map, idMap, r-1, c, id);
    if (r < map.length-1 && map[r+1][c] == zone)
      dfs(map, idMap, r+1, c, id);
    if (c > 0 && map[r][c-1] == zone)
      dfs(map, idMap, r, c-1, id);
    if (c < map[0].length-1 && map[r][c+1] == zone)
      dfs(map, idMap, r, c+1, id);
    //return;
  }
}
class Rd {
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
  
  static boolean hasMoreTokens() { 
    while (tokenizer == null || !tokenizer.hasMoreTokens()) { 
      String s = null; 
      try { 
        s = reader.readLine(); 
      } catch (IOException e) { 
        e.printStackTrace(); 
      } 
      if (s == null) 
        return false; 
      tokenizer = new StringTokenizer(s); 
    } 
    return true; 
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