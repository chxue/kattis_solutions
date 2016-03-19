
import java.util.*;
import java.io.*;

class allaboutthatbase{
  //Difficulty: 3.0
  public static Map<Character, Integer> value = new HashMap<Character, Integer>();
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, j;
    
    for (i = 0; i < 10; i++)
      value.put((char)(i+'0'), i);
    value.put('+', -1);
    value.put('-', -1);
    value.put('*', -1);
    value.put('/', -1);
    value.put('=', -1);
    value.put(' ', -1);
    for (i = 0; i < 26; i++)
      value.put((char)(i+'a'), 10 + i);
    
    for (i = 0; i < t; i++){
      String l = Rd.nextLine();
      int s = 0;
      for (j = 0; j < l.length(); j++){
        char c = l.charAt(j);
        int ord = value.get(c);
        if (ord > s)
          s = ord;
      }
      String[] line = l.split(" ");
      StringBuilder answers = new StringBuilder();
      //System.out.println(s);
      if (s != 1 || l.indexOf('0') != -1){
        s++;
      }
      for (j = s; j < 37; j++){
        boolean valid = false;
        long a = convert(line[0], j), b = convert(line[2], j), c = convert(line[4], j);
        //System.out.println("a, b, c are:" + a + "," + b + "," + c);
        if (line[1].equals("+")){
          valid = (a + b == c)? true: false;
        } else if (line[1].equals("-")){
          valid = (a - b == c)? true: false;
        } else if (line[1].equals("*")){
          valid = (a * b == c)? true: false;
        } else {
          valid = (b * c == a)? true: false;
        }
        //System.out.println(j + ":" + valid);
        if (valid)
          answers.append(charOf(j));
      }
      //System.out.println(answers.toString());
      //System.out.println("length: " + answers.length());
      if (answers.length() == 0){
        answers.append("invalid");
      }
      answers.append("\n");
      bw.write(answers.toString());
    }
          
    bw.flush();
  }
  
  public static long convert(String num, int base){
    int cur = 1, sum = 0;
    for (int i = num.length()-1; i>=0; i--){
      sum += value.get(num.charAt(i))*cur;
      cur *= base;
    }
    return sum;
  }
  
  public static char charOf(int ord){
    if (ord < 10){
      return (char)(ord + '0');
    }
    if (ord == 36){
      return '0';
    }
    return (char)(ord-10+'a');
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