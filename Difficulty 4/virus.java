
import java.util.*;
import java.io.*;

class virus{
  //Difficulty: 3.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String before = Rd.next(), after = Rd.next();
    int l = 0, i = 0, r = before.length()-1, j = after.length() -1, res = after.length();
    while (l < r && i < j && before.charAt(l) == after.charAt(i)){
      l++;
      i++;
      res--;
    }
    
    while (r >= l && j >= i && before.charAt(r) == after.charAt(j)){
      r--;
      j--;
      res--;
    }
    //System.out.println(l + "," + r);
    /*if (l == r)
      res = 0;*/
    bw.write(res + "\n");
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
  
  static long nextLong() throws IOException{
    return Long.parseLong(next());
  }
  
}