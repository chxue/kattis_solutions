import java.util.*;

class tourdefrance{
  //Difficulty: 2.0
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      int a = sc.nextInt();
      if (a == 0){
        return;
      }
      int b = sc.nextInt();
      Set<Double> front = new HashSet<Double>(),
        rear = new HashSet<Double>(),
        ratio = new TreeSet<Double>();
      for (int i = 0; i < a; i++){
        front.add(sc.nextDouble());
      }
      for (int i = 0; i < b; i++){
        rear.add(sc.nextDouble());
      }
      for (Double f: front){
        for (Double r: rear){
          ratio.add(r/f);
        }
      }
      double maxSpread = 0, prev = -1;
      for (Double r: ratio){
        if (prev == -1){
          prev = r;
        } else {
          double spread = r/prev;
          if (spread > maxSpread){
            maxSpread = spread;
          }
          prev = r;
        }
      }
      
      System.out.format("%.2f\n",maxSpread);
    }
  }
}