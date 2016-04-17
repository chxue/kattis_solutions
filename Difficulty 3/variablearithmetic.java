
import java.util.*;
import java.io.*;

class variablearithmetic{
  //Difficulty: 2.7
  public static Map<String, Integer> map = new HashMap<String, Integer>();
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line;
    while (!(line = Rd.nextLine()).equals("0")){
      String[] l = line.split(" ");
      //System.out.println(line  + "," + l.length);
      if (l.length > 1 && l[1].equals("=")){
        map.put(l[0], Integer.parseInt(l[2]));
      } else {
        int sum = 0, i;
        Queue<String> unassigned = new LinkedList<String>();
        for (i = 0; i < l.length; i+=2){
          if (l[i].charAt(0) < 'a'){
            sum += Integer.parseInt(l[i]);
          } else {
            if (map.keySet().contains(l[i]))
              sum += map.get(l[i]);
            else
              unassigned.add(l[i]);
          }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sum);
        while (unassigned.peek() != null){
          sb.append(" + ");
          sb.append(unassigned.poll());
        }
        if (sum == 0)
          sb.delete(0,4);
        sb.append("\n");
        bw.write(sb.toString());
        //bw.flush();
      }
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