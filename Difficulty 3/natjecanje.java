
import java.util.*;
import java.io.*;

class natjecanje{
  //Difficulty: 2.1
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Rd.nextInt();
    Set<Integer> damaged = new HashSet<Integer>();
    int s = Rd.nextInt(), r = Rd.nextInt(), i;
    for (i = 0; i < s; i++)
      damaged.add(Rd.nextInt());
    for (i = 0; i < r; i++){
      int reserved = Rd.nextInt();
      if (damaged.size() > 0){
        if (damaged.contains(reserved)){
          damaged.remove(reserved);
        } else if (damaged.contains(reserved-1)){
          damaged.remove(reserved-1);
        } else if (damaged.contains(reserved+1)){
          damaged.remove(reserved+1);
        }
      }
    }
    bw.write(Integer.toString(damaged.size()));
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