
import java.util.*;
import java.io.*;

class juryjeopardy{
  //Difficulty: 2.5
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, j;
    bw.write(t + "\n");
    for (i = 0; i < t; i++){
      String dir = Rd.nextLine();
      Person p = new Person();
      for (j = 0; j < dir.length(); j++){
        p.move(dir.charAt(j));
      }
      int w = p.xmax-p.xmin + 2, h = p.ymax - p.ymin + 3;
      bw.write(String.format("%d %d\n", h, w));
      char[][] map = new char[h][w];
      for (char[] cArray: map){
        Arrays.fill(cArray, '#');
      }
      for (int step: p.trace){
        int x = step/1000-p.xmin;
        int y = p.ymax - (step%1000-500)+1;
        map[y][x] = '.';
      }
      for (char[] cArray: map){
        bw.write(new String(cArray));
        bw.newLine();
      }
      
    }
    bw.flush();
  }
}


class Person{
  int x, y, ox, oy, xmin, xmax, ymin, ymax;
  List<Integer> trace;
  public Person(){
    x = 0;
    y = 0;
    ox = 1;
    oy = 0;
    xmin = 0;
    xmax = 0;
    ymin = 0;
    ymax = 0;
    trace = new ArrayList<Integer>();
  }
  
  public void move(char c){
    if (c == 'L'){
      this.left();
    } else if (c == 'R'){
      this.right();
    } else if (c == 'B'){
      this.right();
      this.right();
    }
    this.forward();
    
    if (x > xmax)
      xmax = x;
    if (x < xmin)
      xmin = x;
    if (y > ymax)
      ymax = y;
    if (y < ymin)
      ymin = y;
    
    this.printTrace();
  }
  
  public void left(){
    int temp = ox;
    ox = -oy;
    oy = temp;
  }
  
  public void right(){
    int temp = ox;
    ox = oy;
    oy = -temp;
  }
  
  public void forward(){
    x += ox;
    y += oy;
  }
  
  public void printTrace(){
    trace.add(x*1000 + y + 500);
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