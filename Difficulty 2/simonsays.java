import java.util.*;

class simonsays{
  //Difficulty: 1.4
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();sc.nextLine();
    for (int i = 0; i < t; i++){
      String sentence = sc.nextLine();
      if (sentence.length() > 10 && sentence.substring(0, 11).equals("Simon says ")){
        System.out.println(sentence.substring(11));
      }
    }
  }
}