
import java.util.*;
import java.io.*;

class settlers2{
  //Difficulty: 3.5
  public static Queue<Resource> r = new PriorityQueue<Resource>();
  public static Map<Point, Integer> map = new HashMap<Point, Integer>();
  public static Map<Integer, Integer> tiles = new HashMap<Integer, Integer>();
  public static int t = 1;
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int i,j, x = 0, y = 0, lv = 1;
    for (i = 1; i < 6; i++){
      r.add(new Resource(i));
    }
    putResource(x, y);
    while (t <= 10000){
      y++;
      putResource(x, y);
      for (j = 0; j < lv-1; j++){
        putResource(--x, ++y);
      }
      for (j = 0; j < lv; j++){
        putResource(--x, y);
      }
      for (j = 0; j < lv; j++){
        putResource(x, --y);
      }
      for (j = 0; j < lv; j++){
        putResource(++x, --y);
      }
      for (j = 0; j < lv; j++){
        putResource(++x, y);
      }
      for (j = 0; j < lv; j++){
        putResource(x, ++y);
      }
      lv ++;
    }
    //System.out.println(map.get(new Point(1,0)));
    int t = Rd.nextInt();
    
    while (t-- > 0){
      bw.write(tiles.get(Rd.nextInt())+ "\n");
    }
    bw.flush();
  }
  
  public static void putResource(int x, int y){
    Point p = new Point(x, y);
    
    Set<Integer> nonadj = nonAdjacent(x, y);
    Resource next;
    Stack<Resource> temp = new Stack<Resource>();
    while (true){
      next = r.poll();
      if (nonadj.contains(next.num)){
        map.put(p, next.num);
        tiles.put(t++, next.num);
        next.occur++;
        r.add(next);
        break;
      }
      temp.push(next);
    }
    while (!temp.empty()){
      r.add(temp.pop());
    }
  }
  
  public static Set<Integer> nonAdjacent(int x, int y){
    Set<Integer> res = new HashSet<Integer>();
    int i;
    for (i = 1; i < 6; i++){
      res.add(i);
    }
    Point p;
    p = new Point(x, y+1);
    if (map.keySet().contains(p))
      res.remove(map.get(p));
    p = new Point(x-1, y+1);
    if (map.keySet().contains(p))
      res.remove(map.get(p));
    p = new Point(x-1, y);
    if (map.keySet().contains(p))
      res.remove(map.get(p));
    p = new Point(x, y-1);
    if (map.keySet().contains(p))
      res.remove(map.get(p));
    p = new Point(x+1, y-1);
    if (map.keySet().contains(p))
      res.remove(map.get(p));
    p = new Point(x+1, y);
    if (map.keySet().contains(p))
      res.remove(map.get(p));
    return res;
  }
}

class Resource implements Comparable<Resource>{
  int num, occur;
  public Resource(int n){
    num = n;
    occur = 0;
  }
  
  public int compareTo(Resource other){
    if (occur == other.occur)
      return num - other.num;
    return occur - other.occur;
  }
}

class Point{
  int x, y;
  public Point(int a, int b){
    x = a;
    y = b;
  }
  
  public String toString(){
    return x + "," + y;
  }
  public int hashCode(){
    return x * 31 + y;
  }
  
  public boolean equals(Object o){
    if (this == o)
      return true;
    if (!(o instanceof Point))
      return false;
    Point p = (Point) o;
    return this.x == p.x && this.y == p.y;
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