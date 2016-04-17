
import java.util.*;
import java.io.*;

class kinarow{
  //Difficulty: 3.3
  public static int hansel = 0, gretel = 0;
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, j;
    boolean done;
    for (i = 0; i < t; i++){
      int m = Rd.nextInt(), n = Rd.nextInt(), k= Rd.nextInt();
      done = false;
      char[][] b = new char[n][m];
      for (j = 0; j < n; j++){
        b[j] = Rd.nextLine().toCharArray();
      }
      countWins(b, k);
    }
    bw.write(String.format("%d:%d", hansel, gretel));
    bw.flush();
  }
  
  public static void countWins(char[][] b, int k){
    int i, j;
    if (k <= b.length && k <= b[0].length){
      for (i = 0; i < b.length - k + 1; i++){
        for (j = 0; j < b[0].length - k + 1; j++){
          if (checkDiag1(b, i, j, k)){
            if (b[i][j] == 'x')
              hansel++;
            else
              gretel++;
            return;
          }
        }
      }
      for (i = k-1; i < b.length; i++){
        for (j = 0; j < b[0].length - k +1; j++){
          if (checkDiag2(b, i, j, k)){
            if (b[i][j] == 'x')
              hansel++;
            else
              gretel++;
            return;
          }
        }
    }
    }
    if (k <= b[0].length){
      for (i = 0; i < b.length; i++){
        for (j = 0; j < b[0].length - k + 1; j++){
          if (checkHorizontal(b, i, j, k)){
            if (b[i][j] == 'x')
              hansel++;
            else
              gretel++;
            return;
          }
        }
      }
    }
    if (k <= b.length){
      for (i = 0; i < b.length-k+1; i++){
        for (j = 0; j < b[0].length; j++){
          if (checkVertical(b, i, j, k)){
            if (b[i][j] == 'x')
              hansel++;
            else 
              gretel++;
            return;
          }
        }
      }
    }
  }
  
  public static boolean checkDiag1(char[][] b, int row, int col, int k){
    char c = b[row][col];
    if (c == '.')
      return false;
    for (int i = 1; i < k; i++){
      if (b[row+i][col+i] != c)
        return false;
    }
    return true;
  }
  
  public static boolean checkDiag2(char[][] b, int row, int col, int k){
    char c = b[row][col];
    if (c == '.')
      return false;
    for (int i = 1; i < k; i++){
      if (b[row-i][col+i] != c)
        return false;
    }
    return true;
  }
  
  public static boolean checkHorizontal(char[][] b, int row, int col, int k){
    char c = b[row][col];
    if (c == '.')
      return false;
    for (int i = 1; i < k; i++){
      if (b[row][col+i] != c)
        return false;
    }
    return true;
  }
  
  public static boolean checkVertical(char[][] b, int row, int col, int k){
    char c = b[row][col];
    if (c == '.')
      return false;
    for (int i = 1; i < k; i++){
      if (b[row+i][col] != c)
        return false;
    }
    return true;
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