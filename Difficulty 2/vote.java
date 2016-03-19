import java.util.*;
import java.io.*;
class vote{
  //Difficulty: 1.9
  public static void main(String[] args){
    Rd.init(System.in);
    try{
      int t = Rd.nextInt();
      for (int i = 0; i < t; i++){
        int n = Rd.nextInt(), max = 0, maxIndex = 0, total = 0, maxCount = 0;
        for (int j = 1; j <= n; j++){
          int vote = Rd.nextInt();
          if (vote > max){
            max = vote;
            maxIndex = j;
            maxCount = 1;
          } else if (vote == max){
            maxCount++;
          }
          total += vote;
        }
        if (maxCount > 1){
          System.out.println("no winner");
        } else {
          if (max > total * 1.0/2){
            System.out.println("majority winner " + maxIndex);
          } else {
            System.out.println("minority winner " + maxIndex);
          }
        }
      }
    } catch (IOException e){
      System.exit(-1);
    }
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
  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
  
  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }
}