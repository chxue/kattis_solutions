import java.util.*;
import java.io.*;
class fenwick{
  //Difficulty: 4.4
  //important lesson: Binary Indexed Tree. https://www.youtube.com/watch?v=CWDQJGaN1gY&index=5&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu
  //Use BufferedWriter to buffer output.
  public static void main(String[] args){
    Rd.init(System.in);
    try{
      int size = Rd.nextInt(), q = Rd.nextInt();
      Tree t = new Tree(size);
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      for (int i = 0; i < q; i++){
        String operation = Rd.next(); 
        int pos = Rd.nextInt();
        if (operation.equals("+")){
          t.update(pos+1, Rd.nextInt());
        } else {
          bw.write(t.query(pos) + "\n");
        }
      }
      bw.flush();
    } catch (IOException e){
      System.exit(-1);
    }
  }
}
class Tree{
  long[] tree;
  public Tree(int size){
    this.tree = new long[size+1];
  }
  
  public void update(int pos, int incre){
    while (pos < this.tree.length){
      this.tree[pos] += incre;
      pos += pos & -pos;
    }
  }
  
  public long query(int pos){
    long sum = 0;
    while (pos > 0){
      sum += this.tree[pos];
      pos -= pos & -pos;
    }
    return sum;
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
      tokenizer = new StringTokenizer(reader.readLine());
    }
    return tokenizer.nextToken();
  }
  
  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
}