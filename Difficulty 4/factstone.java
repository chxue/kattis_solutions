
import java.util.*;
import java.io.*;

class factstone{
  //Difficulty: 3.5
  public static List<Double> logNums = new ArrayList<Double>();
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    double sum = 0;
    int i = 1;
    while (sum < Math.pow(2,22)){
      sum += log2(i++);
      logNums.add(sum);
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int year, n;
    while ((year = Rd.nextInt()) != 0){
      n = (year-1940)/10;
      bw.write(binarySearch(0, logNums.size(), Math.pow(2, n)) + "\n");
    }
    bw.flush();
  }
  
  public static double log2(int n){
    return Math.log(n)/Math.log(2);
  }
  
  public static int binarySearch(int start, int end, double d){
    if (start >= end -1)
      return end;
    int mid = (start + end)/2;
    double midValue = logNums.get(mid);
    if (midValue > d){
      return binarySearch(start, mid, d);
    }
    return binarySearch(mid, end, d);
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
  
  static boolean hasMoreTokens() { 
    while (tokenizer == null || !tokenizer.hasMoreTokens()) { 
      String s = null; 
      try { 
        s = reader.readLine(); 
      } catch (IOException e) { 
        e.printStackTrace(); 
      } 
      if (s == null) 
        return false; 
      tokenizer = new StringTokenizer(s); 
    } 
    return true; 
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