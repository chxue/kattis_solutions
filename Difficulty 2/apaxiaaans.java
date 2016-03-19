import java.util.*;

class apaxiaaans{
  //Difficulty: 1.5
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String name = sc.next();
    char lastRead = ' ';
    String abbr = "";
    for (int i = 0; i < name.length(); i++){
      if (name.charAt(i) != lastRead){
        abbr += name.charAt(i);
        lastRead = name.charAt(i);
      }
    }
    System.out.println(abbr);
  }
}