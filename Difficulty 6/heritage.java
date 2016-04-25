
import java.util.*;
import java.io.*;
import java.math.BigInteger;
class heritage{
  //Difficulty: 6.7
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Map<String, Integer> dict = new HashMap<String, Integer>();
    int n = Rd.nextInt(), i, j;
    String name = Rd.next(), s;
    BigInteger[] dp = new BigInteger[name.length()];
    Arrays.fill(dp, BigInteger.ZERO);
    while (n-- > 0){
      String entry = Rd.next();
      int meanings = Rd.nextInt();
      dict.put(entry, meanings);
    }
    Set<String> keySet = dict.keySet();
    for (i = 0; i < dp.length; i++){
      s = name.substring(0, i+1);
      if (keySet.contains(s))
        dp[i] = BigInteger.valueOf(dict.get(s));
      for (j = 0; j < i; j++){
        s = name.substring(j+1, i+1);
        if (keySet.contains(s))
          dp[i] = dp[i].add(dp[j].multiply(BigInteger.valueOf(dict.get(s))));
      }
    }
    bw.write(dp[dp.length-1].mod(BigInteger.valueOf(1000000007)).toString());
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