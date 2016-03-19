import java.util.*;

class pebblesolitaire2{
  //Difficulty: 4.1
  public static Map<String, Integer> m = new HashMap<String, Integer>();
  public static final int bl = 23;
  public static int cnt;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(); sc.nextLine();
    for (int i = 0; i < t; i++){
      cnt = bl;
      String s = sc.nextLine();
      System.out.println(recursive(s));
    }
  }
  
  public static int recursive (String s){
    if (m.containsKey(s) )
      return m.get(s);
    String t = s;
    for ( int i = 0; i < bl-1; i++ ) {
      if ( s.charAt (i) == 'o' && s.charAt (i + 1) == 'o' ) {
        if ( i + 2 < bl && s.charAt (i + 2) == '-' ) {
          StringBuilder sb = new StringBuilder(s);
          sb.setCharAt(i + 2, 'o');
          sb.setCharAt(i, '-');
          sb.setCharAt(i + 1, '-');
          s = sb.toString();
          m.put(s, recursive(s));
          s = t;
        }
        if ( i - 1 >= 0 && s.charAt (i - 1) == '-' ) {
          StringBuilder sb = new StringBuilder(s);
          sb.setCharAt(i - 1, 'o');
          sb.setCharAt(i, '-');
          sb.setCharAt(i + 1, '-');
          s = sb.toString();
          m.put(s, recursive(s));
          s = t;
        }
      }
    }
    
    int c = 0;
    
    for ( int i = 0; i < bl; i++ ) {
      if ( s.charAt (i) == 'o' ) c++;
    }
    
    if ( c < cnt )
      cnt = c;
    
    return cnt;
  }
 
}