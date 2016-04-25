
import java.util.*;
import java.io.*;

class names{
  //Difficulty: 4.1
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String name = Rd.next();
    if (name.length() == 1)
      bw.write("0");
    else {
      int i, min = name.length(), changes;
      for (i = name.length()/2; i <= 3*name.length()/4; i++){
        changes = Math.min(changeNameEven(name, i), changeNameOdd(name, i));
        if (changes < min)
          min = changes;
      }
      bw.write(Integer.toString(min));
    }
    bw.flush();
  }
  
  public static int changeNameOdd(String name, int pivot){
    int left = pivot-1, right = pivot+1, cnt = 0;
    while (right < name.length()){
      if (name.charAt(left--) != name.charAt(right++))
        cnt++;
    }
    cnt += left;
    return cnt+1;
  }
  public static int changeNameEven(String name, int pivot){
    int left = pivot-1, right = pivot, cnt = 0;
    while (right < name.length()){
      if (left == -1)
        return name.length();
      if (name.charAt(left--) != name.charAt(right++))
        cnt++;
    }
    cnt += left;
    return cnt+1;
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