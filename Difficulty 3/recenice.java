
import java.util.*;
import java.io.*;

class recenice{
  //Difficulty: 2.3
  public static String[] under20 = {"","one","two","three","four","five","six","seven", "eight",
    "nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen",
    "nineteen"}, above20 = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
  
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt(), total = 0, index = 0,res,i;
    String[] store = new String[n];
    for (i = 0; i < n; i++){
      String next = Rd.next();
      if (next.equals("$")){
        index = i;
      } else {
        total += next.length();
        store[i] = next;
      }
    }
    res = total+1;
    while (true){
      if (stringOf(res).length() + total == res){
        break;
      }
      res++;
    }
    StringBuilder sb = new StringBuilder();
    for (i = 0; i < n; i++){
      if (i != index){
        sb.append(store[i]);
      } else {
        sb.append(stringOf(res));
      }
      sb.append(" ");
    }
    bw.write(sb.toString());
    bw.flush();
  }
  
  public static String stringOf(int i){
    StringBuilder sb = new StringBuilder();
    if (i/100 != 0){
      sb.append(under20[i/100]);
      sb.append("hundred");
    }
    i %= 100;
    if (i < 20){
      sb.append(under20[i]);
    } else {
      sb.append(above20[i/10-2]);
      sb.append(under20[i%10]);
    }
    return sb.toString();
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