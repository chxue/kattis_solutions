import java.util.*;
import java.io.*;

class guess{
  //Difficulty: 3.1
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int low = 1, high = 1000, guess = 500;
    bw.write(guess + "\n");
    bw.flush();
    String answer;
    while (sc.hasNextLine() && !(answer = sc.nextLine()).equals("correct")){
      if (answer.equals("lower")){
        high = guess-1;
        guess = (low + high)/2;
      } else {
        low = guess+1;
        guess = (low + high)/2;
      }
      bw.write(guess + "\n");
      bw.flush();
    }
  }
}