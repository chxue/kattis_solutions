import java.util.*;

class falsesecurity{
  //Difficulty: 1.7

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
      ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...", "-","..-",
      "...-",".--","-..-","-.--","--.."};
    Map<Character, String> map = new HashMap<Character, String>();
    Map<String, Character> reverseMap = new HashMap<String, Character>();
    for (int i = 0; i < 26; i++){
      char c = (char)('A' + i);
      map.put(c, morse[i]);
      reverseMap.put(morse[i], c);
    }
    map.put('_', "..--"); reverseMap.put("..--", '_');
    map.put(',', ".-.-"); reverseMap.put(".-.-", ',');
    map.put('.', "---."); reverseMap.put("---.", '.');
    map.put('?', "----"); reverseMap.put("----", '?');
    
    while (sc.hasNextLine()){
      String code = sc.nextLine();
      String morseCode = "", length = "";
      for (int i = 0; i < code.length(); i++){
        String s = map.get(code.charAt(i));
        morseCode += s;
        length += s.length();
      }
      length = new StringBuilder(length).reverse().toString();
      int pointer = 0;
      String decoded = "";
      for (int i = 0; i < length.length(); i++){
        int increase = Character.getNumericValue(length.charAt(i));
        decoded += reverseMap.get(morseCode.substring(pointer, pointer + increase));
        pointer += increase;
      }
      System.out.println(decoded);
    }
  }
}
