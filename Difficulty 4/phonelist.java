import java.util.*;

class phonelist{
  //Difficulty: 3.1
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int n = sc.nextInt();
      Node root = new Node();
      boolean consistent = true;
      for (int j = 0; j < n; j++){
        String num = sc.next();
        if (consistent){
          //System.out.println("building: " + num);
          if (!buildTree(num, root)){
            consistent = false;
          }
        }
      }
      System.out.println(consistent?"YES":"NO");
    }
  }
  
  public static boolean buildTree(String num, Node root){
    Node current = root;
    for (int i = 0; i < num.length() - 1; i++){
      if (current.stat == 1){
        return false;
      }
      if (i > 0){
        current.setValue(0);
      }
      int next = num.charAt(i) - '0';
      //System.out.println(current.stat + "," + next);
      if (current.children[next] == null){
        //System.out.println("new");
        current.children[next] = new Node();
      }
      current = current.children[next];
      
    }
    if (current.stat == 1){
        return false;
    }
    current.setValue(0);
    int last = num.charAt(num.length() - 1) - '0';
    if (current.children[last] == null){
      current.children[last] = new Node();
      current.children[last].setValue(1);
      //System.out.println(last + "," + current.children[last].stat);
      return true;
    }
    return false;
  }
  
}

class Node{
  Node[] children;
  int stat;
  public Node(){
    this.children = new Node[10];
    this.stat = -1;
  }
  
  public void setValue(int value){
    this.stat = value;
  }
}