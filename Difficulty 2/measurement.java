import java.util.*;

class measurement{
  //Difficulty: 1.8
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] measure = {1, 1000, 12, 3, 22, 10, 8, 3};
    String[] names = {"thou","inch","foot","yard","chain","furlong",
      "mile","league","th","in","ft","yd","ch","fur","mi","lea"};
    double cons = sc.nextDouble();
    int a = find(names, sc.next()); sc.next();
    int b = find(names, sc.next());
    if (a < b){
      for (int i = b; i > a; i--){
        cons /= measure[i];
      }
    } else if (a > b) {
      for (int i = a; i > b; i--){
        cons *= measure[i];
      }
    }
    System.out.println(cons);
  }
  
  public static int find(String[] names, String name){
    for (int i = 0; i < names.length; i++){
      if (names[i].equals(name)){
        return i%8;
      }
    }
    return -1;
  }
}