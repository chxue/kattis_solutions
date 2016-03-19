import java.util.*;
import java.io.*;

class sidewayssorting{
  //Difficulty: 2.8
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      int r = Rd.nextInt(), c = Rd.nextInt();
      if (r == 0){
        break;
      }
      Word[] words = new Word[c];
      for (int i = 0; i < c; i++){
        words[i] = new Word();
      }
      for (int i = 0; i < r; i++){
        String line = Rd.next();
        for (int j = 0; j < c; j++){
          words[j].add(line.charAt(j));
        }
      }
      Arrays.sort(words);
      for (int i = 0; i < r; i++){
        for (int j = 0; j < c; j++){
          bw.write(words[j].get(i));
        }
        bw.newLine();
      }
      bw.newLine();
    }
    bw.flush();
  }
}

class Word implements Comparable<Word>{
  List<Character> chars;
  public Word(){
    this.chars = new ArrayList<Character>();
  }
  public String toString(){
    StringBuilder sb = new StringBuilder();
    for (char c: chars){
      sb.append(c);
    }
    return sb.toString();
  }
  public void add(char c){
    this.chars.add(c);
  }
  
  public char get(int i){
    return this.chars.get(i);
  }
  
  public int compareTo(Word other){
    if (this.chars.size() == 0)
      return -1;
    if (other.chars.size() == 0)
      return 1;
    String s1 = this.toString().toLowerCase(), s2 = other.toString().toLowerCase();
    return s1.compareTo(s2);
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
  
  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
  
}