
import java.util.*;
import java.io.*;

class jabuke{
  //Difficulty: 2.2
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[][] corners = new int[3][2], vec = new int[3][2];
    int i, j, t, cnt = 0;
    for (i = 0; i < 3; i++){
      for (j = 0; j < 2; j++){
        corners[i][j] = Rd.nextInt();
      }
    }
    double area = 0.0;
    for (i = 0; i < 3; i++){
      area += corners[i][0]*(corners[(i+1)%3][1]-corners[(i+2)%3][1]);
    }
    bw.write(String.format("%.1f\n", Math.abs(area)/2));
    t = Rd.nextInt();
    
    for (i = 0; i < t; i++){
      int[] v = new int[2];
      v[0] = Rd.nextInt();
      v[1] = Rd.nextInt();
      if (contain(corners, v)){
        cnt++;
      }
    }
    bw.write(cnt + "\n");
    bw.flush();
  }
  
  public static boolean contain(int[][] corners, int[] v){
    int sign = 0;
    for (int i = 0; i < 3; i++){
      int res = (v[0]-corners[i][0])*(corners[(i+1)%3][1] - corners[i][1]) - 
          (v[1] - corners[i][1])* (corners[(i+1)%3][0] - corners[i][0]);
      if (sign == 0){
        sign = res == 0? 0: res > 0? 1: -1;
      } else {
        if (sign * res < 0)
          return false;
      }
    }
    return true;
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
  
  static long nextLong() throws IOException{
    return Long.parseLong(next());
  }
  
}