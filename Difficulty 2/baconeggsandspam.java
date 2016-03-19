import java.util.*;

class baconeggsandspam{
  //Difficulty: 1.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Map<String, Set<String>> order = new TreeMap<String, Set<String>>();
    while (true){
      int n = Integer.parseInt(sc.nextLine());
      if (n == 0){
        return;
      }
      order.clear();
      for (int i = 0; i < n; i++){
        String[] line = sc.nextLine().split(" ");
        for (int j = 1; j < line.length; j++){
          if (!order.containsKey(line[j])){
            order.put(line[j], new TreeSet<String>());
          }
          order.get(line[j]).add(line[0]);
        }
      }
      for (String key: order.keySet()){
        System.out.print(key);
        for (String name: order.get(key)){
          System.out.print(" " + name);
        }
        System.out.println();
      }
      System.out.println();
    }
      
        
  }
}