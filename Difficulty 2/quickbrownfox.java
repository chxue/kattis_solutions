import java.util.*;

class quickbrownfox{
  //Difficulty: 1.6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(); sc.nextLine();
    for (int i = 0; i < t; i++){
      String sentence = sc.nextLine().toLowerCase();
      boolean[] used = new boolean[26];
      for (int j = 0; j < sentence.length(); j++){
        char c = sentence.charAt(j);
        if (c >= 'a' && c <= 'z'){
          used[c-'a'] = true;
        }
      }
      String missing = "";
      for (int j = 0; j < 26; j++){
        if (!used[j]){
          missing += (char)('a' + j);
        }
      }
      if (missing.length() == 0){
        System.out.println("pangram");
      } else {
        System.out.println("missing " + missing);
      }
    }
  }
}