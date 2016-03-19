import java.util.*;
import java.io.*;
class rockpaperscissors{
  //Difficulty: 3.4
  //important lesson: always use .equals instead of == for string equality.
  public static void main(String[] args){
    Rd.init(System.in);
    try{
      while (true){
        int n = Rd.nextInt();
        if (n == 0){
          return;
        }
        int k = Rd.nextInt(), games = k*n*(n-1)/2;
        int[][] record = new int[n][2];
        for (int i = 0; i < games; i++){
          game(Rd.nextInt()-1, Rd.next(), Rd.nextInt()-1, Rd.next(), record);
        }
        for (int i = 0; i < n; i++){
          int win = record[i][0], total = record[i][1];
          if (total == 0){
            System.out.println("-");
          } else {
            System.out.format("%.3f\n", win*1.0/total);
          }
        }
        System.out.println();
      }
    } catch (IOException e){
      System.exit(-1);
    }
  }
  
  public static void game(int a, String amove, int b, String bmove, int[][] record){
    if (!amove.equals(bmove)){
      record[a][1]++;
      record[b][1]++;
      if (win(amove, bmove)){
        record[a][0]++;
      } else {
        record[b][0]++;
      }
    }
    return;
  }
  
  public static boolean win(String amove, String bmove){
    return (amove.equals("rock") && bmove.equals("scissors"))||
      (amove.equals("scissors") && bmove.equals("paper"))||
      (amove.equals("paper") && bmove.equals("rock"));
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
  
  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
  
  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }
}