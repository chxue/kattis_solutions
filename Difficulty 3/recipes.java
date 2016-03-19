
import java.util.*;
import java.io.*;

class recipes{
  //Difficulty: 2.1
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(),i,j;
    for (i = 0; i < t; i++){
      int n = Rd.nextInt(), written = Rd.nextInt(), desired = Rd.nextInt();
      Ingredient[] ingredients = new Ingredient[n];
      double scale = 1.0 * desired/written, main = 0.0;
      for (j = 0; j < n; j++){
        String name = Rd.next();
        double weight = Rd.nextDouble(), percentage = Rd.nextDouble();
        ingredients[j] = new Ingredient(name, percentage);
        if (percentage == 100)
          main = weight * scale;
      }
      bw.write(String.format("Recipe # %d\n", i+1));
      for (Ingredient in: ingredients){
        bw.write(String.format("%s %.1f\n", in.n, in.p*main/100.0));
      }
      bw.write("----------------------------------------\n");         
    }
    bw.flush();
  }
}
class Ingredient{
  String n;
  double p;
  public Ingredient(String name, double percentage){
    n = name;
    p = percentage;
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