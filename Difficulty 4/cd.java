import java.util.*;
import java.io.*;
class cd{
  //Difficulty: 3.5
  public static void main(String[] args){
    Rd.init(System.in);
    try{
      while (true){
        int n = Rd.nextInt(), m = Rd.nextInt();
        if (n == 0 && m == 0){
          return;
        }
        int[] jack = new int[n];
        for (int i = 0; i < n; i++){
          jack[i] = Rd.nextInt();
        }
        int pointer = 0, sum = 0;
        for (int i = 0; i < m; i++){
          int cd = Rd.nextInt();
          while (jack[pointer] < cd){
            if (pointer < jack.length-1){
              pointer++;
            } else {
              break;
            }
          }
          if (jack[pointer] == cd){
            sum++;
          }
        }
        System.out.println(sum);
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