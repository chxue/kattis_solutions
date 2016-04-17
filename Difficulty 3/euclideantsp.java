
import java.util.*;
import java.io.*;

class euclideantsp{
  //Difficulty: 2.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    double alpha = 10E-5, n = Rd.nextDouble(), p = Rd.nextDouble(), s = Rd.nextDouble(), v = Rd.nextDouble();
    Func f = new Func(n, p, s, v);
    double low = 0, high = Double.MAX_VALUE, mid = (low + high)/2, midVal = f.derivative(mid);
    while (Math.abs(midVal) > 10E-8){
      if (midVal < 0)
        low = mid;
      else
        high = mid;
      mid = (low + high)/2;
      midVal = f.derivative(mid);
    }
    
    bw.write(f.eval(mid) + " " + mid + "\n");
    bw.flush();
  }
}

class Func{
  double n, p, s, v;
  public Func(double n, double p, double s, double v){
    this.n = n;
    this.p = p;
    this.s = s;
    this.v = v;
  }
  
  public double eval(double c){
    return n * Math.pow(Math.log(n)/Math.log(2), c * Math.sqrt(2))/(p*Math.pow(10,9)) + s*(1+1/c)/v;
  }
  
  public double derivative(double c){
    return n/(p * Math.pow(10,9))*Math.pow(Math.log(n)/Math.log(2), c * Math.sqrt(2))*
      Math.log(Math.log(n)/Math.log(2))*Math.sqrt(2) - s/(v*c*c);
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