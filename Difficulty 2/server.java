import java.util.*;

class server{
  //Difficulty: 1.5
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), t = sc.nextInt(), count = 0;
    for (int i = 0; i < n; i++){
      if (t <= 0){
        break;
      }
      int next = sc.nextInt();
      if (t >= next){
        count++;
      }
      t -= next;
    }
    System.out.println(count);
  }
}