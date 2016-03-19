import java.util.*;

class secretmessage{
  //Difficulty: 1.6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      String msg = sc.next();
      int n = (int)Math.ceil(Math.sqrt(msg.length()));
      StringBuilder output = new StringBuilder(msg.length());
      for (int k = 0; k < n; k++){
        for (int j = n-1; j >=0; j--){
          int index = j*n +k;
          if (index < msg.length()){
            output.append(msg.charAt(index));
          }
        }
      }
      System.out.println(output);
    }
  }
}