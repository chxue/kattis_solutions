
import java.util.*;
import java.io.*;

class officespace{
  //Difficulty: 2.8
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (Rd.hasMoreTokens()){
      int w = Rd.nextInt(), h = Rd.nextInt(), total = w * h, contested = 0;
      int[][] space = new int[w][h];
      int n = Rd.nextInt(), i;
      String[] names = new String[n];
      int[] occupied = new int[n];
      for (i = 0; i < n; i++){
        names[i] = Rd.next();
        int lx = Rd.nextInt(), ly = Rd.nextInt(), 
          ux = Rd.nextInt(), uy = Rd.nextInt(), x, y;
        for (x = lx; x < ux; x++){
          for (y = ly; y < uy; y++){
            if (space[x][y] == 0){
              space[x][y] = i+1;
              occupied[i]++;
            } else if (space[x][y] > 0){
              occupied[space[x][y]-1]--;
              space[x][y] = -1;
              contested++;
            }
          }
        }
      }
      bw.write(String.format("Total %d\n", total));
      total -= contested;
      for (int o: occupied)
        total -= o;
      bw.write(String.format("Unallocated %d\nContested %d\n", total, contested));
      for (i = 0; i < n; i++){
        bw.write(String.format("%s %d\n", names[i], occupied[i]));
      }
      bw.newLine();
      //bw.flush();
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