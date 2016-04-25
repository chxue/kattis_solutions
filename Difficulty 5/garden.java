
import java.util.*;
import java.io.*;

class garden{
  //Difficulty: 5.0
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    double l = Rd.nextDouble(), x1 = Rd.nextDouble(), y1 = Rd.nextDouble(),
      x2 = Rd.nextDouble(), y2 = Rd.nextDouble();
    Vector v1 = new Vector(-x1, -y1), v2 = new Vector(x2-x1, y2-y1);
    double dotProduct = v1.dot(v2), projV1 = dotProduct/v2.norm,
      d = Math.sqrt(v1.norm*v1.norm - projV1*projV1);
    int res = (int)d;
    if (res * res * Math.PI > l){
      res = (int)Math.ceil(Math.sqrt(l/Math.PI));
    } else {
      double area = 0, angle;
      while (area < l){
        res++;
        angle = 2 * Math.acos(d/res);
        area = res * res * (Math.PI - angle/2 + Math.sin(angle)/2);
      }
      
    }
          
    bw.write(Integer.toString(res)); 
    
    bw.flush();
  }
  
  
}

class Vector{
  double x, y, norm;
  public Vector(double a, double b){
    x = a;
    y = b;
    norm = Math.sqrt(x*x+y*y);
  }
  
  public double dot(Vector other){
    return x*other.x + y*other.y;
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