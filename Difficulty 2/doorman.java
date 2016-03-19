import java.util.*;

class doorman{
  //Difficulty: 2.0
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int dif = sc.nextInt(), m = 0, w = 0, first = 0, i = 0;
    String line = sc.next();
    while (Math.abs(m-w) <= dif && i < line.length()){
      if (first == 1 && m-w < dif){
        first--;
        m++;
      } else if (first == -1 && w-m < dif){
        first++;
        w++;
      } else {
        if (line.charAt(i++) == 'M'){
          m++;
        } else {
          w++;
        }
        if (m-w > dif){
          if (first == 0){
            first++;
            m--;
          } else {
            break;
          }
        } else if (w-m > dif){
          if (first == 0){
            first--;
            w--;
          } else {
            break;
          }
        }
      }
    }
    System.out.println(m+w-Math.abs(first));
  }
}