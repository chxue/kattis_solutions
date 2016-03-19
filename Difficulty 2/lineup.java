import java.util.*;

class lineup{
  //Difficulty: 1.4
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] names = new String[n];
    for (int i = 0; i < n; i++){
      names[i] = sc.next();
    }
    boolean increase = lessThan(names[0], names[1]);
    for (int i = 2; i < n; i++){
      if (lessThan(names[i-1], names[i]) != increase){
        System.out.println("NEITHER");
        return;
      }
    }
    System.out.println(increase? "INCREASING": "DECREASING");
  }
  
  public static boolean lessThan(String name1, String name2){
    for (int i = 0; i < name1.length(); i++){
      if (i >= name2.length()){
        return false;
      }
      if (name1.charAt(i) > name2.charAt(i)){
        return false;
      }
      if (name1.charAt(i) < name2.charAt(i)){
        return true;
      }
    }
    return true;
    
  }
}