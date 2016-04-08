
import java.util.*;
import java.io.*;

class ternarianweights{
  //Difficulty: 2.6
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt(), i;
    for (i = 0; i < n; i++){
      bw.write(toString(solve(Rd.nextInt())));
      bw.newLine(); 
      bw.newLine();
    }
    bw.flush();
  }
  
  public static List<Integer> solve(int n){
    List<Integer> digits = toTernary(n);
    for (int i = 0; i < digits.size(); i++){
      if (digits.get(i) >= 2){
        digits.set(i, digits.get(i)-3);
        if (i == digits.size()-1)
          digits.add(1);
        else 
          digits.set(i+1, digits.get(i+1)+1);
      } 
    }
    return digits;
  }
  
  public static List<Integer> toTernary(int n){
    List<Integer> d = new ArrayList<Integer>();
    while (n != 0){
      d.add(n%3);
      n/=3;
    }
    return d;
  }
  
  public static String toString(List<Integer> d){
    StringBuilder sbL = new StringBuilder(), sbR = new StringBuilder();
    sbL.append("left pan:"); sbR.append("right pan:");
    int w = (int)Math.pow(3, d.size() -1);
    for (int i = d.size() - 1; i >= 0; i--){
      int num = d.get(i);
      if (num == 1){
        sbR.append(" " + w);
      } else if (num == -1){
        sbL.append(" " + w);
      }
      w /= 3;
    }
   
    return sbL.toString() + "\n" + sbR.toString();
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