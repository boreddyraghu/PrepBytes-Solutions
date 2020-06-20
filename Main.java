import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
     Scanner sc = new Scanner(System.in);
     int t = sc.nextInt();
     while(t-- > 0)
     {
       int n = sc.nextInt();
       System.out.println(++n);
     }
    }
  }