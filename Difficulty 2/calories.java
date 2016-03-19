import java.util.*;

class calories{
  //Diffilculty: 2.0
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] caloriesAll = {9, 4, 4, 4, 7};
    while (true){
      List<String> food = new ArrayList<String>();
      String line;
      while (!(line = sc.nextLine()).equals("-")){
        food.add(line);
      }
      if (food.size() == 0){
        return;
      }
      double c = 0, cf = 0;
      for (String l: food){
        int remainP = 100;
        double thisc = 0;
        String[] nutrition = l.split(" ");
        for (int i = 0; i < nutrition.length; i++){
          String consumption = nutrition[i];
          int value = Integer.parseInt(consumption.substring(0, consumption.length()-1));
          char unit = consumption.charAt(consumption.length() - 1);
          if (unit == '%'){
            remainP -= value;
          } else if (unit == 'g'){
            thisc += value * caloriesAll[i];
          } else {
            thisc += value;
          }
        }
        thisc = thisc * 100 /remainP;
        c += thisc;
        int value = Integer.parseInt(nutrition[0].substring(0, nutrition[0].length()-1));
        char unit = nutrition[0].charAt(nutrition[0].length() -1);
        if (unit == '%'){
          cf += thisc * value/100;
        } else if (unit == 'g'){
          cf += value * 9;
        } else {
          cf += value;
        }
      }
      System.out.format("%.0f%%\n", cf/c*100);
    }
  }
}