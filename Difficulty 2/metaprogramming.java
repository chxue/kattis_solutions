import java.util.*;

class metaprogramming{
  //Difficulty: 1.8
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Map<String, Integer> map = new HashMap<String, Integer>();
    while (sc.hasNextLine()){
      String operation = sc.next();
      if (operation.equals("define")){
        int x = sc.nextInt();
        String var = sc.nextLine();
        map.put(var, x);
      } else {
        String equation = sc.nextLine();
        String[] temp;
        try{
          if (equation.split(" <").length > 1){
            temp = equation.split(" <");
            int a = map.get(temp[0]),
              b = map.get(temp[1]);
            System.out.println(a < b);
          } else if (equation.split(" >").length > 1){
            temp = equation.split(" >");
            int a = map.get(temp[0]),
              b = map.get(temp[1]);
            System.out.println(a > b);
          } else {
            temp = equation.split(" =");
            int a = map.get(temp[0]),
              b = map.get(temp[1]);
            System.out.println(a == b);
          }
        } catch (NullPointerException e){
          System.out.println("undefined");
        }
      }
    }
  }
}