
import java.util.*;
import java.io.*;

class chopwood{
  //Difficulty: 3.6 
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt(), i, j, next = 0;
    int[] occur = new int[n+1];
    int[] read = new int[n];
    for (i = 0; i < n; i++){
      next = Rd.nextInt()-1;
      read[i] = next;
      occur[next]++;
    }
    if (next != n){
      bw.write("Error");
    } else {
      Queue<Integer> q = new PriorityQueue<Integer>();
      for (i = 0; i < n+1; i++){
        if (occur[i] == 0)
          q.add(i);
      }
      for (i = 0; i < n; i++){
        bw.write((q.poll()+1) + "\n");
        if (--occur[read[i]] == 0)
          q.add(read[i]);
      }
    }
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