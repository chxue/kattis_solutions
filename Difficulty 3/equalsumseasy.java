
import java.util.*;
import java.io.*;

class equalsumseasy{
  //Difficulty: 2.6
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), n, i, j;
    Set<SumSet> s = new HashSet<SumSet>(), added = new HashSet<SumSet>();
    for (i = 0; i < t; i++){
      bw.write(String.format("Case #%d:\n", i+1));
      s.clear();
      s.add(new SumSet());
      n = Rd.nextInt();
      boolean possible = false;
      for (j = 0; j < n; j++){
        int next = Rd.nextInt();
        added.clear();
        for (SumSet ss: s){
          SumSet newSet = ss.add(next);
          if (s.contains(newSet)){
            possible = true;
            for (SumSet ss2: s){
              if (ss2.equals(newSet)){
                bw.write(setToString(ss2.set));
                bw.write(setToString(newSet.set));
                break;
              }
            }
          } else {
            added.add(newSet);
          }
          if (possible)
            break;
        }
        s.addAll(added);
      }
        
    }
    bw.flush();
      
  }
  
  public static String setToString(Set<Integer> set){
    StringBuilder sb = new StringBuilder();
    for (int i: set){
      sb.append(i + " ");
    }
    sb.append("\n");
    return sb.toString();
  }
}
  

class SumSet{
  Set<Integer> set;
  int sum;
  public SumSet(){
    set = new HashSet<Integer>();
    sum = 0;
  }
  
  public SumSet add(int x){
    SumSet newSet = new SumSet();
    newSet.set.addAll(this.set);
    newSet.set.add(x);
    newSet.sum = this.sum + x;
    return newSet;
  }
  
  public boolean equals(Object other){
    if (!(other instanceof SumSet))
      return false;
    SumSet o = (SumSet) other;
    return this.sum == o.sum;
  }
  
  public int hashCode(){
    return this.set.hashCode();
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