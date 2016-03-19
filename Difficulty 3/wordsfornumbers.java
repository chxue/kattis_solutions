import java.util.*;
import java.io.*;

class wordsfornumbers{
  //Difficulty: 2.4
  public static final String[] under20 = {"zero", "one", "two", "three", "four", "five", "six",
    "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
    "sixteen", "seventeen", "eighteen", "nineteen"};
  public static final String[] mult10 = {"twenty", "thirty", "forty", "fifty", "sixty",
    "seventy", "eighty", "ninety"};
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (sc.hasNextLine()){
      String[] line = sc.nextLine().split(" ");
      for (int i = 0; i < line.length; i++){
        String s = line[i];
        try{
          String written = convert(Integer.parseInt(s));
          if (i == 0)
            written = capitalize(written);
          bw.write(written + " ");
        } catch (Exception e){
          bw.write(s + " ");
        }
      }
      bw.newLine();
      bw.flush();
    }
    //bw.flush();
  }
  
  public static String convert(int n){
    if (n < 20){
      return under20[n];
    }
    StringBuilder sb = new StringBuilder();
    sb.append(mult10[n/10-2]);
    n = n%10;
    if (n != 0)
      sb.append("-" + under20[n]);
    return sb.toString();
  }
  
  public static String capitalize(String s){
    StringBuilder sb = new StringBuilder();
    sb.append(Character.toUpperCase(s.charAt(0)));
    sb.append(s.substring(1));
    return sb.toString();
  }
}