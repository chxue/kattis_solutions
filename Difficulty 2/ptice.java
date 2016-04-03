
import java.util.*;
import java.io.*;

class ptice{
  //Difficulty: 1.6
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int l = Rd.nextInt(), i, max = 0;
    int[] correct = new int[3];
    String answers = Rd.next();
    char[] a = {'A','B','C'}, b = {'B','A','B','C'}, g = {'C','C','A','A','B','B'};
    String[] names = {"Adrian","Bruno","Goran"};
    for (i = 0; i < l; i++){
      char c = answers.charAt(i);
      if (c == a[i%3]){
        correct[0]++;
      }
      if (c == b[i%4]){
        correct[1]++;
      }
      if (c == g[i%6]){
        correct[2]++;
      }
    }
    for (i = 0; i < 3; i++){
      if (correct[i] > max){
        max = correct[i];
      }
    }
    bw.write(max + "\n");
    for (i = 0; i < 3; i++){
      if (correct[i] == max){
        bw.write(names[i] + "\n");
      }
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