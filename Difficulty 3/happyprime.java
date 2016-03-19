import java.util.*;
import java.io.*;

class happyprime{
  //Difficulty: 2.5
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), group = 1;
    int[] isPrime = new int[10001], isHappy = new int[10001];
    isPrime[1] = 1;
    for (int i = 3; i < 10001; i+=2){
      if (isPrime[i] == 0){
        for (int j = i * i; j < 10001; j += 2 * i){
          isPrime[j] = 1;
        }
      }
    }

    Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    boolean found = false;
    for (int i = 0; i < t; i++){
      bw.write(Rd.next());
      int m = Rd.nextInt();
      bw.write(" "+m);
      if (m % 2== 0 || isPrime[m] == 1){
        found = false;
      } else {
        while (isHappy[m] == 0){
          isHappy[m] = group;
          m = next(m);
          if (m == 1){
            isHappy[m] = group;
            map.put(group, true);
            break;
          }
        }
        if (map.keySet().contains(isHappy[m])){
          found = map.get(isHappy[m]);
          if (found){
            map.put(group, true);
          }
        } else {
          found = false;
          map.put(group, false);
        }
      }
      
      bw.write(found?" YES\n":" NO\n");
      group++;
    }
    bw.flush();
  }
  
  public static int next(int m){
    int sum = 0;
    while (m > 0){
      sum += Math.pow(m%10, 2);
      m /= 10;
    }
    return sum;
  }
}
class Rd{
  static BufferedReader reader;
  static StringTokenizer tokenizer;
  
  static void init(InputStream input) {
    reader = new BufferedReader(new InputStreamReader(input));
    tokenizer = new StringTokenizer("");
  }
  
  static String next() throws IOException {
    while (!tokenizer.hasMoreTokens()) {
      tokenizer = new StringTokenizer(reader.readLine() );
    }
    return tokenizer.nextToken();
  }
  
  static String nextLine() throws IOException {
    if (!tokenizer.hasMoreTokens()){
      return reader.readLine();
    }
    StringBuilder s = new StringBuilder();
    while (tokenizer.hasMoreTokens()){
      s.append(tokenizer.nextToken()+" ");
    }
    String out = s.toString();
    return out.substring(0, out.length()-1);
  }
  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
  
  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }
}