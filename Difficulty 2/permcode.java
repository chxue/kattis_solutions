import java.util.*;

class permcode{
  //Difficulty: 1.9
  //important lesson: (x^y)^y = x^(y^y) = x
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      int x = sc.nextInt();
      if (x == 0){
        return;
      }
      char[] s = sc.next().toCharArray(),
        p = sc.next().toCharArray(),
        c = sc.next().toCharArray();
      int n = c.length;
      char[] m = new char[n];
      Arrays.fill(m, '*');
      int d = (int)(Math.pow(n, 1.5) + x)%n;
      m[d] = p[find(s, c[d])];
      for (int i = 1; i < n; i++){
        int index = (d-i+n)%n;
        m[index] = p[find(s, c[index])^find(s, m[(index+1)%n])];   
      }
      StringBuilder out = new StringBuilder();
      for (char cc: m){
        out.append(cc);
      }
      System.out.println(out);
      
    }
  }
  
  public static int find(char[] array, char c){
    for (int i = 0; i < array.length; i++){
      if (array[i] == c){
        return i;
      }
    }
    return -1;
  }
}