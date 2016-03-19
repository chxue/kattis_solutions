import java.util.*;
import java.io.*;

class avoidland{
  //Difficulty: 2.9
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt(), sum = 0;
    int[] rows = new int[n], cols = new int[n];
    for (int i = 0; i < n; i++){
      rows[i] = Rd.nextInt();
      cols[i] = Rd.nextInt();
    }
    Arrays.sort(rows);
    Arrays.sort(cols);
    for (int i = 0; i < n; i++){
      sum += Math.abs(rows[i] - i - 1) + Math.abs(cols[i]-i-1);
    }
    bw.write(Integer.toString(sum));
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