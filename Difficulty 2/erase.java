import java.util.*;

class erase{
  //Difficulty: 1.6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt() % 2;
    String a = sc.next(), b = sc.next();
    System.out.println(delete(a, b, n)?"Deletion succeeded":"Deletion failed");
  }
  
  public static boolean delete(String a, String b, int n){
    if (n == 0){
      return a.equals(b);
    }
    for (int i = 0; i < a.length(); i++){
      if (a.charAt(i) == b.charAt(i)){
        return false;
      }
    }
    return true;
  }
}