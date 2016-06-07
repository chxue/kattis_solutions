
import java.util.*;
import java.io.*;

class multiplication{
  //Difficulty: 2.7
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      String a = Rd.next(), b = Rd.next();
      if (a.equals("0") && b.equals("0"))
        break;
      char[][] canvas = new char[4*b.length()+5][4*a.length()+5];
      buildFrame(canvas);
      writeNumbers(canvas, a, b);
      print (canvas, bw);
    }
    
    bw.flush();
  }
  public static void buildFrame(char[][] canvas){
    int i, j;
    for (i = 0; i < canvas.length; i++){
      for (j = 0; j < canvas[0].length; j++){
        if (i%4 == 2 && j%4 == 2)
          canvas[i][j] = '+';
        else if (i == 0 || i == canvas.length-1 || (i%4 == 2 && j >1 && j < canvas[0].length-2))
          canvas[i][j] = '-';
        else if (j == 0 || j == canvas[0].length-1 || (j%4 == 2 && i>1 && i < canvas.length-2))
          canvas[i][j] = '|';
        else if ((i+j)%4 == 0 && i > 2 && i < canvas.length-3 && j > 2 && j < canvas[0].length-3)
          canvas[i][j] = '/';
        else
          canvas[i][j] = ' ';
      }
    }
    canvas[0][0] = canvas[0][canvas[0].length-1] = canvas[canvas.length-1][0] 
      = canvas[canvas.length-1][canvas[0].length-1] = '+';
  }
  
  public static void writeNumbers(char[][] canvas, String a, String b){
    int al = a.length(), bl = b.length(), i, j;
    int[] adigits = new int[al], bdigits = new int[bl];
    for (i = 0; i < al; i++){
      canvas[1][i*4+4] = a.charAt(i);
      adigits[i] = a.charAt(i)-'0';
    }
    for (i = 0; i < bl; i++){
      canvas[i*4+4][canvas[0].length-2] = b.charAt(i);
      bdigits[i] = b.charAt(i)-'0';
    }
    for (i = 0; i < al; i++){
      for (j = 0; j < bl; j++){
        int res = adigits[i]*bdigits[j], r = j*4+3,c = i*4+3;
        canvas[r][c] = (char)(res/10+'0');
        canvas[r+2][c+2] = (char)(res%10+'0');
      }
    }
    int r = canvas.length-4, c = canvas[0].length-4, sum, carry = 0;
    while (c > 2){
      sum = 0;
      int cr = r, cc = c;
      while (cr < canvas.length-3 && cc > 2){
        sum += canvas[cr][cc]-'0';
        cr += 2;
        cc -= 2;
      }
      sum += carry;
      carry = sum/10;
      sum %= 10;
      canvas[cr][cc] = (char)(sum+'0');
      r -= 4;
      while (r < 2){
        r += 2;
        c -= 2;
      }
    }
    r = 5;
    c = 1;
    boolean leading0 = true;
    while (c < canvas[0].length-4){
      
      if (canvas[r][c] == '0' && leading0){
        canvas[r][c] = ' ';
      } else if (canvas[r][c] == ' '){
        if (!leading0)
          canvas[r][c] = '/';
      } else if (canvas[r][c]!= '0'){
        leading0 = false;
      }
      if (r < canvas.length-2){
        r += 2;
      } else {
        c += 2;
      }
    }
      
  }
  public static void print(char[][] canvas, BufferedWriter bw) throws IOException{
    for (char[] charSeq: canvas){
      bw.write(new String(charSeq));
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