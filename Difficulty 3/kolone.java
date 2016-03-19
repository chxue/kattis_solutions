import java.util.*;
import java.io.*;

class kolone{
  //Difficulty: 2.1
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n1 = Rd.nextInt(), n2 = Rd.nextInt();
    String q1 = Rd.next(), q2 = Rd.next();
    int t = Rd.nextInt(), pos = 0;
    List<Letter> letters = new ArrayList<Letter>();
    for (int i = 0; i < n1; i++){
      letters.add(new Letter(q1.charAt(n1-i-1), pos + t));
      pos += 2;
    }
    pos--;
    for (int i = 0; i < n2; i++){
      letters.add(new Letter(q2.charAt(i), pos - t));
      pos += 2;
    }
    Collections.sort(letters);
    StringBuilder sb = new StringBuilder();
    for (Letter l: letters){
      sb.append(l.c);
    }
    bw.write(sb.toString());
    bw.flush();
  }
}

class Letter implements Comparable<Letter>{
  char c;
  int pos;
  public Letter(char c, int pos){
    this.c = c;
    this.pos = pos;
  }
  
  public int compareTo(Letter other){
    return this.pos - other.pos;
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