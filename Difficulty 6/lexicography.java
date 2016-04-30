
import java.util.*;
import java.io.*;
import java.math.BigInteger;
class lexicography{
  //Difficulty: 6.2
  public static long[] fact = new long[16];
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    int i;
    fact[0] = 1;
    for (i = 1; i < 16; i++){
      fact[i] = fact[i-1]*i;
    }
    int[] freq = new int[26];
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true){
      char[] s = Rd.next().toCharArray();
      long n = Rd.nextLong()-1;
      int l = s.length;
      if (s[0] == '#' && n == -1)
        break;
      Arrays.fill(freq, 0);
      for (char c: s){
        freq[c-'A']++;
      }
      bw.write(buildAnagram(freq, n, l, new StringBuilder()));
      bw.newLine();
    }
        
    bw.flush();
  }
  
  public static String buildAnagram(int[] freq, long index, int l, StringBuilder sb){
    if (l == 0)
      return sb.toString();
    List<Long> cumulative = convert(freq, l-1);
    //System.out.println(cumulative);
    int charIndex = binarySearch(cumulative, index, 0, cumulative.size());
    update(freq, charIndex, sb);
    return buildAnagram(freq, index - cumulative.get(charIndex), l-1, sb);
  }
  
  public static List<Long> convert(int[] freq, int l){
    List<Long> res = new ArrayList<Long>();
    res.add(0L);
    long div = 1;
    int i;
    for (i = 0; i < 26; i++){
      div *= fact[freq[i]];
    }
    for (i = 0; i < 26; i++){
      if (freq[i] != 0)
        res.add(res.get(res.size()-1) + fact[l]*freq[i]/div);
    }
    return res;
  }
  
  public static int binarySearch(List<Long> ls, long l, int start, int end){
    if (start >= end - 1)
      return start;
    int mid = (start+end)/2;
    long midValue = ls.get(mid);
    if (midValue > l){
      end = mid;
    } else {
      start = mid;
    }
    return binarySearch(ls, l, start, end);
  }
  
  public static void update(int[] freq, int index, StringBuilder sb){
    int i;
    for (i = 0; i < 26; i++){
      if (freq[i] != 0){
        index--;
      }
      if (index < 0){
        freq[i]--;
        sb.append((char)('A' + i));
        return;
      }
    }
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