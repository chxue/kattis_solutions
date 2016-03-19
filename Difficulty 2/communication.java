import java.util.*;

class communication{
  //Difficulty: 1.6
  //important lesson: gray code, https://en.wikipedia.org/wiki/Gray_code (code is not useful)
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int b = sc.nextInt();
      System.out.print(reverse(b) + " ");
    }
  }
  
  public static int reverse(int b){
    for (int i = 0; i < 256; i++){
      if ((i ^ ((i << 1) % 256)) == b){
        return i;
      }
    }
    return 0;
  }
}