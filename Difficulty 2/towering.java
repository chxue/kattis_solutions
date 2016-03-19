import java.util.*;

class towering{
  //Difficulty: 2.0
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Integer[] heights = new Integer[6];
    for (int i = 0; i < 6; i++){
      heights[i] = sc.nextInt();
    }
    Arrays.sort(heights, Collections.reverseOrder());
    int target = sc.nextInt();
    int[] boxes = new int[3];
    solve(heights, -1, boxes, target, 0);
    List<Integer> remaining = new ArrayList<Integer>();
    for (int i: heights){
      if (!contains(boxes, i)){
        remaining.add(i);
      }
    }
    StringBuilder s = new StringBuilder();
    for (int i: boxes){
      s.append(i + " ");
    }
    for (int i: remaining){
      s.append(i + " ");
    }
    System.out.println(s);
  }
  public static boolean solve(Integer[] heights, int lastIndex, int[] boxes, 
                             int target, int pointer){
    if (target == 0){
      if (pointer == 3){
        return true;
      } else {
        return false;
      }
    }
    if (target < 0 || pointer == 3){
      return false;
    }
    for (int i = lastIndex+1; i < heights.length; i++){
      boxes[pointer] = heights[i];
      if (solve(heights, i, boxes, target-heights[i], pointer+1)){
        return true;
      }
    }
    return false;
  }
  
  public static boolean contains(int[] boxes, int h){
    for (int i: boxes){
      if (i==h){
        return true;
      }
    }
    return false;
  }
}