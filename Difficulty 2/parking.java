import java.util.*;

class parking{
  //Difficulty: 1.6
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] fee = new int[4];
    for (int i = 1; i < 4; i++){
      fee[i] = sc.nextInt() * i;
    }
    int[] record = new int[100];
    for (int i = 0; i < 3; i++){
      int enter = sc.nextInt()-1;
      int leave = sc.nextInt()-1;
      for (int j = enter; j < leave; j++){
        record[j]++;
      }
    }
    int pay = 0;
    for (int i = 0; i < 100; i++){
      pay += fee[record[i]];
    }
    System.out.println(pay);
  }
}