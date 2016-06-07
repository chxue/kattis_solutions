
import java.util.*;
import java.io.*;

class alldifferentdirections{
  //Difficulty: 2.7
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n, i, j;
    double angle;
    while ((n = Rd.nextInt()) != 0){
      double[][] pos = new double[n][2];
      double avx = 0, avy = 0, maxDist = 0, dist, difx, dify;
      for (i = 0; i < n; i++){
        String[] dir = Rd.nextLine().split(" ");
        pos[i][0] = Double.parseDouble(dir[0]);
        pos[i][1] = Double.parseDouble(dir[1]);
        angle = Double.parseDouble(dir[3]);
        for (j = 4; j < dir.length; j+= 2){
          double val = Double.parseDouble(dir[j+1]);
          if (dir[j].equals("walk")){
            double rad = angle/180.0*Math.PI;
            pos[i][0] += val * Math.cos(rad);
            pos[i][1] += val * Math.sin(rad);
          } else {
            angle += val;
          }
        }
        avx += pos[i][0];
        avy += pos[i][1];
      }
      avx /= n;
      avy /= n;
      for (i = 0; i < n; i++){
        difx = pos[i][0] - avx;
        dify = pos[i][1] - avy;
        dist = Math.sqrt(difx*difx + dify * dify);
        if (dist > maxDist)
          maxDist = dist;
      }
      bw.write(String.format("%f %f %f\n", avx, avy, maxDist));
    }
    bw.flush();
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