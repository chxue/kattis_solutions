import java.util.*;

class busnumbers{
  //Difficulty: 1.6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] buses = new int[n];
    for (int i = 0; i < n; i++){
      buses[i] = sc.nextInt();
    }
    Arrays.sort(buses);
    List<Integer> consecutive = new ArrayList<Integer>();
    for (int i = 0; i < n; i++){
      if (!consecutive.isEmpty() && buses[i] - consecutive.get(consecutive.size()-1) > 1){
        print(consecutive);
        System.out.print(" ");
        consecutive.clear();
        consecutive.add(buses[i]);
      } else {
        consecutive.add(buses[i]);
      }
    }
    print(consecutive);
  }
  public static void print(List<Integer> consecutive){
    if (consecutive.size() < 3){
      for (int i = 0; i < consecutive.size(); i++){
        System.out.print(consecutive.get(i));
        if (i < consecutive.size() - 1){
          System.out.print(" ");
        }
      }
    } else {
      System.out.print(consecutive.get(0) + "-" + consecutive.get(consecutive.size() -1));
    }
  }
}