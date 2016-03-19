
import java.util.*;
import java.io.*;

class reseto{
  //Difficulty: 2.5
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt(), k = Rd.nextInt();
    bw.write(Integer.toString(solve(n, k)));
    bw.flush();
  }
  
  public static int solve(int n, int k){
    if (k <= n/2){
      return 2 * k;
    }
    k -= n/2;
    boolean[] crossed = new boolean[n+1];
    for (int i = 3; i <= n; i+= 2){
      if (!crossed[i]){
        k--;
        crossed[i] = true;
        if (k == 0){
          return i;
        }
        if (i <= Math.sqrt(n)){
          for (int j = i * i; j <= n; j+= 2 * i){
            if (!crossed[j]){
              k--;
              crossed[j] = true;
              if (k == 0){
                return j;
              }
            }
          }
        }
      }
    }
    return 0;
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