
import java.util.*;
import java.io.*;

class P4thought{
  //Difficulty: 3.3
  public static char[] operators = {'+','-','*','/'};
  public static Map<Integer, String> res = new HashMap<Integer, String>();
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i;
    listAllRes(0, new char[3]);
    for (i = 0; i < t; i++){
      int n = Rd.nextInt();
      bw.write(solve(n) + "\n");
    }
    
    bw.flush();
  }
  
  public static void listAllRes(int i, char[] ops){
    int j;
    if (i == 3){
      Stack<Integer> nums = new Stack<Integer>();
      Stack<Integer> nums2 = new Stack<Integer>();
      StringBuilder sb = new StringBuilder();
      for (char op: ops){
        sb.append("4 ");
        sb.append(op + " ");
      }
      sb.append("4 = ");
      
      nums.add(4);
      for (j = 0; j < 3; j++){
        if (ops[j] == '*'){
          nums.add(nums.pop() * 4);
        } else if (ops[j] == '/'){
          nums.add(nums.pop() / 4);
        } else {
          nums.add(4);
        }
      }
      while (!nums.empty()){
        nums2.add(nums.pop());
      }
      int returnVal = nums2.pop();
      for (j = 0; j < 3; j++){
        if (ops[j] == '+'){
          returnVal += nums2.pop();
        } else if (ops[j] == '-'){
          returnVal -= nums2.pop();
        }
      }
      sb.append(returnVal);
      res.put(returnVal, sb.toString());
      return;
    }
    for (j = 0; j < 4; j++){
      ops[i] = operators[j];
      listAllRes(i+1, ops);
    }
    return;
  }
  public static String solve(int n){
    if (res.keySet().contains(n)){
      return res.get(n);
    }
    return "no solution";
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