import java.util.*;

class hittingtargets{
  //Difficulty: 1.5
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    List<List<Integer>> shapes = new ArrayList<List<Integer>>();
    
    for (int i = 0; i < m; i++){
      int read = 3;
      if (sc.next().equals("rectangle")){
        read = 4;
      }
      List<Integer> shape = new ArrayList<Integer>();
      for (int j = 0; j < read; j++){
        shape.add(sc.nextInt());
      }
      shapes.add(shape);
    }
    int n = sc.nextInt();
    for (int i = 0; i < n; i++){
      int x = sc.nextInt(), y = sc.nextInt(), count = 0;
      for (int j = 0; j < shapes.size(); j++){
        if (hit(shapes.get(j), x, y)){
          count++;
        }
      }
      System.out.println(count);
    }
  }
  
  public static boolean hit(List<Integer> shape, int x, int y){
    if (shape.size() == 4){
      if (x >= shape.get(0) && y >= shape.get(1) &&
          x <= shape.get(2) && y <= shape.get(3)){
        return true;
      }
      return false;
    } else {
      if (Math.pow(x-shape.get(0),2) + Math.pow(y-shape.get(1),2) <= 
          Math.pow(shape.get(2),2)){
        return true;
      }
      return false;
    }
  }
}