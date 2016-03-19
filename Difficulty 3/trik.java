
import java.util.*;
import java.io.*;

class trik{
  //Difficulty: 2.6
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String seq = Rd.next();
    int pos = 1, i;
    for (i = 0; i < seq.length(); i++){
      char c = seq.charAt(i);
      if (c == 'A'){
        if (pos == 1)
          pos = 2;
        else if (pos == 2)
          pos = 1;
      } else if (c == 'B'){
        if (pos == 2)
          pos = 3;
        else if (pos == 3)
          pos = 2;
      } else {
        if (pos == 1)
          pos = 3;
        else if (pos == 3)
          pos = 1;
      }
      
    }
    bw.write(pos + "\n");
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