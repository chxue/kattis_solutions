
import java.util.*;
import java.io.*;

class halloweemirrors{
  //Difficulty: 3.0
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n, i;
    while ((n=Rd.nextInt())!= 0){
      Mirror[] mirrors = new Mirror[n];
      for (i = 0; i < n; i++){
        mirrors[i] = new Mirror(Rd.nextInt(), Rd.nextInt(), Rd.nextInt(), Rd.nextInt());
      }
      n = Rd.nextInt();
      for (i = 0; i < n; i++){
        int x = Rd.nextInt(), y = Rd.nextInt(), cnt = 0;
        for (Mirror m: mirrors){
          if (m.canSee(x, y))
            cnt++;
        }
        bw.write(cnt + "\n");
      }
      bw.newLine();
      bw.flush();
    }
  }
}

class Mirror{
  int x1, y1, x2, y2, l2;
  public Mirror(int a, int b, int c, int d){
    x1 = a;
    y1 = b;
    x2 = c;
    y2 = d;
    int xDiff = x2-x1, yDiff = y2-y1;
    l2 = xDiff*xDiff + yDiff*yDiff;
  }
  
  public boolean canSee(int x, int y){
    int v1x = x-x1, v1y = y-y1, v2x = x2-x1, v2y = y2-y1,
    dot = v1x*v2x + v1y*v2y;
    if (dot < 0 || dot > l2)
      return false;
    return true;
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