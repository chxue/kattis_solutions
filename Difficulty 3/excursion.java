
import java.util.*;
import java.io.*;

class excursion{
  //Difficulty: 3.0
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    char[] line = Rd.next().toCharArray();
    int n = line.length, i, pos = 0;
    long swaps = 0;
    List<Character> oneAndTwo = new ArrayList<Character>();
    for (i = 0; i < n; i++){
      if (line[i] == '0'){
        swaps += i-(pos++);
      } else {
        oneAndTwo.add(line[i]);
      }
    }
    pos = 0;
    for (i = 0; i < oneAndTwo.size(); i++){
      if (oneAndTwo.get(i) == '1')
        swaps += i-(pos++);
    }
    bw.write(Long.toString(swaps));
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