import java.util.*;

class eligibility{
  //Difficulty: 1.3
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      String name = sc.next(), postSec = sc.next().split("/")[0], birth = sc.next().split("/")[0];
      int score = sc.nextInt();
      String status = "coach petitions";
      if (Integer.parseInt(postSec) >=2010 || Integer.parseInt(birth) >= 1991){
        status = "eligible";
      } else if (score > 40){
        status = "ineligible";
      }
      System.out.println(name + " " + status);
    }
  }
}