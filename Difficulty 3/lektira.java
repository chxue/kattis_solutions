
import java.util.*;
import java.io.*;

class lektira{
  //Difficulty: 2.9
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = Rd.nextLine();
    Queue<String> q = new PriorityQueue<String>();
    int i,j;
    for (i = 0; i < s.length()-2; i++){
      for (j = i+1; j < s.length()-1; j++){
        q.add(cut(s, i, j));
      }
    }
    bw.write(q.poll());
    bw.flush();
  }
  
  public static String cut(String s, int p1, int p2){
    StringBuilder sb = new StringBuilder();
    int i;
    for (i = p1; i >= 0; i--){
      sb.append(s.charAt(i));
    }
    for (i = p2; i > p1; i--){
      sb.append(s.charAt(i));
    }
    for (i = s.length()-1; i > p2; i--){
      sb.append(s.charAt(i));
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