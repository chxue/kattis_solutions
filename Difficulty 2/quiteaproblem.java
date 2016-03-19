import java.util.*;

class quiteaproblem{
  //Difficulty: 1.8
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()){
      String line = sc.nextLine();
      boolean yes = false;
      for (int i = 0; i < line.length() - 6; i++){
        if (line.substring(i, i+7).toLowerCase().equals("problem")){
          System.out.println("yes");
          yes = true;
          break;
        }
      }
      if (!yes){
        System.out.println("no");
      }
    }
  }
}