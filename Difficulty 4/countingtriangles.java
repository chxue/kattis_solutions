
import java.util.*;
import java.io.*;

class countingtriangles{
  //Difficulty: 3.5
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n, i, j, k, cnt;
    while ((n = Rd.nextInt())!= 0){
      Segment[] sg = new Segment[n];
      cnt = 0;
      List<List<Integer>> graph = new ArrayList<List<Integer>>();
      for (i = 0; i < n; i++){
        sg[i] = new Segment(Rd.nextDouble(), Rd.nextDouble(), Rd.nextDouble(), Rd.nextDouble());
        graph.add(new ArrayList<Integer>());
      }
      for (i = 0; i < n-1; i++){
        for (j = i+1; j < n; j++){
          if (intersect(sg[i], sg[j]))
            graph.get(i).add(j);
        }
      }
      for (i = 0; i < n-2; i++){
        List<Integer> ls = graph.get(i);
        int size = ls.size();
        if (size > 1){
          for (j = 0; j < size-1; j++){
            for (k = j+1; k < size; k++){
              int sg1 = ls.get(j), sg2 = ls.get(k);
              if (Collections.binarySearch(graph.get(sg1), sg2) > -1){
                cnt++;
              }
            }
          }
        }
      }
      System.out.println(cnt);
                
    }
    bw.flush();
  }
  
  public static boolean intersect(Segment s1, Segment s2){
    return differentSides(s1, s2) && differentSides(s2, s1);
  }
  
  public static boolean differentSides(Segment s1, Segment s2){
    Vector v = s1.v2.subtract(s1.v1), u = s2.v2.subtract(s2.v1), 
      u1 = s2.v1.subtract(s1.v1), u2 = s2.v2.subtract(s1.v1);
    if (v.parallel(u))
      return false;
    double cross1 = v.cross(u1), cross2 = v.cross(u2);
    if (cross1*cross2 <= 0)
      return true;
    return false;
  }
}

class Vector{
  double x, y;
  public Vector(double a, double b){
    x = a;
    y = b;
  }
  
  public double cross(Vector other){
    return this.x*other.y-this.y*other.x;
  }
  
  public Vector subtract(Vector other){
    return new Vector(this.x-other.x, this.y-other.y);
  }
  
  public boolean parallel(Vector other){
    return this.x*other.y == this.y*other.x;
  }
}

class Segment{
  Vector v1, v2;
  public Segment(double x1, double y1, double x2, double y2){
    v1 = new Vector(x1, y1);
    v2 = new Vector(x2, y2);
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