import java.util.*;

class dicegame{
  //Difficulty: 
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int gunnar = 0, emma = 0;
    for (int i = 0; i < 4; i++){
      gunnar += sc.nextInt();
    }
    for (int i = 0; i < 4; i++){
      emma += sc.nextInt();
    }
    System.out.println(gunnar > emma? "Gunnar": emma > gunnar? "Emma": "Tie");
  }
}