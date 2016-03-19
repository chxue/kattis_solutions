import java.util.*;

class triangle{
  //Difficulty: 2.0
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int i = 1;
    while (sc.hasNextInt()){
      int n = sc.nextInt();
      System.out.format("Case %d: %d\n",i++, 
                        (int)Math.ceil(Math.log10(3)+n*Math.log10(1.5)));
    }
  }
}