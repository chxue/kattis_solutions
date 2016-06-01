import java.util.*;
import java.io.*;

class howmanyzeros{
  //Difficulty: 2.7
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      long n1 = Rd.nextLong(), n2 = Rd.nextLong(), total = 0;
      if (n1 < 0)
        break;
      bw.write((count(n2)-count(n1-1)) + "\n");
    }
    bw.flush();
  }
  
  public static long count(long n){
    if (n== -1)
      return 0;
    long base = 100, total = 0;
    
    total += n/10+1;
    while (base <= n){
      if (n % base >= base/10){
        total += n/base*base/10;
      } else {
        total += (n-base)/base*base/10 + n%base+1;
      }
      base *= 10;
    }
    return total;
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
  static long nextLong() throws IOException{
    return Long.parseLong(next());
  }
  
}