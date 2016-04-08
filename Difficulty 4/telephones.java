
import java.util.*;
import java.io.*;

class telephones{
  //Difficulty: 3.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      int n = Rd.nextInt(), m = Rd.nextInt(), cnt, i;
      if (n == 0 && m == 0)
        break;
      Interval[] calls = new Interval[n];
      for (i = 0; i < n; i++){
        Rd.next(); Rd.next();
        calls[i] = new Interval(Rd.nextInt(), Rd.nextInt());
      }
      for (i = 0; i < m; i++){
        cnt = 0;
        Interval newInt = new Interval(Rd.nextInt(), Rd.nextInt());
        for (Interval call: calls){
          if (call.intersect(newInt))
            cnt++;
        }
        bw.write(cnt + "\n");
      }
    }
    bw.flush();
  }
}

class Interval{
  int l, r;
  public Interval(int s, int d){
    l = s;
    r = s + d;
  }
  
  public boolean intersect(Interval other){
    return (other.l < r && other.l >= l) || (l < other.r && l >= other.l);
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