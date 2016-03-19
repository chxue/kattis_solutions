import java.util.*;

class touchscreenkeyboard{
  //Difficulty: 2.0
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    char[][] keyboard = new char[3][10];
    String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < rows[i].length(); j++){
        keyboard[i][j] = rows[i].charAt(j);
      }
    }
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      Map<Integer, Set<String>> map = new TreeMap<Integer, Set<String>>();
      String typed = sc.next();
      int n = sc.nextInt();
      for (int j = 0; j < n; j++){
        String choice = sc.next();
        int d = distance(keyboard, typed, choice);
        if (!map.keySet().contains(d)){
          map.put(d, new TreeSet<String>());
        }
        map.get(d).add(choice);
      }
      for (Integer key: map.keySet()){
        for (String s: map.get(key)){
          System.out.println(s + " " + key);
        }
      }
    }
  }
  
  public static int[] position(char[][] keyboard, char c){
    int[] pos = new int[2];
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 10; j++){
        if (keyboard[i][j] == c){
          pos[0] = i;
          pos[1] = j;
          return pos;
        }
      }
    }
    return pos;
  }
  
  public static int distance(char[][] keyboard, char c1, char c2){
    int[] posC1 = position(keyboard, c1),
      posC2 = position(keyboard, c2);
    return Math.abs(posC1[0]-posC2[0]) + Math.abs(posC1[1] - posC2[1]);
  }
  
  public static int distance(char[][] keyboard, String s1, String s2){
    int sum = 0;
    for (int i = 0; i < s1.length(); i++){
      sum += distance(keyboard, s1.charAt(i), s2.charAt(i));
    }
    return sum;
  }
}
    
    