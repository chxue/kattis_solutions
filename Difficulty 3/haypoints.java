import java.util.*;
import java.io.*;

class haypoints{
  //Difficulty: 2.3
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt(), jobs = Rd.nextInt();
    Map<String, Integer> value = new HashMap<String, Integer>();
    for (int i = 0; i < n; i++){
      value.put(Rd.next(), Rd.nextInt());
    }
    for (int i = 0; i < jobs; i++){
      long total = 0;
      while (true){
        String next = Rd.next();
        if (next.equals(".")){
          break;
        }
        if (value.keySet().contains(next)){
          total += value.get(next);
        }
      }
      bw.write(total + "\n");
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