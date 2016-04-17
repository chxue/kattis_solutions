
import java.util.*;
import java.io.*;

class primepath{
  //Difficulty: 2.8
  public static boolean[] primes = new boolean[10000];
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    initialize();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i;
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    for (i = 1001; i < 10000; i+=2){
      if (primes[i]){
        map.put(i, neighbors(i));
      }
    }
    for (i = 0; i < t; i++){
      int from = Rd.nextInt(), to = Rd.nextInt();
      Queue<Long> toVisit = new LinkedList<Long>();
      toVisit.add((long)from);
      boolean[] visited = new boolean[10000];
      while (toVisit.peek() != null){
        long next = toVisit.poll(), s = next >> 32;        
        int v = (int)next;
        //System.out.println(v + "," + s);
        if (v == to){
          System.out.println(s);
          break;
        }
        visited[v] = true;
        for (int u: map.get(v)){
          if (!visited[u]){
            toVisit.add(((s+1)<<32) + u);
          }
        }
      }
    }
    bw.flush();
  }
  
  public static List<Integer> neighbors(int n){
    List<Integer> res = new ArrayList<Integer>();
    int digit, num = n, i, j, toAdd = 1;
    for (i = 0; i < 4; i++){
      digit = num % 10;
      num /= 10;
      for (j = 1; j < 10; j++){
        int newNum = n + toAdd * j;
        if (j >= 10 - digit){
          newNum -= toAdd*10;
        }
        if (newNum >= 1000 && primes[newNum])
          res.add(newNum);
      }
      toAdd *= 10;
    }
    return res;
  }
      
  public static void initialize(){
    Arrays.fill(primes, true);
    int i, j;
    for (i = 1000; i < primes.length; i+= 2){
      primes[i] = false;
    }
    for (i = 3; i < primes.length; i += 2){
      if (primes[i]){
        for (j = i * i; j < primes.length; j+= 2* i){
          primes[j] = false;
        }
      }
    }
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