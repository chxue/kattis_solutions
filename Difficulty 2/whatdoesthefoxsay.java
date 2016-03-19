import java.util.*;

class whatdoesthefoxsay{
  //Difficulty: 2.0
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();sc.nextLine();
    for (int i = 0; i < t; i++){
      String[] firstLine = sc.nextLine().split(" ");
      Set<String> identified = new HashSet<String>();
      while (true){
        String line = sc.nextLine();
        if (line.equals("what does the fox say?")){
          System.out.println(construct(firstLine, identified));
          break;
        }
        identified.add(line.split(" ")[2]);
      }
    }
  }
  
  public static String construct(String[] firstLine, Set<String> identified){
    StringBuilder out = new StringBuilder();
    for (String s: firstLine){
      if (!identified.contains(s)){
        out.append(s + " ");
      }
    }
    return out.toString();
  }
}