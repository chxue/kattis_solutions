
import java.util.*;
import java.io.*;

class logo{
  //Difficulty: 3.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, j;
    for (i = 0; i < t; i++){
      int n = Rd.nextInt();
      Turtle turtle = new Turtle();
      for (j = 0; j < n; j++){
        String command = Rd.next();
        double val = Rd.nextDouble();
        if (command.equals("fd")){
          turtle.move(val);
        } else if (command.equals("bk")){
          turtle.move(-val);
        } else if (command.equals("lt")){
          turtle.turn(val);
        } else {
          turtle.turn(-val);
        }
      }
      bw.write((int)(turtle.dist()+0.5) + "\n");
    }
    bw.flush();
  }
}

class Turtle{
  double x, y, angle;
  public Turtle(){
    x = 0;
    y = 0;
    angle = 0;
  }
  
  public void move(double dist){
    double rad = angle/180*Math.PI;
    x += dist * Math.cos(rad);
    y += dist * Math.sin(rad);
  }
  
  public void turn(double a){
    angle += a;
  }
  
  public double dist(){
    return Math.sqrt(x*x + y*y);
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