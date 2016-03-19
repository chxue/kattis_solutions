import java.util.*;

class rollcall{
  //Difficulty: 1.7 
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Queue<Student> all = new PriorityQueue<Student>();
    Set<String> called = new HashSet<String>(), same = new HashSet<String>();
    while (sc.hasNextLine()){
      Student next = new Student(sc.nextLine());
      all.add(next);
      if (!called.contains(next.first)){
        called.add(next.first);
      } else {
        same.add(next.first);
      }
    }
    while (all.peek()!= null){
      Student s = all.poll();
      if (same.contains(s.first)){
        System.out.println(s.first + " " + s.last);
      } else {
        System.out.println(s.first);
      }
    }
      
  }
}

class Student implements Comparable<Student>{
  String first, last;
  public Student(String name){
    String[] names = name.split(" ");
    this.first = names[0];
    this.last = names[1];
  }
  
  public int compareTo(Student other){
    int last = this.last.compareTo(other.last);
    
    return last != 0? last: this.first.compareTo(other.first);
  }
}