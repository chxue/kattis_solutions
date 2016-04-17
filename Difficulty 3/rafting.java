import java.util.*;
import java.io.*;

class rafting{
  //Difficulty: 2.7
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i;
    while (t-- > 0){
      int n1 = Rd.nextInt(), n2;
      Vector[] inner = new Vector[n1];
      for (i = 0; i < n1; i++){
        inner[i] = new Vector(Rd.nextDouble(), Rd.nextDouble());
      }
      n2 = Rd.nextInt();
      Vector[] outer = new Vector[n2];
      for (i = 0; i < n2; i++){
        outer[i] = new Vector(Rd.nextDouble(), Rd.nextDouble());
      }
      double minDist = Double.MAX_VALUE;
      for (Vector v: inner){
        double min = Double.MAX_VALUE;
        for (i = 0; i < n2; i++){
          double d = dist(v, outer[i], outer[(i+1)%n2]);
          if (d < min)
            min = d;
          
        }
        
        if (min < minDist)
          minDist = min;
      }
      bw.write(minDist/2 + "\n");
    }
    bw.flush();
  }
  
  public static Vector subtract(Vector v1, Vector v2){
    return new Vector(v1.x-v2.x, v1.y-v2.y);
  }
  
  public static double dist(Vector v, Vector p1, Vector p2){
    Vector e1 = subtract(p2, p1), e2 = subtract(v, p1);
    //System.out.println("Calculating distance:");
    //System.out.println("e1: " +e1.toString() + ", e2: " + e2.toString());
    
    double r = e1.dot(e2)/(e1.mod*e1.mod);
    //System.out.format("dot: %f, l1: %f, l2: %f\n", r, e1.mod, e2.mod);
    if (r < 0)
      return e2.mod;
    if (r > 1)
      return subtract(p2, v).mod;
    return Math.sqrt(e2.mod*e2.mod - r*r*e1.mod*e1.mod);
  }
}

class Vector{
  double x, y, mod;
  public Vector(double xcor, double ycor){
    x = xcor;
    y = ycor;
    mod = Math.sqrt(x*x + y*y);
  }
  
  public String toString(){
    return x + "," + y;
  }
  
  public double dot(Vector other){
    return this.x*other.x + this.y*other.y;
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