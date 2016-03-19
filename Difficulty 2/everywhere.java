import java.util.*;

class everywhere{
  //Difficulty: 1.5
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int n = sc.nextInt();
      Set<String> cities = new HashSet<String>();
      for (int j = 0; j < n; j++){
        cities.add(sc.next());
      }
      System.out.println(cities.size());
    }
  }
}