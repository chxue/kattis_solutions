import java.util.*;

class bookingaroom{
  //Difficulty: 1.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int rooms = sc.nextInt(), booked = sc.nextInt();
    if (rooms == booked){
      System.out.println("too late");
      return;
    }
    boolean[] status = new boolean[rooms+1];
    for (int i = 0; i < booked; i++){
      status[sc.nextInt()] = true;
    }
    for (int i = 1; i < rooms + 1; i++){
      if (!status[i]){
        System.out.println(i);
        return;
      }
    }
  }
}