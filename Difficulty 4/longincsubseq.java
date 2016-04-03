
import java.util.*;
import java.io.*;

class longincsubseq{
  //Difficulty: 3.2
  //important lesson: longest increasing subsequence algorithm in N*logN time. There is also an easier implementation with N^2 time.
  //youtube video: https://www.youtube.com/watch?v=S9oUiVYEq7E&ebc=ANyPxKrfJDfpFm5A8NfBmqyHSf_lxlEmx85Nqd6bXCBqt1OKYVFvTbCYFsXaccMfLYHPp_lylyKLQ6p0Q3VVQWjN54UTOcuSBw
  //implementation: https://sites.google.com/site/indy256/algo/lis_nlogn
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (sc.hasNextInt()){
      int n = sc.nextInt(), i;
      int[] seq = new int[n];
      for (i = 0; i < n; i++){
        seq[i] = sc.nextInt();
      }
      int[] res = lis(seq);
      bw.write(res.length+"\n");
      for (int x: res){
        bw.write(x + " ");
      }
      bw.newLine();
      bw.flush();
    }
    bw.flush();
  }
  public static int[] lis(int[] a) {
    int n = a.length;
    int[] tail = new int[n];
    int[] prev = new int[n];

    int len = 0;
    for (int i = 0; i < n; i++) {
      int pos = lower_bound(a, tail, len, a[i]);
      if (pos == len) {
        ++len;
      }
      prev[i] = pos > 0 ? tail[pos - 1] : -1;
      tail[pos] = i;
    }

    int[] res = new int[len];
    for (int i = tail[len - 1]; i >= 0; i = prev[i]) {
      res[--len] = i;
    }
    return res;
  }

  static int lower_bound(int[] a, int[] tail, int len, int key) {
    int lo = -1;
    int hi = len;
    while (hi - lo > 1) {
      int mid = (lo + hi) >>> 1;
      if (a[tail[mid]] < key) {
        lo = mid;
      } else {
        hi = mid;
      }
    }
    return hi;
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