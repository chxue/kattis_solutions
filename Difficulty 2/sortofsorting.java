import java.util.*;

class sortofsorting{
  //Difficulty: 1.8
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      Set<Name> set = new TreeSet<Name>();
      int n = sc.nextInt();
      if (n == 0){
        return;
      }
      for (int i = 0; i < n; i++){
        set.add(new Name(sc.next(), i));
      }
      for (Name m: set){
        System.out.println(m.name);
      }
      System.out.println();
    }
  }
}

class Name implements Comparable<Name>{
  String name;
  int ord;
  public Name(String name, int order){
    this.name = name;
    this.ord = order;
  }
  
  public int compareTo(Name other){
    int c1 = this.name.charAt(0) - other.name.charAt(0);
    int c2 = this.name.charAt(1) - other.name.charAt(1);
    return c1 != 0? c1: c2 != 0? c2: (this.ord-other.ord);
  }
}