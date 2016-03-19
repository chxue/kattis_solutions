import java.util.*;

class t9spelling{
  //Difficulty: 1.8
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] keys = {"2","22","222","3","33","333","4","44",
      "444","5","55","555", "6", "66", "666", "7", "77", "777",
      "7777", "8", "88", "888", "9", "99", "999", "9999"};
    int t = sc.nextInt(); sc.nextLine();
    for (int i = 1; i <= t; i++){
      String msg = sc.nextLine(), output = "";
      int last = 1;
      for (int j = 0; j < msg.length(); j++){
        char c = msg.charAt(j);
        String add;
        if ((int)c != 32){
          add = keys[c -'a'];
        } else {
          add = "0";
        }
        if (output.length() > 0 && 
            output.charAt(output.length()-1) == add.charAt(0)){
          output += " ";
        }
        output += add;
      }
      System.out.format("Case #%d: %s\n",i,output);
    }
  }
}