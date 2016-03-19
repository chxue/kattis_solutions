import java.util.*;

class tutorial{
  //Difficulty: 2.5
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    long m = scanner.nextLong();
    long n = scanner.nextLong();
    int type = scanner.nextInt();
    System.out.println(solve(m, n, type));
  }
  
  public static String solve(long m, long n, int type){
    if (type == 1)
      return type1(m, n);
    if (type == 2)
      return type2(m, n);
    if (type == 3)
      return type3(m, n);
    if (type == 4)
      return type4(m, n);
    if (type == 5)
      return type5(m, n);
    if (type == 6)
      return type6(m, n);
    if (type == 7)
      return type7(m, n);
    return null;
  }
  
  public static String type1(long m, long n){
    long product = 1;
    while (product <= m && n > 1){
      product *= n;
      n--;
    }
    return m < product ? "TLE":"AC";
  }
  
  public static String type2(long m, long n){
    long product = 1;
    
    while (product <= m && n > 0){
      product *= 2;
      n--;
    }
    return m < product ? "TLE":"AC";
  }
  
  public static String type3(long m, long n){
    long product = 1;
    int t = 0;
    while (product <= m && t < 4){
      product *= n;
      t++;
    }
    return m < product ? "TLE":"AC";
  }
  
  public static String type4(long m, long n){
    long product = 1;
    int t = 0;
    while (product <= m && t < 3){
      product *= n;
      t++;
    }
    return m < product ? "TLE":"AC";
  }
  
  public static String type5(long m, long n){
    long product = 1;
    int t = 0;
    while (product <= m && t < 2){
      product *= n;
      t++;
    }
    return m < product ? "TLE":"AC";
  }
  
  public static String type6(long m, long n){
    return m < n * Math.log(n)/Math.log(2)  ? "TLE":"AC";
  }
  
  public static String type7(long m, long n){
    return m < n ? "TLE":"AC";
  }
  
}