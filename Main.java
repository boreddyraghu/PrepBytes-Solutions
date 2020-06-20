import java.util.*;
  import java.io.*;
  
  public class Main {
    public static int calcMid(LinkedList<Integer> ll, int n)
    {
      int mid = n/2;
      if(n%2 == 0)
        return ll.get(mid);
      else
        return ll.get(mid+1);
    }
    public static void main(String args[]) throws IOException {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-- > 0)
      {
        int n = sc.nextInt();
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i = 0; i < n; ++i)
          ll.add(sc.nextInt());
        System.out.println(calcMid(ll,n-1));
      }
    }
  }