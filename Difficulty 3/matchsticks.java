
import java.util.*;
import java.io.*;

class matchsticks{
  //Difficulty: 3.0
  static int[] nums = {1, 2, 4, 6, 7, 8, 0}, sticks = {2, 5, 4, 6, 3, 7, 6};
  static Map<Integer, Integer> map = new HashMap<Integer, Integer>(), reverse = new HashMap<Integer, Integer>();
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < nums.length; i++){
      map.put(nums[i], sticks[i]);
      reverse.put(sticks[i], nums[i]);
    }
    int t = Rd.nextInt();
    while (t-- > 0){
      int n = Rd.nextInt();
      bw.write(String.format("%s %s\n", min(n), max(n)));
    }
    bw.flush();
  }
  
  public static String max(int n){
    int digit = n/2, i;
    StringBuilder sb = new StringBuilder();
    if (n % 2 == 0){
      sb.append('1');
    } else {
      sb.append('7');
    }
    for (i = 1; i < digit; i++){
        sb.append('1');
    }
    return sb.toString();
  }
  
  public static String min(int n){
    StringBuilder sb = new StringBuilder();
    while (n > 7){
      int rem = n % 7;
      if (rem == 0)
        rem += 7;
      rem = upgrade(rem, sb.length());
      sb.append(Integer.toString(rem));
      n -= map.get(rem);
    }
    if (sb.length() == 0 && n == 6)
      sb.append('6');
    else
      sb.append(reverse.get(n));
    return sb.toString();
  }
  
  public static int upgrade(int n, int l){
    if (l > 0 && n <= 6)
      return 0;
    if (n <= 2)
      return 1;
    if (n <= 5)
      return 2;
    if (n <= 6)
      return 6;
    return 8;
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