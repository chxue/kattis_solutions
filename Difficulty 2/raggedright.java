import java.util.*;

class raggedright{
  //Difficulty: 1.5
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    List<Integer> size = new ArrayList<Integer>();
    for (int i = 0; i < 100; i++){
      if (sc.hasNextLine()){
        String line = sc.nextLine();
        if (line.length() > 0){
          size.add(line.length());
        }
      }
    }
    int max = 0;
    for (int i: size){
      if (i > max){
        max = i;
      }
    }
    int ragged = 0;
    for (int i = 0; i < size.size()-1; i++){
      ragged += (max - size.get(i)) * (max-size.get(i));
    }
    System.out.println(ragged);
  }
}