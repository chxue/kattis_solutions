
import java.util.*;
import java.io.*;

class yoda{
  //Difficulty: 3.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String num1 = Rd.next(), num2 = Rd.next();
    int p1 = num1.length()-1, p2 = num2.length() -1;
    StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
    int d1, d2;
    while (p1 >= 0 || p2 >= 0){
      if (p1 < 0){
        d1 = -1;
      } else {
        d1 = num1.charAt(p1--) - '0';
      }
      if (p2 < 0){
        d2 = -1;
      } else {
        d2 = num2.charAt(p2--) - '0';
      }
      if (d1 < d2){
        sb2.append(d2);
      } else if (d1 > d2){
        sb1.append(d1);
      } else {
        sb1.append(d1);
        sb2.append(d2);
      }
    }
    if (sb1.length() == 0){
      bw.write("YODA\n");
    } else {
      bw.write(Integer.parseInt(sb1.reverse().toString())+"\n");
    }
    if (sb2.length() == 0){
      bw.write("YODA\n");
    } else {
      bw.write(Integer.parseInt(sb2.reverse().toString())+"\n");
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