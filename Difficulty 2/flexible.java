import java.util.*;

class flexible{
  //Difficulty: 1.8
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int w = sc.nextInt(), n = sc.nextInt();
    int[] partitions = new int[n+2];
    partitions[0] = 0; partitions[n+1] = w;
    for (int i = 1; i <= n; i++){
      partitions[i] = sc.nextInt();
    }
    Set<Integer> widths = new TreeSet<Integer>();
    for (int i = 0; i < partitions.length-1; i++){
      for (int j = i+1; j < partitions.length; j++){
        widths.add(partitions[j]-partitions[i]);
      }
    }
    String output = widths.toString();
    System.out.println(output.substring(1, output.length()-1).replace(","," "));
  }
}