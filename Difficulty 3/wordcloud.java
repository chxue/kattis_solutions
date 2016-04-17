
import java.util.*;
import java.io.*;

class wordcloud{
  //Difficulty: 2.5
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = 1;
    while (true){
      int w = Rd.nextInt(), n = Rd.nextInt(), curW = w, maxH = 0, h = 0, maxOccur = 0, i, p, l;
      if (w == 0 && n == 0)
        break;
      Word[] words = new Word[n];
      for (i = 0; i < n; i++){
        words[i] = new Word(Rd.nextLine());
        if (words[i].occur > maxOccur)
          maxOccur = words[i].occur;
      }
      for (i = 0; i < n; i++){
        p = words[i].size(maxOccur);
        l = (int)Math.ceil(9.0/16*words[i].name.length()*p);
        curW += l + 10;
        if (curW > w){
          curW = l;
          h += maxH;
          maxH = p;
        }
        if (p > maxH)
          maxH = p;
      }
      h += maxH;
      bw.write(String.format("CLOUD %d: %d\n", t++, h));
    }
    bw.flush();
  }
}

class Word{
  String name;
  int occur;
  public Word(String s){
    String[] sa = s.split(" ");
    name = sa[0];
    occur = Integer.parseInt(sa[1]);
  }
  
  public int size(int maxOccur){
    return 8 + (int)Math.ceil(40.0*(occur-4)/(maxOccur-4));
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