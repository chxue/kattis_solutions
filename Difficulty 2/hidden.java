import java.util.*;

class hidden{
  //Difficulty: 1.6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String password = sc.next(), msg = sc.next();
    int[] freq = new int[26];
    for (int i = 0; i < password.length(); i++){
      freq[password.charAt(i) - 'A']++;
    }
    String simplified = "";
    for (int i = 0; i < msg.length(); i++){
      char c = msg.charAt(i);
      if (freq[c-'A'] > 0){
        freq[c-'A']--;
        simplified += c;
      }
    }
    System.out.println(simplified.equals(password)?"PASS":"FAIL");
  }
}