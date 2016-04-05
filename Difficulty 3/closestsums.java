import java.util.*;
import java.io.*;
class closestsums{
  //Difficulty: 2.7
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = 1, n;
    while (Rd.hasMoreTokens()){
      n = Rd.nextInt();
      bw.write("Case " + (t++) +  ":\n");
      int[] nums = new int[n];
      for (int i = 0; i < n; i++){
        nums[i] = Rd.nextInt();
      }
      Arrays.sort(nums);
      int m = Rd.nextInt();
      for (int i = 0; i < m; i++){
        int q = Rd.nextInt();
        bw.write("Closest sum to " + q + " is ");
        int minDiff = Integer.MAX_VALUE, min=nums[0] +nums[1];
        for (int j = 0; nums[j] <= q/2 && j < nums.length-1; j++){
          int remain = q-nums[j];
          
          int index = search(nums, remain, j+1, nums.length-1);
          if (Math.abs(remain-nums[index]) <minDiff){
            minDiff = remain-nums[index];
            min = q-minDiff;
          }
          if (index < nums.length-1 && Math.abs(nums[index+1]-remain) < minDiff){
            minDiff = nums[index+1]-remain;
            min = q+minDiff;
          }
        }
        bw.write(min + ".\n");
      }
      
    }
    bw.flush();
  }
  
  public static int search(int[] array, int searched, int left, int right){
    
    if (left == right){
      return left;
    }
    int mid = (left+right)/2;
    if (array[mid] == searched){
      return mid;
    }
    if (array[mid] < searched){
      if (array[mid+1] > searched){
        return mid;
      }
      left = mid+1;
    } else {
      right = mid;
    }
    return search(array, searched, left, right);
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
  
  static boolean hasMoreTokens() { 
    while (tokenizer == null || !tokenizer.hasMoreTokens()) { 
      String s = null; 
      try { 
        s = reader.readLine(); 
      } catch (IOException e) { 
        e.printStackTrace(); 
      } 
      if (s == null) 
        return false; 
      tokenizer = new StringTokenizer(s); 
    } 
    return true; 
  }
  
  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }
  
  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }
}