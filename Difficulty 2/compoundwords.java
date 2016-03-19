import java.util.*;

class compoundwords{
  //Difficulty: 1.8
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    List<String> words = new ArrayList<String>();
    while (sc.hasNext()){
      words.add(sc.next());
    }
    Set<String> compounds = new TreeSet<String>();
    for (int i = 0; i < words.size(); i++){
      for (int j = 0; j < words.size(); j++){
        if (i != j){
          compounds.add(words.get(i) + words.get(j));
        }
      }
    }
    for (String s: compounds){
      System.out.println(s);
    }
  }
}