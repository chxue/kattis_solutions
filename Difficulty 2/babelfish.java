import java.util.*;

class babelfish{
  //Difficulty: 1.9
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    boolean read = true;
    Map<String, String> dictionary = new HashMap<String, String>();
    while (sc.hasNextLine()){
      String line = sc.nextLine();
      if (line.equals("")){
        read = false;
        continue;
      }
      if (read){
        String[] l = line.split(" ");
        dictionary.put(l[1], l[0]);
      } else {
        String out = dictionary.get(line);
        System.out.println(out == null? "eh":out);
      }
    }
  }
}