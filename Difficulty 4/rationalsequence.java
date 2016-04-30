
import java.util.*;
import java.io.*;

class rationalsequence{
  //Difficulty: 3.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt();
    while (t-- > 0){
      String setNum = Rd.next();
      String[] frac = Rd.next().split("/");
      Fraction f = new Fraction(Integer.parseInt(frac[0]), Integer.parseInt(frac[1]));
      bw.write(String.format("%s %s", setNum, f.next().toString()));
      bw.newLine();
    }
    bw.flush();
  }
  
  
}

class Fraction{
  int x, y;
  public Fraction(int a, int b){
    x = a;
    y = b;
  }
  
  public String toString(){
    return String.format("%d/%d", x, y);
  }
  
  public Fraction next(){
    if (x < y){
      return new Fraction(y, y-x);
    }
    if (y == 1){
      return new Fraction(1, x+1);
    }
    int lvl = x/y;
    x %= y;
    y -= x;
    x += y;
    y += lvl * x;
    return new Fraction(x, y);
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