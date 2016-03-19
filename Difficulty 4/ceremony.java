import java.util.*;

class ceremony{
  //Difficulty: 3.8
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] heights = new int[n];
    for (int i = 0; i < n; i++){
      heights[i] = scanner.nextInt();
    }
    Arrays.sort(heights);
    System.out.println(solve(heights, n-1));
  }
  
  public static int solve(int[] heights, int tail){
    if (tail == 0){
      return 1;
    }
    return Math.min(solve(heights, tail-1) + 1, heights[tail]);
  }
}