
import java.util.*;
import java.io.*;

class islands{
  //Difficulty: 2.1
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, j, k;
    for (i = 0; i < t; i++){
      //Set<Integer> values = new HashSet<Integer>();
      int[] stream = new int[12];
      Rd.nextInt();
      for (j = 0; j < 12; j++){
        stream[j] = Rd.nextInt();
        //values.add(stream[j]);
      }
      int cnt = 0, start, end, min;
      j = 1;
      while (stream[j] < stream[j-1])
        j++;
      start = j;
      j = 10;
      while (stream[j] < stream[j+1])
        j--;
      end = j;
      for (j = start; j <= end; j++){
        if (stream[j] > stream[j-1]){
          min = stream[j];
          for (k = j; k <= end; k++){
            if (stream[k] <= stream[j-1])
              break;
            if (stream[k] < min)
              min = stream[k];
            if (stream[k+1] < min)
              cnt++;
          }
        }
      }
      bw.write(String.format("%d %d\n", i+1, cnt));
    }
    bw.flush();
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