
import java.util.*;
import java.io.*;

class dvaput{
  //Difficulty: 3.3
  //important lesson: Ukkonen's algorithm to construct a suffix tree
  //Code source: https://sites.google.com/site/indy256/algo/suffix_tree
  public static void main(String[] args) throws IOException{
    Rd.init(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int l = Rd.nextInt();
    String s = Rd.next();
    Node n = buildSuffixTree(s);
    bw.write(Integer.toString(DEPTH));
    bw.flush();
  }
  
  static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
  static int DEPTH = 0;
  public static class Node {
    int begin;
    int end;
    int depth; // distance in characters from root to this node
    Node parent;
    Node[] children;
    Node suffixLink;

    Node(int begin, int end, int depth, Node parent) {
      this.begin = begin;
      this.end = end;
      this.parent = parent;
      this.depth = depth;
      children = new Node[ALPHABET.length()];
    }
  }

  public static Node buildSuffixTree(String s) {
    int n = s.length();
    byte[] a = new byte[n];
    for (int i = 0; i < n; i++) a[i] = (byte) ALPHABET.indexOf(s.charAt(i));
    Node root = new Node(0, 0, 0, null);
    Node node = root;
    for (int i = 0, tail = 0; i < n; i++, tail++) {
      Node last = null;
      while (tail >= 0) {
        Node ch = node.children[a[i - tail]];
        while (ch != null && tail >= ch.end - ch.begin) {
          tail -= ch.end - ch.begin;
          node = ch;
          ch = ch.children[a[i - tail]];
        }
        if (ch == null) {
          node.children[a[i]] = new Node(i, n, node.depth + node.end - node.begin, node);
          if (last != null) last.suffixLink = node;
          last = null;
        } else {
          byte t = a[ch.begin + tail];
          if (t == a[i]) {
            if (last != null) last.suffixLink = node;
            break;
          } else {
            Node splitNode = new Node(ch.begin, ch.begin + tail, node.depth + node.end - node.begin, node);
            Node parent = splitNode;
            int d = 0;
            while (parent != null){
              d += parent.end - parent.begin;
              parent = parent.parent;
            }
            if (d > DEPTH)
              DEPTH = d;
            splitNode.children[a[i]] = new Node(i, n, ch.depth + tail, splitNode);
            splitNode.children[t] = ch;
            ch.begin += tail;
            ch.depth += tail;
            ch.parent = splitNode;
            node.children[a[i - tail]] = splitNode;
            if (last != null) last.suffixLink = splitNode;
            last = splitNode;
          }
        }
        if (node == root) {
          --tail;
        } else {
          node = node.suffixLink;
        }
      }
    }
    return root;
  }
}
class Rd {
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
  
  static long nextLong() throws IOException{
    return Long.parseLong(next());
  }
  
}