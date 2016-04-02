
import java.util.*;
import java.io.*;

class karte{
  //Difficulty: 2.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Deck d = new Deck(Rd.nextLine());
    int[] missing = {13, 13, 13, 13};
    Set<String> cards = new HashSet<String>();
    while (d.hasNext()){
      String card = d.getNext();
      char suit = card.charAt(0);
      if (cards.contains(card)){
        System.out.println("GRESKA");
        return;
      }
      cards.add(card);
      if (suit == 'P'){
        missing[0]--;
      } else if (suit == 'K'){
        missing[1]--;
      } else if (suit == 'H'){
        missing[2]--;
      } else {
        missing[3]--;
      }
    }
    System.out.format("%d %d %d %d", missing[0],missing[1],missing[2],missing[3]);
  }
  
  public static class Deck{
    String dc;
    int i;
    public Deck(String dc){
      this.dc = dc;
      i = 0;
    }
    public boolean hasNext(){
      return i < dc.length();
    }
    
    public String getNext(){
      i += 3;
      return dc.substring(i-3, i);
    }
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