import java.util.*;

class encodedmessage{
  //Difficulty: 1.8
  //important lesson: build string with a stringbuilder is much faster
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(); sc.nextLine();
    for (int i = 0; i < t; i++){
      String msg = sc.nextLine();
      int n = (int)Math.sqrt(msg.length());
      StringBuilder output = new StringBuilder(msg.length());
      for (int k = n-1; k >= 0; k--){
        for (int j = 0; j < n; j++){
          output.append(msg.charAt(n*j + k));
        }
      }
      System.out.println(output);
    }
  }
}