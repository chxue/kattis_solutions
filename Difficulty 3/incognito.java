
import java.util.*;
import java.io.*;

class incognito{
  //Difficulty: 2.2
  public static Map<String, Integer> attr = new HashMap<String, Integer>();
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt();
    for (int i = 0; i < t; i++){
      int n = Rd.nextInt();
      attr.clear();
      for (int j = 0; j < n; j++){
        Rd.next();
        String part = Rd.next();
        if (attr.keySet().contains(part)){
          attr.put(part, attr.get(part) + 1);
        } else {
          attr.put(part, 1);
        }
      }
      int res = 1;
      for (String s: attr.keySet()){
        res *= attr.get(s) + 1;
      }
      bw.write(String.format("%d\n", res-1));
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
  
  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }
}