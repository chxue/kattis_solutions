import java.util.*;

class permutedarithmeticsequence{
  //Difficulty: 1.7
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++){
      int n = sc.nextInt();
      int[] sequence = new int[n];
      boolean arithmetic = true;
      int last = 0;
      for (int j = 0; j < n; j++){
        sequence[j] = sc.nextInt();
      }
      if (arithmetic(sequence)){
        System.out.println("arithmetic");
      } else {
        Arrays.sort(sequence);
        if (arithmetic(sequence)){
          System.out.println("permuted arithmetic");
        } else {
          System.out.println("non-arithmetic");
        }
      }
    }
  }
  
  public static boolean arithmetic(int[] sequence){
    int last = 0;
    for (int i = 0; i < sequence.length; i++){
      if (i > 0){
        int current = sequence[i]-sequence[i-1];
        if (i > 1 && current != last){
          return false;
        }
        last = current;
      }
    }
    return true;
  }
}