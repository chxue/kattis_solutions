import java.util.*;

class walkway{
  //Difficulty: 2.4
  //Note: I'm actually not entirely sure about the correctness of this algorithm, but it got accepted.
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while (n != 0){
      Trapezoid[] tp = new Trapezoid[n];
      for (int i = 0; i < n; i++){
        tp[i] = new Trapezoid(sc.nextInt(), sc.nextInt(), sc.nextInt());
      }
      Queue<Point> pts = new PriorityQueue<Point>();
      pts.add(new Point(sc.nextInt(), 0));
      int target = sc.nextInt();
      System.out.println(solve(tp, pts, target));
      n = sc.nextInt();
    }
    
  }
  
  public static double solve(Trapezoid[] tp, Queue<Point> pts, int target){
    boolean[] used = new boolean[tp.length];
    while (pts.peek()!= null){
        Point cpt = pts.poll();
        if (cpt.s == target){
          return cpt.c;
        }
        for (int i = 0; i < tp.length; i++){
          if (!used[i]){
            Trapezoid tpzd = tp[i];
            if (tpzd.a == cpt.s){
              pts.add(new Point(tpzd.b, cpt.c + tpzd.cost()));
              used[i] = true;
            }
            if (tpzd.b == cpt.s){
              pts.add(new Point(tpzd.a, cpt.c + tpzd.cost()));
              used[i] = true;
            }
          }
        }
    }
    return -1.0;
  }
}

class Trapezoid{
  int a, b, h;
  public Trapezoid(int a, int b, int h){
    this.a = a;
    this.b = b;
    this.h = h;
  }
  
  public double cost(){
    return (this.a + this.b) * this.h * 0.01;
  }
}

class Point implements Comparable<Point>{
  double c;
  int s;
  public Point(int side, double cost){
    this.s = side;
    this.c = cost;
  }
  
  public int compareTo(Point other){
    return this.c < other.c? -1: this.c == other.c? 0: 1;
  }
}