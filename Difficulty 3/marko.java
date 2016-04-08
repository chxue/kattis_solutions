
import java.util.*;
import java.io.*;

class marko{
  //Difficulty: 2.8
  public static Map<Character, Integer> map = new HashMap<Character, Integer>();
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] keys = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    int n = Rd.nextInt(), i, j, cnt = 0;
    
    for (i = 0; i < keys.length; i++){
      String key = keys[i];
      for (j = 0; j < key.length(); j++){
        map.put(key.charAt(j), i+2);
      }
    }
    String[] words = new String[n];
    for (i = 0; i < n; i++){
      words[i] = Rd.next();
    }
    String input = Rd.next();
    for (String word: words){
      if (match(word, input))
        cnt++;
    }
    bw.write(Integer.toString(cnt));
      
    
    bw.flush();
  }
  
  public static boolean match(String word, String input){
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < word.length(); i++){
      sb.append(map.get(word.charAt(i)));
    }
    return sb.toString().equals(input);
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