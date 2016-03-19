import java.util.*;
import javax.script.*;
class addingwords{
  //Difficulty: 4.1
  public static Map<Integer, String> toStr = new HashMap<Integer, String>();
  public static Map<String, Integer> toInt = new HashMap<String, Integer>();
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()){
      String operation = sc.next();
      if (operation.equals("clear")){
        toStr.clear();
        toInt.clear();
        sc.nextLine();
      } else if (operation.equals("def")){
        String var = sc.next();
        int value = sc.nextInt();
        if (toInt.containsKey(var)){ 
          int old = toInt.get(var);
          toStr.remove(old);
        }
        toStr.put(value, var);
        toInt.put(var, value);
        sc.nextLine();
      } else if (operation.equals("calc")){
        String formula = sc.nextLine().substring(1);
        String[] parts = formula.split(" ");
        String output = "";
        for (int i = 0; i < parts.length; i+=2){
          if (!toInt.containsKey(parts[i])){
            output = "unknown";
            break;
          }
        }
        if (!output.equals("unknown")){
          int result = toInt.get(parts[0]);
          for (int i = 1; i < parts.length-1; i+=2){
            if (parts[i].equals("+")){
              result += toInt.get(parts[i+1]);
            } else {
              result -= toInt.get(parts[i+1]);
            }
          }
          if (toStr.containsKey(result)){
            output = toStr.get(result);
          } else {
            output = "unknown";
          }
        }
        System.out.println(formula + " " + output);
      }
      
    }
  }
    
}