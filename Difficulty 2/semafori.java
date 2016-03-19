import java.util.*;

class semafori{
  //Difficulty: 1.8
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), l = sc.nextInt(),
      t = 0, d = 0, next, r, g;
    for (int i = 0; i < n; i++){
      next = sc.nextInt();
      t += next - d; d = next;
      r = sc.nextInt(); g = sc.nextInt();
      if (t % (r + g) < r){
        t += r - t%(r+g);
      }
    }
    t += l - d;
    System.out.println(t);
  }
}