
import java.util.*;
import java.io.*;

class uxuhulvoting{
  //Difficulty: 2.8
  //important lesson: a more elegant solution can be found at: http://www.acmsearch.com/article/show/32462
  //Basically, one only needs to store the 8 outcomes at each level, instead of the entire matrix.
  //Also, there is a faster way to get the equivalent of "map" in this solution.
  public static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), n, i, j;
    for (i = 0; i < 8; i++){
      map.put(i, new ArrayList<Integer>());
    }
    
    for (i = 0; i < 7; i++){
      for (j = i+1; j < 8; j++){
        if (isPowerOf2(j^i)){
          map.get(i).add(j);
          map.get(j).add(i);
        }
      }
    }
    
    while (t-- > 0){
      n = Rd.nextInt();
      int[][] pref = new int[n][8];
      for (i = 0; i < n; i++){
        for (j = 0; j < 8; j++){
          pref[i][j] = Rd.nextInt();
        }
      }
      bw.write(toString(solve(pref)));
      if (t > 0)
        bw.newLine();
    }
    bw.flush();
  }
  
  public static int solve(int[][] pref){
    int h = pref.length, w = pref[0].length, i, j, min = 9, minIndex = 0;
    int[][] dp = new int[h+1][w];
    for (i = h; i >= 0; i--){
      for (j = 0; j < w; j++){
        if (i == h){
          dp[i][j] = j;
        } else {
          dp[i][j] = best(pref, dp, i, j);
        }
      }
    }
    return dp[0][0];
  }
  
  public static int best(int[][] pref, int[][] dp, int row, int col){
    int min = 9, minIndex = 0;
    for (int v: map.get(col)){
      if (pref[row][dp[row+1][v]] < min){
        min = pref[row][dp[row+1][v]];
        minIndex = dp[row+1][v];
      }
    }
    return minIndex;
  }
  
  public static boolean isPowerOf2(int n){
    return (n & (n-1)) == 0;
  }
  
  public static String toString(int n){
    int i;
    StringBuilder sb = new StringBuilder();
    for (i = 0; i < 3; i++){
      if (n % 2 == 0){
        sb.append('N');
      } else {
        sb.append('Y');
      }
      n /= 2;
    }
    return sb.reverse().toString();
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