
import java.util.*;
import java.io.*;

class wettiles{
  //Difficulty: 3.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      int x = Rd.nextInt();
      if (x == -1)
        break;
      int y = Rd.nextInt(), t = Rd.nextInt(), l = Rd.nextInt(), w = Rd.nextInt(), i, j, k;
      Tile[][] room = new Tile[x][y];
      for (i = 0; i < x; i++){
        for (j = 0; j < y; j++){
          room[i][j] = new Tile();
        }
      }
      Queue<Integer> wet = new LinkedList<Integer>();
      for (i = 0; i < l; i++){
        int lx = Rd.nextInt()-1, ly = Rd.nextInt()-1;
        room[lx][ly].t = 1;
        wet.add(lx*(x+y+1)+ly);
      }
      
      for (i = 0; i < w; i++){
        int x1 = Rd.nextInt()-1, y1 = Rd.nextInt()-1, x2 = Rd.nextInt()-1, y2 = Rd.nextInt()-1,
          dx = x1-x2==0? 0: Math.abs(x2-x1)/(x2-x1), dy = y1-y2==0? 0: Math.abs(y2-y1)/(y2-y1);
        room[x1][y1].isWall = true;
        while (x1 != x2 || y1 != y2){
          x1 += dx;
          y1 += dy;
          room[x1][y1].isWall = true;
        }
      }
      
      int res = bfs(room, wet, t);
      bw.write(res + "\n");
    }
    bw.flush();
  }
  
  public static int bfs(Tile[][] room, Queue<Integer> wet, int t){
    int x = room.length, y = room[0].length, i, j, cnt = 0, mod = x+y+1;
    while (wet.peek() != null){
      int next = wet.poll(), curx = next/mod, cury = next %mod;
      //System.out.println("checking " + curx + "," + cury);
      int time = room[curx][cury].t;
      cnt++;
      if (time == t) continue;
      if (curx > 0 && !room[curx-1][cury].isWall){
        if (room[curx-1][cury].t > time+1){
          room[curx-1][cury].t = time+1;
          wet.add((curx-1)*mod+cury);
        }
      }
      if (curx < x-1 && !room[curx+1][cury].isWall){
        if (room[curx+1][cury].t > time+1){
          room[curx+1][cury].t = time+1;
          wet.add((curx+1)*mod+cury);
        }
      }
      if (cury > 0 && !room[curx][cury-1].isWall){
        if (room[curx][cury-1].t > time+1){
          room[curx][cury-1].t = time+1;
          wet.add(curx*mod+cury-1);
        }
      }
      if (cury < y-1 && !room[curx][cury+1].isWall){
        if (room[curx][cury+1].t > time+1){
          room[curx][cury+1].t = time+1;
          wet.add(curx*mod+cury+1);
        }
      }
    }
    return cnt;
  }
}

class Tile{
  int t;
  boolean isWall;
  public Tile(){
    t = 200001;
    isWall = false;
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