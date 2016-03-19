import java.util.*;

class okvir{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int height = sc.nextInt(), width = sc.nextInt(), up = sc.nextInt(),
      left = sc.nextInt(), right = sc.nextInt(), down = sc.nextInt();
    int bh = height + up + down, bw = width + left + right;
    String s="";
    char[] bgs = {'#','.'};
    char bg = bgs[0];
    for (int i = 0; i < bh; i++){
      bg = bgs[i%2];
      if (i >= up && i < bh-down){
        s = sc.next();
      } else {
        s = "";
      }
      for (int j = 0; j < bw; j++){
        if (!s.equals("") && j >= left && j < bw-right){
          System.out.print(s.charAt(j-left));
        } else {
          System.out.print(bg);
        }
        if (bg == '#'){
          bg = '.';
        } else {
          bg = '#';
        }
      }
      System.out.println();
    }
  }
  
}