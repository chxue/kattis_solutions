
import java.util.*;
import java.io.*;

class fareysums{
  //Difficulty: 3.7
  //important lesson: note that the change in farey sum equals the change in number of terms multiplied by 3/2.
  //the original C++ implementation can be found on http://acmgnyr.org/year2014/h.c
  public static final int MAX_ORDER = 10000;
  public static int[] primes = new int[MAX_ORDER+1], phi = new int[MAX_ORDER+1],
    fareyCnt = new int[MAX_ORDER+1], primeFacts = new int[20], factCnts = new int[20];
  public static int lastFarey = 0;
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    makePrimes();
    int t = Rd.nextInt();
    while (t-- > 0){
      int set = Rd.nextInt(), n = Rd.nextInt();
      bw.write(String.format("%d %s\n", set, fareysum(n)));      
    }
    
    bw.flush();
  }
  
  public static void makePrimes(){
    int i, j;
    Arrays.fill(primes, 1);
    Arrays.fill(fareyCnt, 0);
    for (i = 2; i <= MAX_ORDER; i++){
      if (primes[i] == 1){
        for (j = i*2; j <= MAX_ORDER; j += i){
          if (primes[j] == 1)
            primes[j] = i;
        }
      }
    }
    fareyCnt[1] = 2;
    lastFarey = 1;
  }
  
  public static int phi(int val){
    int i, result, cur, lastfact = 0;
    boolean notfound;
    if (primes[val] == 1) return val-1;
    while (val > 1){
      cur = primes[val];
      if (cur == 1) cur = val;
      for (notfound = true, i = 0; i < lastfact && notfound; i++){
        if (cur == primeFacts[i]){
          notfound = false;
          factCnts[i]++;
          break;
        }
      }
      if (notfound){
        primeFacts[lastfact] = cur;
        factCnts[lastfact++] = 1;
      }
      val /= cur;
    }
    result = 1;
    for (i = 0; i < lastfact; i++){
      for (cur = 1; cur < factCnts[i]; cur++){
        result *= primeFacts[i];
      }
      result *= primeFacts[i] - 1;
    }
    return result;
  }
  
  public static String fareysum(int order){
    int j;
    if (order <= lastFarey){
      return Integer.toString(fareyCnt[order]);
    }
    for (j = lastFarey; j < order; j++){
      fareyCnt[j+1] = fareyCnt[j] + phi(j+1);
    }
    lastFarey = order;
    j = 3 * fareyCnt[order] - 4;
    if ((j & 1) == 0){
      return Integer.toString(j/2);
    }
    return String.format("%d/%d", j, 2);
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