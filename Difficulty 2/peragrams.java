import java.util.*;

class peragrams{
  //Difficulty: 1.6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String word = sc.next();
    int[] freq = new int[26];
    for (int i = 0; i < word.length(); i++){
      freq[word.charAt(i) - 'a']++;
    }
    int totalOdd = 0;
    for (int i: freq){
      if (i%2 == 1){
        totalOdd++;
      }
    }
    System.out.println(Math.max(0, totalOdd-1));
  }
}