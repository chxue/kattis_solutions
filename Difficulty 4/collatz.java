
import java.util.*;
import java.io.*;

class collatz{
  //Difficulty: 3.6
  public static List<List<Long>> dp = new ArrayList<List<Long>>();
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    initialize();
    while (true){
      long a = Rd.nextLong(), b = Rd.nextLong();
      if (a == 0 && b == 0)
        break;
      long[] ans = collatz(a, b);
      bw.write(String.format("%d needs %d steps, %d needs %d steps, they meet at %d\n", a, ans[0], b, ans[1], ans[2])); 
    }
    bw.flush();
  }
  
  public static void initialize(){
    dp.add(new ArrayList<Long>());
    dp.add(new ArrayList<Long>());
    for (int i = 2; i <= 1000000; i++){
      dp.add(getList(i));
    }
  }
  public static List<Long> getList(int n){
    List<Long> res = new ArrayList<Long>();
    long toAdd = next(n);
    while (toAdd > n){
      res.add(toAdd);
      toAdd = next(toAdd);
    }
    res.add(toAdd);
    return res;
  }
  
  public static long next(long n){
    if (n % 2 == 0)
      return n/2;
    return 3*n+1;
  }
  
  public static long[] collatz(long a, long b){
    List<Long> patha = new ArrayList<Long>(), pathb = new ArrayList<Long>(), la, lb;
    long[] res = new long[3];
    patha.add(a); pathb.add(b);
    while (a != b){
      if (a > b){
        la = dp.get((int)a);
        patha.addAll(la);
        a = la.get(la.size()-1);
      } else {
        lb = dp.get((int)b);
        pathb.addAll(lb);
        b = lb.get(lb.size()-1);
      }
    }
    int pa = patha.size()-1, pb = pathb.size()-1;
    while (pa >= 0 && pb >= 0){
      if (patha.get(pa).equals(pathb.get(pb))){
        pa--;
        pb--;
      } else {
        break;
      }
    }
    res[0] = pa+1;
    res[1] = pb+1;
    res[2] = patha.get(pa+1);
      
    return res;
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