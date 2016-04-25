
import java.util.*;
import java.io.*;

class birds{
  //Difficulty: 3.3
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int l = Rd.nextInt(),d = Rd.nextInt(), n = Rd.nextInt(), min = Integer.MAX_VALUE, max = 0, cnt = 0;
    Queue<Integer> birds = new PriorityQueue<Integer>();
    while (n-- > 0){
      int next = Rd.nextInt();
      birds.add(next);
      if (next < min)
        min = next;
      if (next > max)
        max = next;
    }
    if (min >= d + 6){
      birds.add(6);
      cnt++;
    }
    if (max <= l-6-d){
      birds.add(l-6);
      cnt++;
    }
    int left = birds.poll(), right;
    while (birds.peek() != null){
      right = birds.poll();
      cnt += (right-left)/d-1;
      left = right;
    }
    bw.write(Integer.toString(cnt));
    
    bw.flush();
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