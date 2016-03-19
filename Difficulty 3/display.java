
import java.util.*;
import java.io.*;

class display{
  //Difficulty: 2.5
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      String time = Rd.next();
      if (time.equals("end")){
        bw.write("end\n");
        break;
      }
      display(time, bw);
      bw.newLine();
      bw.newLine();
    }
    bw.flush();
  }
  
  public static void display(String time, BufferedWriter bw) throws IOException{
    char[][] digital = new char[7][29];
    for (int i = 0; i < digital.length; i++){
      Arrays.fill(digital[i], ' ');
    }
    int d1 = time.charAt(0) - '0', d2 = time.charAt(1) -'0',
      d3 = time.charAt(3) - '0', d4 = time.charAt(4) - '0';
    print(d1, 0, digital);
    print(d2, 7, digital);
    digital[2][14] = digital[4][14] = 'o';
    print(d3, 17, digital);
    print(d4, 24, digital);
    for (char[] r: digital){
      bw.write(new String(r));
      bw.newLine();
    }
  }
  
  public static void print(int d, int pos, char[][] display){
    int i;
    if (d == 0){
      for (i = 1; i < 4; i++){
        display[0][pos+i] = display[6][pos+i] = '-';
      }
      for (i = 1; i < 6; i++){
        display[i][pos] = display[i][pos+4] = '|';
      }
      for (i = 0; i < 7; i+=3){
        display[i][pos] = display[i][pos+4] = '+';
      }
      return;
    }
    if (d == 1){
      for (i = 1; i < 6; i++){
        display[i][pos+4] = '|';
      }
      for (i = 0; i < 7; i+=3){
        display[i][pos+4] = '+';
      }
      return;
    }
    if (d == 2){
      for (i = 1; i < 4; i++){
        display[0][pos+i] = display[3][pos+i] = display[6][pos+i] = '-';
      }
      display[1][pos+4] = display[2][pos+4] = display[4][pos] = display[5][pos] = '|';
      for (i = 0; i < 7; i+=3){
        display[i][pos] = display[i][pos+4] = '+';
      }
      return;
    }
    if (d == 3){
      for (i = 1; i < 4; i++){
        display[0][pos+i] = display[3][pos+i] = display[6][pos+i] = '-';
      }
      for (i = 1; i < 6; i++){
        display[i][pos+4] = '|';
      }
      for (i = 0; i < 7; i+=3){
        display[i][pos] = display[i][pos+4] = '+';
      }
      return;
    }
    if (d == 4){
      for (i = 1; i < 4; i++){
        display[3][pos+i] = '-';
      }
      for (i = 1; i < 6; i++){
        if (i < 3)
          display[i][pos] = '|';
        display[i][pos+4] = '|';
      }
      for (i = 0; i < 7; i+=3){
        display[i][pos] = display[i][pos+4] = '+';
      }
      display[6][pos] = ' ';
      return;
    }
    if (d == 5){
      for (i = 1; i < 4; i++){
        display[0][pos+i] = display[3][pos+i] = display[6][pos+i] = '-';
      }
      display[1][pos] = display[2][pos] = display[4][pos+4] = display[5][pos+4] = '|';
      for (i = 0; i < 7; i+=3){
        display[i][pos] = display[i][pos+4] = '+';
      }
      return;
    }
    if (d == 6){
      for (i = 1; i < 4; i++){
        display[0][pos+i] = display[3][pos+i] = display[6][pos+i] = '-';
      }
      for (i = 1; i < 6; i++){
        display[i][pos] = display[i][pos+4] = '|';
      }
      for (i = 0; i < 7; i+=3){
        display[i][pos] = display[i][pos+4] = '+';
      }
      display[1][pos+4] = display[2][pos+4] = ' ';
      return;
    }
    if (d == 7){
      for (i = 1; i < 4; i++){
        display[0][pos+i] = '-';
      }
      for (i = 1; i < 6; i++){
        display[i][pos+4] = '|';
      }
      for (i = 0; i < 7; i+=3){
        display[i][pos+4] = '+';
      }
      display[0][pos] = '+';
      return;
    }
    if (d == 8){
      for (i = 1; i < 4; i++){
        display[0][pos+i] = display[3][pos+i] = display[6][pos+i] = '-';
      }
      for (i = 1; i < 6; i++){
        display[i][pos] = display[i][pos+4] = '|';
      }
      for (i = 0; i < 7; i+=3){
        display[i][pos] = display[i][pos+4] = '+';
      }
      return;
    }
    if (d == 9){
      for (i = 1; i < 4; i++){
        display[0][pos+i] = display[3][pos+i] = display[6][pos+i] = '-';
      }
      for (i = 1; i < 6; i++){
        display[i][pos] = display[i][pos+4] = '|';
      }
      for (i = 0; i < 7; i+=3){
        display[i][pos] = display[i][pos+4] = '+';
      }
      display[4][pos] = display[5][pos] = ' ';
      return;
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
}