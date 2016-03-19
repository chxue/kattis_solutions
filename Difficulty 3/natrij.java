
import java.util.*;
import java.io.*;

class natrij{
  //Difficulty: 2.9
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Time t1 = new Time(Rd.next()), t2 = new Time(Rd.next());
    t2.minus(t1);
    bw.write(t2.toString());
    bw.flush();
  }
}

class Time{
  int h, m, s;
  public Time(String in){
    String[] time = in.split(":");
    h = Integer.parseInt(time[0]);
    m = Integer.parseInt(time[1]);
    s = Integer.parseInt(time[2]);
  }
  
  public String toString(){
    return String.format("%02d:%02d:%02d",h,m,s);
  }
  public void minus(Time other){
    h -= other.h;
    m -= other.m;
    s -= other.s;
    if (s < 0){
      s += 60;
      m--;
    }
    if (m < 0){
      m += 60;
      h--;
    }
    if (h < 0){
      h += 24;
    }
    if (s == 0 && m == 0 && h == 0){
      h += 24;
    }
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