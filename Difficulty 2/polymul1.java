import java.util.*;
import java.io.*;

class polymul1{
  //Difficulty: 2.0
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt();
    for (int i = 0; i < t; i++){
      int p1 = Rd.nextInt();
      int[] coef1 = new int[p1+1];
      for (int j = 0; j < p1+1; j++){
        coef1[j] = Rd.nextInt();
      }
      int p2 = Rd.nextInt();
      int[] coef2 = new int[p2+1];
      for (int j = 0; j < p2+1; j++){
        coef2[j] = Rd.nextInt();
      }
      int p3 = p1 + p2;
      bw.write(p3 + "\n");
      for (int j = 0; j < p3+1; j++){
        int sum = 0;
        for (int k = 0; k < p1+1; k++){
          if (j-k >= 0 && j-k < p2+1){
            sum += coef1[k] * coef2[j-k];
          }
        }
        bw.write(sum + " ");
      }
      bw.newLine();
    }
    bw.flush();
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

  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
}