import java.util.*;

class perket{
  //Difficulty: 2.0
  public static int minDiff = Integer.MAX_VALUE;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] ingredients = new int[n][2];
    for (int i = 0; i < n; i++){
      ingredients[i][0] = sc.nextInt();
      ingredients[i][1] = sc.nextInt();
    }
    solve(ingredients, 0, 1, 0);
    System.out.println(minDiff);
  }
  public static void solve(int[][] ingredients, int index, int sour, int bitter){
    if (index == ingredients.length){
      return;
    }
    solve(ingredients, index+1, sour, bitter);
    sour *= ingredients[index][0];
    bitter += ingredients[index][1];
    int diff = Math.abs(sour - bitter);
    if (diff < minDiff){
      minDiff = diff;
    }
    solve(ingredients, index+1, sour, bitter);
    return;
  }
}