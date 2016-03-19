import java.util.*;

class musicyourway{
  //Difficulty: 2.2
  //important lesson: java sort is a stable (merge) sort.
  public static int crit = 0;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String headerS = sc.nextLine();
    String[] header = headerS.split(" ");
    Map<String, Integer> getIndex = new HashMap<String, Integer>();
    for (int i = 0; i < header.length; i++){
      getIndex.put(header[i], i);
    }
    int m = Integer.parseInt(sc.nextLine());
    List<String[]> lstSongs = new ArrayList<String[]>();
    for (int i = 0; i < m; i++){
      lstSongs.add(sc.nextLine().split(" "));
    }
    int n = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < n; i++){
      crit = getIndex.get(sc.nextLine());
      Collections.sort(lstSongs, new SongComparator());
      System.out.println(headerS);
      for (String[] sa: lstSongs){
        StringBuilder sb = new StringBuilder();
        for (String s: sa){
          sb.append(s + " ");
        }
        System.out.println(sb);
      }
      System.out.println();
    }
  }
  
  public static class SongComparator implements Comparator<String[]>{
    public int compare(String[] a, String[] b){
      return a[crit].compareTo(b[crit]);
    }
  }
}