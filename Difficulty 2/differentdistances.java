import java.util.*;

class differentdistances{
  //Difficulty: 1.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()){
      String line = sc.nextLine();
      if (line.equals("0")){
        break;
      }
      String[] nums = line.split(" ");
      double[] num = new double[5];
      for (int i = 0; i < 5; i++){
        num[i] = Double.parseDouble(nums[i]);
      }
      double x1 = num[0], y1 = num[1], x2 = num[2], y2 = num[3], p = num[4];
      System.out.println(Math.pow(Math.pow(Math.abs(x1-x2),p)+
                                  Math.pow(Math.abs(y1-y2),p),1/p));
      
    }
  }
}