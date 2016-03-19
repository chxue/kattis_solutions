
import java.util.*;
import java.io.*;

class waronweather{
  //Difficulty: 3.6
  public static double[] center = {0.0, 0.0, 0.0};
  public static double eps = 0.00000001;
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      int m = Rd.nextInt(), n = Rd.nextInt(), i, j;
      if (m == 0)
        break;
      double[][] satellites = new double[m][3], locations = new double[n][3];
      for (i = 0; i < m; i++){
        for (j = 0; j < 3; j++){
          satellites[i][j] = Rd.nextDouble();
        }
      }
      for (i = 0; i < n; i++){
        for (j = 0; j < 3; j++){
          locations[i][j] = Rd.nextDouble();
        }
      }
      bw.write(solve(satellites, locations) + "\n");
      bw.flush();
    }
    bw.flush();
  }
  
  public static int solve(double[][] sats, double[][] locs){
    double r = dist(locs[0], center);
    int cnt = 0;
    for (double[] loc: locs){
      boolean hit = false;
      for (double[] sat: sats){
        if (canHit(sat, loc, r)){
          hit = true;
          break;
        }
      }
      if (hit)
        cnt++;
    }
    return cnt;
  }
  
  public static boolean canHit(double[] sat, double[] loc, double r){
    double h = dist(sat, center), d = dist(sat, loc), maxDist = Math.sqrt(h*h-r*r);
    return d <= maxDist + eps;
  }
  
  public static double dist(double[] pos1, double[] pos2){
    double res = 0, diff;
    for (int i = 0; i < 3; i++){
      diff = pos1[i]-pos2[i];
      res += diff*diff;
    }
    return Math.sqrt(res);
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