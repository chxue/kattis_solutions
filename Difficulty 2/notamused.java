import java.util.*;

class notamused{
  //Difficulty: 1.6 
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int day = 0;
    Map<String, Integer> record = new HashMap<String, Integer>();
    while (sc.hasNextLine()){
      String line = sc.nextLine();
      
      if (line.equals("OPEN")){
        record.clear();
        System.out.format("Day %d\n", ++day);
      } else if (line.equals("CLOSE")){
        Queue<Customer> q = new PriorityQueue<Customer>();
        for (String key: record.keySet()){
          q.add(new Customer(key, record.get(key) * 0.1));
        }
        while (q.peek() != null){
          Customer c = q.poll();
          System.out.format("%s $%.2f\n", c.name, c.paid);
        }
        System.out.println();
      } else {
        String[] s = line.split(" ");
        //System.out.println(s[0]);
        //System.out.println(record);
        if (!record.containsKey(s[1])){
          record.put(s[1], 0);
        }
        if (s[0].equals("ENTER")){
          record.put(s[1], record.get(s[1]) - Integer.parseInt(s[2]));
        } else {
          record.put(s[1], record.get(s[1]) + Integer.parseInt(s[2]));
        }
      }
      
    }
  }
}

class Customer implements Comparable<Customer>{
  String name;
  double paid;
  public Customer(String name, double paid){
    this.name = name;
    this.paid = paid;
  }
  public int compareTo(Customer other){
    return this.name.compareTo(other.name);
  }
}