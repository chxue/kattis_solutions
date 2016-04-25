
import java.util.*;
import java.io.*;

class calculatingdartscores{
  //Difficulty: 3.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt();
    List<Integer> triple = new ArrayList<Integer>();
    while (n > 20){
      int dart = Math.min(20, n/3);
      triple.add(dart);
      n -= dart * 3;
    }
    
    if (triple.size() > 2 && n != 0){
      int db, remain = triple.get(2)*3 + n;
      if (remain % 2 == 1){
        triple.set(1, triple.get(1)-1);
        remain += 3;
      }
      db = remain/2;
      if (db > 20){
        bw.write("impossible");
      } else {
        for (int i = 0; i < 2; i++){
          bw.write(String.format("triple %d\n", triple.get(i)));
        }
        bw.write(String.format("double %d", db));
      }
    } else {
      for (int i: triple){
        bw.write(String.format("triple %d\n", i));
      }
      if (n != 0){
        bw.write(String.format("single %d\n", n));
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