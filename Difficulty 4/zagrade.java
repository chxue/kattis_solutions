
import java.util.*;
import java.io.*;

class zagrade{
  //Difficulty: 3.7
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = Rd.next();
    List<String> res = new ArrayList<String>();
    removeBrackets(new StringBuilder(), s, 0, new Stack<Integer>(), res);
    Set<String> sortedRes = new TreeSet<String>();
    sortedRes.addAll(res);
    for (String next: sortedRes){
      if (!next.equals(s)){
        bw.write(next);
        bw.newLine();
      }
    }
    bw.flush();
  }
  
  public static void removeBrackets(StringBuilder sb, String s, int index, Stack<Integer> stack, List<String> res){
    if (index == s.length()){
      res.add(sb.toString());
      return;
    }
    int length = sb.length();
    char c = s.charAt(index);
    if (c == '('){
      stack.add(0);
      sb.append(c);
      removeBrackets(sb, s, index+1, stack, res);
      stack.pop();
      sb.setLength(length);
      stack.add(1);
      removeBrackets(sb, s, index+1, stack, res);
      stack.pop();
    } else if (c == ')'){
      if (!stack.empty()){
        int pop = stack.pop();
        if (pop == 0){
          sb.append(c);
        }
        removeBrackets(sb, s, index+1, stack, res);
        stack.add(pop);
      } else {
        removeBrackets(sb, s, index+1, stack, res);
      }
    } else {
      sb.append(c);
      removeBrackets(sb, s, index+1, stack, res);
    }
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