import java.util.*;

class pervasiveheartmonitor{
  //Difficulty: 1.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()){
      String[] info = sc.nextLine().split(" ");
      List<String> name = new ArrayList<String>();
      List<Double> scores = new ArrayList<Double>();
      for (int i = 0; i < info.length; i++){
        try{
          scores.add(Double.parseDouble(info[i]));
        } catch (NumberFormatException e){
          name.add(info[i]);
        }
      }
      print(name, scores);
      System.out.println();
    }
  }
  
  public static void print(List<String> name, List<Double> scores){
    double sum = 0;
    for (double d: scores){
      sum += d;
    }
    System.out.print(sum/scores.size() + " ");
    for (int i = 0; i < name.size(); i++){
      System.out.print(name.get(i));
      if (i < name.size() - 1){
        System.out.print(" ");
      }
    }
    
  }
}