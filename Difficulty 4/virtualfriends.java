import java.util.*;

class virtualfriends{
  //Difficulty: 3.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    
    for (int i = 0; i < num; i++){
      int index = 0;
      int people = sc.nextInt();
      Map<String, Integer> map = new TreeMap<String, Integer>();
      Node[] nodes = new Node[2 * people];
      
      
      for (int j = 0; j < people; j++){
        String p1 = sc.next();
        String p2 = sc.next();
        
        if (!map.keySet().contains(p1)){
          map.put(p1, index);
          nodes[index] = new Node();
          index ++;
        }
        
        if (!map.keySet().contains(p2)){
          map.put(p2, index);
          nodes[index] = new Node();
          index++;
        }
        System.out.println(solve(p1, p2, nodes, map));
        
      }
    }
  }
  
  private static class Node{
    Node head;
    int size;
    public Node(){
      this.head = this;
      this.size = 1;
    }
    
    public void connect(Node other){
      Node thisHead = this.head();
      Node otherHead = other.head();
      thisHead.head = otherHead;
      otherHead.size += thisHead.size;
    }
    
    public Node head(){
      Node head = this.head;
      while (head.head != head){
        head = head.head;
      }
      Node temp1 = this.head;
      while (temp1 != head){
        Node temp2 = temp1.head;
        temp1.head = head;
        temp1 = temp2;
      }
      return head;
    }
    
    public int size(){
      return this.head().size;
    }
  }
  
  public static int solve(String p1, String p2, Node[] nodes, Map<String, Integer> map){
    Node n1 = nodes[map.get(p1)], n2 = nodes[map.get(p2)];
    if (n1.head() != n2.head()){
      n1.connect(n2);
    }
    return n1.size();
  }
}