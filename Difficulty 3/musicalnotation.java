
import java.util.*;
import java.io.*;

class musicalnotation{
  //Difficulty: 2.1
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt(), i, j, k;
    char[] symb = {'G','F','E','D','C','B','A','g','f','e','d','c','b','a'}, staff = {'F','D','B','g','e','a'};
    StringBuilder[] notes = new StringBuilder[symb.length];
    for (i = 0; i < notes.length; i++){
      notes[i] = new StringBuilder();
    }
    Set<Character> staffs = new HashSet<Character>();
    for (char c: staff){
      staffs.add(c);
    }
    for (i = 0; i < n; i++){
      String nextNote = Rd.next();
      char next = nextNote.charAt(0);
      int l = 1;
      if (nextNote.length() > 1){
        l = Integer.parseInt(nextNote.substring(1));
      }
      for (j = 0; j < symb.length; j++){
        char space = ' ';
        if (staffs.contains(symb[j])){
          space = '-';
        }
        if (symb[j] == next){
          for (k = 0; k < l; k++){
            notes[j].append('*');
          }
        } else {
          for (k = 0; k < l; k++){
            notes[j].append(space);
          }
        }
        if (i != n-1){
          notes[j].append(space);
        }
      }
    }
    for (i = 0; i < symb.length; i++){
      bw.write(String.format("%c: %s\n",symb[i],notes[i].toString()));
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