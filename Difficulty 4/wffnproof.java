
import java.util.*;
import java.io.*;

class wffnproof{
  //Difficulty: 3.7
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s;
    int i, neg;
    while (!(s = Rd.nextLine()).equals("0")){
      neg = 0;
      List<Character> lit = new ArrayList<Character>(), op = new ArrayList<Character>();
      StringBuilder sb = new StringBuilder();
      for (i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if (c == 'N')
          neg++;
        else if (c >= 'p' && c <= 't')
          lit.add(c);
        else
          op.add(c);
      }
      if (lit.size() == 0){
        bw.write("no WFF possible\n");
        continue;
      }
      int l = Math.min(lit.size()-1, op.size());
      if (neg-- > 0)
        sb.append('N');
      sb.append(lit.get(0));
      for (i = 0; i < l; i++){
        if (neg-- > 0)
          sb.append('N');
        sb.append(lit.get(i+1));
        sb.insert(0, op.get(i));
        if (neg-- > 0)
          sb.insert(0, 'N');
      }
      bw.write(sb.toString());
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