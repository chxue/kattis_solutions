
import java.util.*;
import java.io.*;

class gettowork{
  //Difficulty: 3.2
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, j;
    for (i = 0; i < t; i++){
      int n = Rd.nextInt(), office = Rd.nextInt()-1, e = Rd.nextInt();
      boolean possible = true;
      int[] workers = new int[n], needCars = new int[n];
      List<Queue<Integer>> cars = new ArrayList<Queue<Integer>>();
      for (j = 0; j < n; j++){
        cars.add(new PriorityQueue<Integer>(e, Collections.reverseOrder()));
      }
      for (j = 0; j < e; j++){
        int town = Rd.nextInt()-1, cap = Rd.nextInt();
        cars.get(town).add(cap);
        workers[town]++;
      }
      for (j = 0; j < n ; j++){
        if (possible && j != office){
          while (workers[j] > 0){
            
            if (cars.get(j).peek() == null){
              possible = false;
              break;
            }
            int currentCap = cars.get(j).poll();
            workers[j] -= currentCap;
            needCars[j]++;
          }
        }
      }
      StringBuilder sb = new StringBuilder();
      for (int c: needCars){
        sb.append(" " + c);
      }
      System.out.format("Case #%d:%s\n", i+1, possible?sb.toString():" IMPOSSIBLE");
    }
    bw.flush();
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