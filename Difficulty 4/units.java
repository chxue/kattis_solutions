
import java.util.*;
import java.io.*;

class units{
  //Difficulty: 3.5
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n, i;
    while ((n = Rd.nextInt())!= 0){
      String[] units = Rd.nextLine().split(" ");
      Map<String, List<String[]>> map = new HashMap<String, List<String[]>>();
      Map<String, Integer> indexOf = new HashMap<String, Integer>();
      boolean[] defined = new boolean[n];
      double[] valueOf = new double[n];
      Queue<Integer> toDefine = new LinkedList<Integer>();
      for (i = 0; i < n; i++){
        indexOf.put(units[i], i);
        map.put(units[i], new ArrayList<String[]>());
      }
      for (i = 0; i < n-1; i++){
        String[] line = Rd.nextLine().split(" ");
        map.get(line[0]).add(line);
        String[] reverse = new String[4];
        reverse[0] = line[3];
        reverse[3] = line[0];
        reverse[2] = Double.toString(1/Double.parseDouble(line[2]));
        map.get(reverse[0]).add(reverse);
      }
      
      toDefine.add(0);
      valueOf[0] = 1;
      i = 0;
      defined[0] = true;
      Unit[] unitsArray = new Unit[n];
      while (toDefine.peek() != null){
        int index = toDefine.poll();
        unitsArray[i++] = new Unit(units[index], valueOf[index]);
        for (String[] s: map.get(units[index])){
          int index2 = indexOf.get(s[3]);
          if (!defined[index2]){
            defined[index2] = true;
            valueOf[index2] = valueOf[index]/Double.parseDouble(s[2]);
            toDefine.add(index2);
          }
        }
      }
      Arrays.sort(unitsArray);
      StringBuilder sb = new StringBuilder();
      i = n-1;
      sb.append(1 + unitsArray[i].u + " ");
      while (i > 0){
        sb.append("= ");
        sb.append((int)(unitsArray[n-1].v/unitsArray[--i].v+0.5) + unitsArray[i].u);
        sb.append(" ");
      }
      bw.write(sb.toString());
      bw.newLine();
    }
    bw.flush();
  }
}

class Unit implements Comparable<Unit>{
  String u;
  double v;
  public Unit(String unit, double value){
    u = unit;
    v = value;
  }
  
  public int compareTo(Unit other){
    if (this.v == other.v)
      return 0;
    return this.v < other.v? -1: 1;
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