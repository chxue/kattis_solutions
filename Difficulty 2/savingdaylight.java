import java.util.*;

class savingdaylight{
  //Difficulty: 1.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()){
      String[] input = sc.nextLine().split(" ");
      String[] start = input[3].split(":"), end = input[4].split(":");
      int[] time = new int[2];
      time[0] = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
      time[1] = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
      if (time[1] < 0){
        time[1] += 60;
        time[0] --;
      }
      System.out.format("%s %s %s %d hours %d minutes\n", input[0], input[1],
                        input[2], time[0], time[1]);
      
    }
  }
}