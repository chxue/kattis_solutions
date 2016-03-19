import java.util.*;
import java.io.*;

class cokolada{
  //Difficulty: 2.0
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt(), reduce = 0, size = 1;
    while (n % 2 == 0){
      n /= 2;
      size++;
      reduce++;
    }
    if (n == 1){
      size--;
    }
    while (n > 1){
      n /= 2;
      size++;
    }
    bw.write(String.format("%d %d", (int)Math.pow(2, size), size - reduce));
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
  
  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
  
}