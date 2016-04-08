
import java.util.*;
import java.io.*;

class functionalfun{
  //Difficulty: 2.6
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (Rd.hasMoreTokens()){
      Rd.nextLine();
      int co = Rd.nextLine().split(" ").length-1, n = Rd.nextInt(), i;
      Map<String, String> func = new HashMap<String, String>(), inv = new HashMap<String, String>();
      boolean isFunc = true, injective = true;
      for (i = 0; i < n; i++){
        String[] relation = Rd.nextLine().split(" -> ");
        String from = relation[0], to = relation[1];
        if (!func.keySet().contains(from)){
          func.put(from, to);
        } else {
          isFunc = false;
        }
        if (!inv.keySet().contains(to)){
          inv.put(to, from);
        } else {
          injective = false;
        }
      }
      boolean surjective = co == inv.keySet().size();
      if (!isFunc){
        bw.write("not a function");
      } else {
        if (injective && surjective){
          bw.write("bijective");
        } else if (injective){
          bw.write("injective");
        } else if (surjective){
          bw.write("surjective");
        } else {
          bw.write("neither injective nor surjective");
        }
      }
      bw.newLine();
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