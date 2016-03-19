import java.util.*;
import java.io.*;

class rationalarithmetic{
  //Difficulty: 2.5
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Rd.nextInt();
    int n1, d1, n2, d2;
    Fraction f1 = new Fraction(), f2 = new Fraction();
    String op;
    for (int i = 0; i < t; i++){
      n1 = Rd.nextInt();
      d1 = Rd.nextInt();
      op = Rd.next();
      n2 = Rd.nextInt();
      d2 = Rd.nextInt();
      f1.set(n1, d1);
      f2.set(n2, d2);
      if (op.equals("+")){
        f1.add(f2);
      } else if (op.equals("-")){
        f1.subtract(f2);
      } else if (op.equals("*")){
        f1.mult(f2);
      } else {
        f1.divide(f2);
      }
      f1.simplify();
      System.out.println(f1);
      //bw.write(f1.toString());
      //bw.newLine();
    }
    //bw.flush();
  }
  
  
}

class Fraction{
  long num = 0, den = 0;
  public Fraction(){
  }
  
  public void set(int n, int d){
    num = n;
    den = d;
  }
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(num);
    sb.append(" / ");
    sb.append(den);
    return sb.toString();
  }
  
  public void add(Fraction other){
    this.num = this.num*other.den + this.den*other.num;
    this.den = this.den * other.den;
  }
  
  public void subtract(Fraction other){
    this.num = this.num*other.den - this.den*other.num;
    this.den = this.den*other.den;
  }
  
  public void mult(Fraction other){
    this.num *= other.num;
    this.den *= other.den;
  }
  
  public void divide(Fraction other){
    this.num *= other.den;
    this.den *= other.num;
  }
  
  public void simplify(){
    if (den < 0){
      num *= -1;
      den *= -1;
    }
    long gcd = gcd(num, den);
    num /= gcd;
    den /= gcd;
  }
  
  public static long gcd(long a, long b){
    if (a < 0){
      a *= -1;
    }
    if (b < 0){
      b *= -1;
    }
    if (a > b){
      long temp = a;
      a = b;
      b = temp;
    }
    if (a == 0)
      return b;
    return gcd(b%a, a);
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
  
  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
  
}