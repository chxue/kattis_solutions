import java.util.*;

class toilet{
  //Difficulty: 1.9
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    char init = line.charAt(0), last = init;
    int adjustU = 0, adjustD = 0, adjustL = 0;
    for (int i = 1; i < line.length(); i++){
      char config = line.charAt(i);
      if (config == 'U'){
        adjustD += (i == 1)? 1:2;
      } else {
        adjustU += (i == 1)? 1:2;
      }
      if (config != last){
        adjustL += 1;
        last = config;
      }
      
    }
    if (init != line.charAt(1)){
      adjustD += 1;
      adjustU += 1;
    }
    System.out.println(Math.max(adjustU,0));
    System.out.println(Math.max(adjustD,0));
    System.out.println(adjustL);
  }
}