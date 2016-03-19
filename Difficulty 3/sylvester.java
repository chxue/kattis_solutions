
import java.util.*;
import java.io.*;

class sylvester{
  //Difficulty: 2.1
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, row, col;
    for (i = 0 ; i < t; i++){
      long size = Rd.nextLong(), x = Rd.nextLong(), y = Rd.nextLong(), 
        w = Rd.nextLong(), h = Rd.nextLong();
      for (row = 0; row < h; row++){
        for (col = 0; col < w; col++){
          //System.out.println("inloop");
          bw.write(sign(col+x, row+y, size) + " ");
        }
        bw.newLine();
      }
      bw.newLine();
    } 
    bw.flush();
  }
  
  public static int sign(long col, long row, long size){
    int sign = 1;
    while (size > col && size > row){
      //System.out.format("%d,%d,%d\n", col, row, size);
      size = size >> 1;
    }
    while (col != 0 || row != 0){
      //System.out.format("new: %d,%d,%d\n", col, row, size);
      //System.out.println((col >= size) + "," + (row >= size));
      if (col >= size && row >= size){
        col -= size;
        row -= size;
        sign *= -1;
      } else if (col >= size){
        //System.out.println("col big");
        col -= size;
      } else if (row >= size){
        //System.out.println("row big");
        row -= size;
      } else {
        size = size >> 1;
      }
    }
    return sign;
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