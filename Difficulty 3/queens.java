
import java.util.*;
import java.io.*;

class queens{
  //Difficulty: 2.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    int n = Rd.nextInt(), i;
    boolean[] row = new boolean[n], col = new boolean[n], 
      diag1 = new boolean[2*n-1], diag2 = new boolean[2*n-1];
    for (i = 0; i < n; i++){
      int r = Rd.nextInt(), c = Rd.nextInt();
      //System.out.println("row: " + r + ",col: " + c);
      if (row[r] || col[c] || diag1[r-c+n-1] || diag2[r+c]){
        //System.out.println(row[r] + "," + col[c] +"," + diag1[r-c+n-1] +"," + diag2[r+c]);
        System.out.println("INCORRECT");
        return;
      }
      row[r] = true;
      col[c] = true;
      diag1[r-c+n-1] =true;
      diag2[r+c] = true;
    }
    System.out.println("CORRECT");
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