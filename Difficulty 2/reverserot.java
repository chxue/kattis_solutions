import java.util.*;

class reverserot{
  //Difficulty: 1.5
  public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.";
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      int rot = sc.nextInt();
      if (rot == 0){
        return;
      }
      String msg = new StringBuilder(sc.next()).reverse().toString();
      System.out.println(rotate(msg, rot));
    }
  }
  public static String rotate(String msg, int rot){
    String output = "";
    for (int i = 0; i < msg.length(); i++){
      char c = msg.charAt(i);
      for (int j =0; j < ALPHABET.length(); j++){
        if (ALPHABET.charAt(j) == c){
          output += ALPHABET.charAt((j+rot)%ALPHABET.length());
          break;
        }
      }
    }
    return output;
  }
}