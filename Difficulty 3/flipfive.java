
import java.util.*;
import java.io.*;

class flipfive{
  //Difficulty: 2.6
  public static Map<String, Integer> map = new HashMap<String, Integer>();
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    map.put(".........",0);
    constructMap(new int[9], 0, 0);
    int t = Rd.nextInt();
    for (int i = 0; i < t; i++){
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < 3; j++){
        sb.append(Rd.next());
      }
      bw.write(map.get(sb.toString()) + "\n");
    }
    bw.flush();
  }
  
  public static void constructMap(int[] flipped, int pos, int numFlips){
    if (pos == flipped.length)
      return;
    //System.out.println("{");
    constructMap(flipped, pos+1, numFlips);
    //System.out.println("}\n{");
    flip(flipped, pos);
    String key = stringOf(flipped);
    //System.out.println("Flipping position: "+ pos);
    //System.out.println(key + ":" + numFlips);
    map.put(key, numFlips+1);
    constructMap(flipped, pos+1, numFlips+1);
    //System.out.println("}");
    flip(flipped, pos);
    return;
  }
  
  public static void flip(int[] flipped, int pos){
    flipped[pos] = (flipped[pos] + 1) % 2;
    if (pos % 3 != 2){
      flipped[pos+1] = (flipped[pos+1] + 1) % 2;
    }
    if (pos % 3 != 0){
      flipped[pos-1] = (flipped[pos-1] + 1) % 2;
    }
    if (pos > 2){
      flipped[pos-3] = (flipped[pos-3] + 1) % 2;
    }
    if (pos < 6){
      flipped[pos+3] = (flipped[pos+3] + 1) % 2;
    }
  }
  
  public static String stringOf(int[] array){
    StringBuilder sb = new StringBuilder();
    for (int i: array){
      sb.append(i==1?"*":".");
    }
    return sb.toString();
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
}