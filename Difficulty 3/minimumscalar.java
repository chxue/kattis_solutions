
import java.util.*;
import java.io.*;
import java.math.BigInteger;
class minimumscalar{
  //Difficulty: 2.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, j;
    for (i = 0; i < t; i++){
      int n = Rd.nextInt();
      Long[] v1 = new Long[n], v2 = new Long[n];
      for (j = 0; j < n; j++){
        v1[j] = Rd.nextLong();
      }
      for (j = 0; j < n; j++){
        v2[j] = Rd.nextLong();
      }
      Arrays.sort(v1);
      Arrays.sort(v2, Collections.reverseOrder());
      BigInteger res = BigInteger.ZERO;
      for (j = 0; j < n; j++){
        res = res.add(BigInteger.valueOf(v1[j]).multiply(BigInteger.valueOf(v2[j])));
      }
      bw.write(String.format("Case #%d: %s\n", i+1, res));
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
  
  static Long nextLong() throws IOException {
    return Long.parseLong(next());
  }
}