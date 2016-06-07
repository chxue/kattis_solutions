
import java.util.*;
import java.io.*;

class bela{
  //Difficulty: 1.2
  static String s = "AKQJT987";
  static int[] scores = {11, 4, 3, 2, 10, 0, 0, 0};
  static Map<Character, Integer> map = new HashMap<Character, Integer>();
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt()*4, i, sum = 0;
    char dominant = Rd.next().charAt(0);
    for (i = 0; i < s.length(); i++){
      map.put(s.charAt(i), scores[i]);
    }
    for (i = 0; i < n;i++){
      String card = Rd.nextLine();
      sum += scoreOf(card, dominant);
    }
    bw.write(Integer.toString(sum));
      
    bw.flush();
  }
  public static int scoreOf(String card, char dominant){
    char c = card.charAt(0);
    boolean dom = card.charAt(1) == dominant;
    if (c == 'J' && dom)
      return 20;
    if (c == '9' && dom)
      return 14;
    return map.get(c);
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