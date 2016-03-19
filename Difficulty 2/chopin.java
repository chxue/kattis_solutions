import java.util.*;

class chopin{
  //Difficulty: 1.6
  public static void main(String[] args){
    String[] left = {"A#", "C#", "D#", "F#", "G#"}, right = {"Bb","Db", "Eb","Gb", "Ab"};
    Map<String, String> map = new HashMap<String, String>();
    for (int i = 0; i < 5; i++){
      map.put(left[i], right[i]);
      map.put(right[i], left[i]);
    }
    Scanner sc = new Scanner(System.in);
    int t = 1;
    while (sc.hasNextLine()){
      String[] note = sc.nextLine().split(" ");
      String key = note[0], tonality = note[1];
      if (map.keySet().contains(key)){
        System.out.format("Case %d: %s %s\n", t++, map.get(key), tonality);
      } else {
        System.out.format("Case %d: UNIQUE\n", t++);
      }
    }
  }
}