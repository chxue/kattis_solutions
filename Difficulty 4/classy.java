
import java.util.*;
import java.io.*;

class classy{
  //Difficulty: 3.9
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt(), i, j;
    for (i = 0; i < t; i++){
      int n = Rd.nextInt();
      Person[] ps = new Person[n];
      for (j = 0; j < n; j++){
        ps[j] = new Person(Rd.next(), Rd.next());
        Rd.next();
      }
      Arrays.sort(ps);
      for (j = n-1; j >= 0; j--){
        bw.write(ps[j].name + "\n");
      }
      bw.write("==============================\n");
    }
    bw.flush();
  }
}

class Person implements Comparable<Person>{
  String name, cls;
  public Person(String input1, String input2){
    name = input1.substring(0, input1.length()-1);
    String[] array = input2.split("-");
    StringBuilder sb = new StringBuilder();
    for (int i = array.length-1; i >= 0; i--){
      if (array[i].equals("lower")){
        sb.append("A");
      } else if (array[i].equals("middle")){
        sb.append("B");
      } else {
        sb.append("C");
      }
    }
    for (int i = 0; i < 10 - array.length; i++){
      sb.append("B");
    }
    cls = sb.toString();
  }
  
  public int compareTo(Person other){
    int res = this.cls.compareTo(other.cls);
    return res == 0? other.name.compareTo(this.name):res;
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