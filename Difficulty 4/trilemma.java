
import java.util.*;
import java.io.*;

class trilemma{
  //Difficulty:3.4 
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i,j;
    for (i = 0; i < t; i++){
      String[] cors = Rd.nextLine().split(" ");
      int[] cor = new int[6];
      for (j = 0; j < 6; j++){
        cor[j] = Integer.parseInt(cors[j]);
      }
      int[] sides = getSides(cor);
      Arrays.sort(sides);
      int area = cor[0]*(cor[3]-cor[5]) + cor[2]*(cor[5]-cor[1]) + cor[4]*(cor[1]-cor[3]);
      bw.write(String.format("Case #%d: ", i+1));
      if (area == 0){
        bw.write("not a triangle\n");
      } else {
        StringBuilder sb = new StringBuilder();
        if (iso(sides)){
          sb.append("isosceles ");
        } else {
          sb.append("scalene ");
        }
        sb.append(angle(sides));
        sb.append(" triangle\n");
        bw.write(sb.toString());
      }
    }
    bw.flush();
  }
  
  public static int[] getSides(int[] cor){
    
    int[] sides = new int[3];
    for (int i = 0; i < 3; i++){
      int d1 = cor[2*i] - cor[(2*i+2)%6],
        d2 = cor[2*i+1] - cor[(2*i+3)%6];
      sides[i] = d1*d1 + d2*d2;
    }
    return sides;
  }
  
  public static boolean iso(int[] sides){
    return sides[0] == sides[1] || sides[1] == sides[2];
  }
  
  public static String angle(int[] sides){
    int res = sides[0]+ sides[1] -sides[2];
    if (res == 0){
      return "right";
    }
    if (res > 0){
      return "acute";
    }
    return "obtuse";
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