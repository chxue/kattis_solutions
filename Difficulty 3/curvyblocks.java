
import java.util.*;
import java.io.*;

class curvyblocks{
  //Difficulty: 2.6
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (Rd.hasMoreTokens()){
      double[] poly1 = toPolynomial(Rd.nextLine()), poly2 = toPolynomial(Rd.nextLine());
      for (int i = 0; i < poly1.length; i++){
        poly2[i] -= poly1[i];
      }
      double[] crit = crit(poly2);
      double maxDif = poly2[0], minDif = maxDif, x = 0;
      for (double d: crit){
        if (d >= 0 && d <= 1){
          double dif = eval(poly2, d);
          if (dif > maxDif)
            maxDif = dif;
          if (dif < minDif)
            minDif = dif;
        }
      }
      bw.write((maxDif-minDif) + "\n");
    }
    bw.flush();
  }
  
  public static double[] toPolynomial(String s){
    String[] line = s.split(" ");
    double[] res = new double[line.length];
    for (int i = 0; i < res.length; i++){
      res[i] = Double.parseDouble(line[i]);
    }
    return res;
  }
  
  public static double[] crit(double[] poly){
    double a = poly[3]*3, b = poly[2]*2, c = poly[1], sqrtDelta = Math.sqrt(b*b - 4*a*c);
    double[] res = new double[4];
    res[0] = (-b + sqrtDelta)/(2*a);
    res[1] = (-b - sqrtDelta)/(2*a);
    res[2] = 0;
    res[3] = 1;
    return res;
  }
  
  public static double eval(double[] poly, double x){
    double mult = 1,res = 0;
    for (double d: poly){
      res += mult*d;
      mult *= x;
    }
    return res;
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