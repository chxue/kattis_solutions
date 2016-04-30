
import java.util.*;
import java.io.*;

class unionfind{
  //Difficulty: 3.3
  //important lesson: flatten the tree while searching for head. always attach smaller tree to bigger tree.
  public static int[] head, size;
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt(), q = Rd.nextInt(), i;
    head = new int[n];
    size = new int[n];
    for (i = 0; i < n; i++){
      head[i] = i;
    }
    for (i = 0; i < q; i++){
      String op = Rd.next();
      int a = Rd.nextInt(), b = Rd.nextInt();
      if (op.equals("?"))
        bw.write(find(a, b)?"yes\n":"no\n");
      else 
        union(a, b);
    }
    
    bw.flush();
  }
  
  public static void union(int a, int b){
    int aHead = getHead(a), bHead = getHead(b);
    if (aHead != bHead){
      if (size[aHead] <= size[bHead]){
        head[aHead] = bHead;
        size[bHead] += size[aHead];
      } else {
        head[bHead] = aHead;
        size[aHead] += size[bHead];
      }
    }
  }
  
  public static boolean find(int a, int b){
    return getHead(a) == getHead(b);
  }
  
  public static int getHead(int i){
    //Stack<Integer> traversed = new Stack<Integer>();
    while (head[i] != i){
      head[i] = head[head[i]];
      i = head[i];
      
      //traversed.add(i);
    }
    return i;
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