
import java.util.*;
import java.io.*;

class runningmom{
  //Difficulty: 3.5
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Rd.nextInt(), index = 0, from, to, i;
    Map<String, Integer> cityIndex = new HashMap<String, Integer>();
    List<Set<Integer>> flights = new ArrayList<Set<Integer>>();
    for (i = 0; i < n; i++){
      flights.add(new HashSet<Integer>());
    }
    while (n-- > 0){
      String[] flight = Rd.nextLine().split(" ");
      if (cityIndex.keySet().contains(flight[0]))
        from = cityIndex.get(flight[0]);
      else {
        from = index;
        cityIndex.put(flight[0], index++);
      }
      if (cityIndex.keySet().contains(flight[1]))
        to = cityIndex.get(flight[1]);
      else {
        to = index;
        cityIndex.put(flight[1], index++);
      }
      flights.get(from).add(to);
    }
    boolean done = false;
    boolean[] trapped = new boolean[index];
    while (true){
      List<Integer> newTrapped = new ArrayList<Integer>();
      for (i = 0; i < index; i++){
        if (!trapped[i] && flights.get(i).size() == 0){
          trapped[i] = true;
          newTrapped.add(i);
        }
      }
      if (newTrapped.size() == 0)
        break;
      for (i = 0; i < index; i++){
        if (!trapped[i]){
          for (int city: newTrapped){
            flights.get(i).remove(city);
          }
        }
      }
    }
    while (Rd.hasMoreTokens()){
      String cityName = Rd.nextLine();
      bw.write(String.format("%s %s", cityName, trapped[cityIndex.get(cityName)]?"trapped":"safe"));
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