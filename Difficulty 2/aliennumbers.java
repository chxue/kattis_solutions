import java.util.*;

class aliennumbers{
  //Difficulty: 1.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      String num = sc.next(), source = sc.next(), target = sc.next();
      char[] sourceL = new char[source.length()], 
        targetL = new char[target.length()];     
      for (int j = 0; j<source.length(); j++){
        sourceL[j] = source.charAt(j);
      }
      for (int j = 0; j < target.length(); j++){
        targetL[j] = target.charAt(j);
      }
      System.out.format("Case #%d: %s\n", i+1, translate(convertToDec(num, sourceL), targetL));
    }
  }
  
  public static int convertToDec(String num, char[] sourceL){
    int sum = 0, base = sourceL.length;
    for (int i = 0; i < num.length(); i++){
      sum += search(sourceL, num.charAt(num.length()- 1-i))*Math.pow(base, i);
    }
    return sum;
  }
  
  public static String translate(int num, char[] targetL){
     int base = targetL.length;
     String output = "";
     while (num > 0){
       output = targetL[num % base] + output;
       num /= base;
     }
     return output;
  }
    public static int search(char[] array, char e){
      for (int i = 0; i < array.length; i++){
        if (array[i] == e){
          return i;
        }
      }
      return -1;
    }
}