import java.util.*;

class kemija08{
  //Difficulty: 1.3
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String code = sc.nextLine(), decoded = "";
    char[] vowels = {'a','e','i','o','u'};
    for (int i = 0; i < code.length(); i++){
      char c = code.charAt(i);
      decoded += c;
      if (contains(vowels, c)){
        i += 2;
      }
    }
    System.out.println(decoded);
  }
  
  public static boolean contains(char[] vowels, char c){
    for (int i = 0; i < vowels.length; i++){
      if (vowels[i] == c){
        return true;
      }
    }
    return false;
  }
}