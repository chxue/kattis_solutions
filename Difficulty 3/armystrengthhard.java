import java.util.*;
import java.io.*;
class armystrengthhard{
  //Difficulty: 2.7
  //important lesson: scanner is really slow! Use bufferedReader when dealing with huge amount of inputs.
  public static void main(String[] args){
    try{
      Reader.init(System.in);
      int t = Reader.nextInt();
      for (int i = 0; i < t; i++){
        int m = Reader.nextInt(), n = Reader.nextInt(), maxM = 0, maxN = 0;
        for (int j = 0; j < m; j++){
          int newMonster = Reader.nextInt();
          if (newMonster > maxM){
            maxM = newMonster;
          }
        }
        for (int j = 0; j < n; j++){
          int newMonster = Reader.nextInt();
          if (newMonster > maxN){
            maxN = newMonster;
          }
        }
        System.out.println(maxM >= maxN? "Godzilla": "MechaGodzilla");
      }
    } catch (IOException e){
      System.exit(-1);
    }
  }
}
class Reader {
  static BufferedReader reader;
  static StringTokenizer tokenizer;
  
  /** call this method to initialize reader for InputStream */
  static void init(InputStream input) {
    reader = new BufferedReader(
                                new InputStreamReader(input) );
    tokenizer = new StringTokenizer("");
  }
  
  /** get next word */
  static String next() throws IOException {
    while ( ! tokenizer.hasMoreTokens() ) {
      //TODO add check for eof if necessary
      tokenizer = new StringTokenizer(
                                      reader.readLine() );
    }
    return tokenizer.nextToken();
  }
  
  static int nextInt() throws IOException {
    return Integer.parseInt( next() );
  }
  
  static double nextDouble() throws IOException {
    return Double.parseDouble( next() );
  }
}