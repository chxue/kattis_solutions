
import java.util.*;
import java.io.*;

class opensource{
  //Difficulty: 2.4
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    List<Project> projects = new ArrayList<Project>();
    Set<String> signed = new HashSet<String>();
    while (true){
      String line = Rd.nextLine();
      if (line.equals("0"))
        break;
      if (line.equals("1")){
        Collections.sort(projects);
        for (Project p: projects){
          bw.write(String.format("%s %d\n", p.title, p.size()));
        }
        projects.clear();
        signed.clear();
      } else {
        if (title(line)){
          if (projects.size() > 0)
            signed.addAll(projects.get(projects.size()-1).users);
          projects.add(new Project(line));
          
        } else {
          if (signed.contains(line)){
            for (Project p: projects){
              p.remove(line);
            }
          } else {
            projects.get(projects.size()-1).add(line);
          }
        }
      }
    }
    bw.flush();
  }
  
  public static boolean title(String s){
    char c = s.charAt(0);
    return c >= 'A' && c <= 'Z';
  }
    
}
  
class Project implements Comparable<Project>{
  String title;
  Set<String> users;
  public Project(String s){
    title = s;
    users = new HashSet<String>();
  }
  
  public int size(){
    return users.size();
  }
  
  public void add(String user){
    users.add(user);
  }
  
  public void remove(String user){
    users.remove(user);
  }
  
  public int compareTo(Project other){
    if (this.size() != other.size()){
      return other.size() - this.size();
    }
    return title.compareTo(other.title);
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