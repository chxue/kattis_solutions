
import java.util.*;
import java.io.*;

class wertyu{
  //Difficulty: 2.3
  
  public static void main(String[] args) throws IOException{
    
    String out = "`1234567890-QWERTYUIOP[]ASDFGHJKL;ZXCVBNM,. ", in = "1234567890-=WERTYUIOP[]\\SDFGHJKL;'XCVBNM,./ ";
    Map<Character, Character> map = new HashMap<Character, Character>();
    for (int i = 0; i < in.length(); i++){
      map.put(in.charAt(i), out.charAt(i));
    }
    //System.out.println(map);
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (Rd.hasMoreTokens()){
      String line = Rd.nextLine();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < line.length(); i++){
        char c = line.charAt(i);
        if (!map.keySet().contains(c))
          throw new ArrayIndexOutOfBoundsException();
        sb.append(map.get(c));
      }
      bw.write(sb.toString()+"\n");
      bw.flush();
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