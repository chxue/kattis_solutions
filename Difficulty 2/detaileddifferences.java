
import java.util.*;
import java.io.*;

class detaileddifferences{
  //Difficulty: 1.9
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, j;
    for (i = 0; i < t; i++){
      String s1 = Rd.next(), s2 = Rd.next();
      char[] diff = new char[s1.length()];
      for (j = 0; j < diff.length; j++){
        if (s1.charAt(j) == s2.charAt(j)){
          diff[j] = '.';
        } else {
          diff[j] = '*';
        }
      }
      bw.write(s1 + "\n" + s2 + "\n" + new String(diff) + "\n");
      bw.newLine();
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
  
  static long nextLong() throws IOException{
    return Long.parseLong(next());
  }
  
}