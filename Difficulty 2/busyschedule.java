import java.util.*;
import java.io.*;

class busyschedule{
  //Difficulty: 2.0
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      int n = Rd.nextInt();
      if (n == 0)
        break;
      Time[] times = new Time[n];
      for (int i = 0; i < n; i++){
        times[i] = new Time(Rd.nextLine());
      }
      Arrays.sort(times);
      for (Time t: times){
        bw.write(t.toString());
        bw.newLine();
      }
      bw.newLine();
    }
    bw.flush();
  }
}

class Time implements Comparable<Time>{
  int hour, minute;
  String ampm;
  public Time(String t){
    String[] time = t.split(" ");
    ampm = time[1];
    String[] time0 = time[0].split(":");
    hour = Integer.parseInt(time0[0]);
    minute = Integer.parseInt(time0[1]);
  }
  
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(hour);
    sb.append(":");
    if (minute<10)
      sb.append("0");
    sb.append(minute);
    sb.append(" ");
    sb.append(ampm);
    return sb.toString();
  }
  public int compareTo(Time other){
    if (this.ampm.equals("a.m.") && other.ampm.equals("p.m."))
      return -1;
    if (this.ampm.equals("p.m.") && other.ampm.equals("a.m."))
      return 1;
    return (this.hour%12 - other.hour%12)*61 + (this.minute - other.minute);
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