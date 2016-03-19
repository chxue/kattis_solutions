import java.util.*;
import java.io.*;
class averagehard{
  //Difficulty: 3.3
  public static void main(String[] args){
    Rd.init(System.in);
    try{
      int t = Rd.nextInt();
      for (int i = 0; i < t; i++){
        int nCS = Rd.nextInt(), nE = Rd.nextInt(), count = 0;
        double avCS = 0.0, avE = 0.0;
        int[] cs = new int[nCS];
        for (int j = 0; j < nCS; j++){
          cs[j] = Rd.nextInt();
          avCS += cs[j];
        }
        avCS /= nCS;
        for (int j = 0; j < nE; j++){
          avE += Rd.nextInt();
        }
        avE /= nE;
        for (int j = 0; j < nCS; j++){
          if (cs[j] < avCS && cs[j] > avE){
            count++;
          }
        }
      System.out.println(count);
    }
    } catch (IOException e){
      System.exit(-1);
    }
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
  
  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
}