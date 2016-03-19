import java.util.*;

class alphabetspam{
  //Difficulty: 1.6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    double[] freq = {0,0,0,0};
    for (int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if (c =='_'){
        freq[0]++;
      } else if (c >= 'a' && c <= 'z'){
        freq[1]++;
      } else if (c >= 'A' && c <= 'Z'){
        freq[2]++;
      } else {
        freq[3]++;
      }
    }
    for (int i = 0; i < 4; i++){
      System.out.println(freq[i]/s.length());
    }
  }
}