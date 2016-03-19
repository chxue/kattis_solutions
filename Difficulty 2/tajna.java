import java.util.*;
import java.io.*;

class tajna{
  //Difficulty: 1.9
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String encrypted = sc.next();
    int l = encrypted.length(), r = 0, pos = 0;
    for (int i = (int) Math.sqrt(l); i > 0; i--){
      if (l % i == 0){
        r = i;
        break;
      }
    }
    char[] decrypted = new char[l];
    for (int i = 0; i < l; i++){
      decrypted[i] = encrypted.charAt(pos);
      pos += r;
      if (pos >= l){
        pos = (pos + 1) % l;
      }
    }
    bw.write(new String(decrypted));
    bw.flush();
  }
}