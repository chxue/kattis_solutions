
import java.util.*;
import java.io.*;

class fruitbaskets{
  //Difficulty: 5.2
  public static int weight = 0;
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt(), num = n, i, j;
    long sum = 0, deducted = 0;
    List<Integer> fruits = new ArrayList<Integer>();
    while (n-- > 0){
      int next = Rd.nextInt();
      sum += next;
      if (next < 200){
        fruits.add(next);
      }
    }
    n = fruits.size();
    if (n != 0){
      int[][] dp = new int[n][200];
      for (i = 0; i < n; i++){
        dp[i][fruits.get(i)] = 1;
        if (i == 0) continue;
        for (j = 1; j < 200; j++){
          dp[i][j] += dp[i-1][j];
        }
        for (j = 0; j < 200; j++){
          if (j + fruits.get(i) >= 200)
            break;
          dp[i][j+fruits.get(i)] += dp[i-1][j];
        }
      }
      for (i = 1; i < 200; i++){
        deducted += i * dp[n-1][i];
      }
    }
    long weight = (long)Math.pow(2, num-1)*sum - deducted;
    bw.write(Long.toString(weight));
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