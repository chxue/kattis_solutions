
import java.util.*;
import java.io.*;

class imagedecoding{
  //Difficulty: 2.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    boolean start = true;//trim the end line
    while (true){
      int n = Rd.nextInt(), i, j, imgL = 0;
      if (n == 0){
        break;
      }
      if (!start){
        bw.newLine();
      } else {
        start = false;
      }
      boolean error = false;
      for (i = 0; i < n; i++){
        String[] line = Rd.nextLine().split(" ");
        int length = 0;
        Pixel p = new Pixel(line[0].charAt(0));
        for (j = 1; j < line.length; j++){
          int l = Integer.parseInt(line[j]);
          length += l;
          p.print(bw, l);
          p.next();
        }
        if (i == 0)
          imgL = length;
        if (length != imgL)
          error = true;
        bw.newLine();
      }
      if (error)
        bw.write("Error decoding image\n");
    }
    bw.flush();
  }
}

class Pixel{
  char c;
  public Pixel(char c){
    this.c = c;
  }
  
  public void next(){
    if (c == '#'){
      c = '.';
    } else {
      c = '#';
    }
  }
  
  public void print(BufferedWriter bw, int n) throws IOException{
    for (int i = 0; i < n; i++){
      bw.write(c);
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