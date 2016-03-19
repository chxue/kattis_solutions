import java.util.*;

class oddmanout{
  //Difficulty: 1.5
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 1; i <=t; i++){
      int n = sc.nextInt();
      Set<Long> guests = new TreeSet<Long>();
      for (int j = 0; j < n; j++){
        add(guests, sc.nextLong());
      }
      System.out.format("Case #%d: %d\n", i, guests.iterator().next());
    }
  }
  
  public static void add(Set<Long> guests, long guest){
    if (guests.contains(guest)){
      guests.remove(guest);
    } else {
      guests.add(guest);
    }
    return;
  }
}