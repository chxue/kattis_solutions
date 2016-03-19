import java.util.*;

class timebomb{
  //Difficulty: 1.5
  public static final String zero = "**** ** ** ****";
  public static final String one = "  *  *  *  *  *";
  public static final String two = "***  *****  ***";
  public static final String three = "***  ****  ****";
  public static final String four = "* ** ****  *  *";
  public static final String five = "****  ***  ****";
  public static final String six = "****  **** ****";
  public static final String seven = "***  *  *  *  *";
  public static final String eight = "**** ***** ****";
  public static final String nine = "**** ****  ****";
  public static final String[] NUMS = {zero, one, two, three, four, five, six, seven, eight, nine};
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    int n = (line.length() + 1)/4;
    String[] codes = new String[n];
    Arrays.fill(codes, "");
    store(codes, line, n);
    for (int i = 0; i < 4; i++){
      line = sc.nextLine();
      store(codes, line, n);
    }
    int sum = 0;
    for (int i = 0; i < n; i++){
      int digit = identify(codes[i]);
      if ((digit < 0)||(i == n-1 && digit % 2 == 1)){
        System.out.println("BOOM!!");
        return;
      }
      sum += digit;
    }
    if (sum % 3 == 0){
      System.out.println("BEER!!");
    } else {
      System.out.println("BOOM!!");
    }
  }
  public static void store(String[] codes, String line, int n){
    int index = 0;
    for (int i = 0; i < n; i++){
      codes[i] += line.substring(index, index + 3);
      index += 4;
    }
    return;
  }
  
  public static int identify(String code){
    for (int i = 0; i < 10; i++){
      if (code.equals(NUMS[i])){
        return i;
      }
    }
    return -1;
  }
}