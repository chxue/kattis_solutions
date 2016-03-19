import java.util.*;
import java.io.*;
class almostunionfind{
  //Difficulty: 4.9
  public static void main(String[] args){
    Rd.init(System.in);
    try{
      while (true){
        try{
          int n = Rd.nextInt(), m = Rd.nextInt();
          int[] sets = new int[n];
          int[][] record = new int[n][2];
          for (int i = 0; i < n; i++){
            sets[i] = i;
            record[i][0] = 1;
            record[i][1] = i+1;
          }
          for (int i = 0; i < m; i++){
            int command = Rd.nextInt(), p = Rd.nextInt()-1, root = sets[p];
            if (command == 3){
              System.out.println(record[root][0] + " " + record[root][1]);
            } else {
              int q = Rd.nextInt()-1, root2 = sets[q];
              if (root != root2){
                if (command == 1){
                  for (int j = 0; j < n; j++){
                    if (sets[j] == root){
                      sets[j] = root2;
                      record[root2][0]++;
                      record[root2][1]+= j+1;
                    }
                  }
                } else {
                  sets[p] = root2;
                  record[root2][0]++;
                  record[root][0]--;
                  record[root2][1] += p+1;
                  record[root][1] -= p+1;
                }
              }
            }
          }
        } catch (NullPointerException e1){
          break;
        }
      }
    } catch (IOException e){
      System.exit(-1);
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
  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
  
  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }
}