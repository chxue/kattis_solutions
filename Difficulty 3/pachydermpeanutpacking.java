
import java.util.*;
import java.io.*;

class pachydermpeanutpacking{
  //Difficulty: 2.4 
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      int n = Rd.nextInt();
      if (n == 0){
        break;
      }
      Box[] boxes = new Box[n];
      for (int i = 0; i < n; i++){
        boxes[i] = new Box(Rd.nextDouble(), Rd.nextDouble(), Rd.nextDouble(),
                           Rd.nextDouble(), Rd.next());
      }
      int m = Rd.nextInt();
      for (int i = 0; i < m; i++){
        bw.write(solve(boxes, Rd.nextDouble(), Rd.nextDouble(), Rd.next()));
        bw.newLine();
      }
      bw.newLine();
      
    }
    bw.flush();
  }
  
  public static String solve(Box[] boxes, double x, double y, String size){
    StringBuilder sb = new StringBuilder();
    sb.append(size + " ");
    for (Box b: boxes){
      if (b.contain(x, y)){
        if (size.equals(b.size)){
          sb.append("correct");
        } else {
          sb.append(b.size);
        }
        return sb.toString();
      }
    }
    sb.append("floor");
    return sb.toString();
  }
}

class Box{
  double x1, x2, y1, y2;
  String size;
  public Box(double x1, double y1, double x2, double y2, String size){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.size = size;
  }
  
  public boolean contain(double x, double y){
    return x >= x1 && x <= x2 && y >= y1 && y<= y2;
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
  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
  
  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }
}