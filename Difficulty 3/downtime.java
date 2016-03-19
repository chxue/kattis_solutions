import java.util.*;

class downtime{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), k = sc.nextInt();
    int[] time = new int[n];
    for (int i = 0; i < n; i++){
      time[i] = sc.nextInt();
    }
    System.out.println((int)Math.ceil(solve(time)*1.0/k));
  }
  
  public static int solve(int[] time){
    Queue<Integer> servers = new PriorityQueue<Integer>();
    int max = 1;
    servers.add(time[0]+1000);
    for (int i = 1; i < time.length; i++){
      int t = time[i];
      boolean scheduled = false;
      int min = servers.peek();
      if (min <= t){
        servers.poll();
        servers.add(t+1000);
      } else {
        servers.add(t+1000);
        max++;
      }
    }
    return max;
  }
}