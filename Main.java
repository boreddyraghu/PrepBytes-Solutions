import java.util.*;
  import java.io.*;
 class Node
{
  int data;
  Node next;
  Node(int data)
  {
    this.data = data;
    this.next = null;
  }
}
 public class Main 
  {
    Node head = null;
	  void insertNode(int data)
    {
      Node node = new Node(data);
      if(head == null)
        head = node;
      else
      {
        Node tempNode = head;
        while(tempNode != null && tempNode.next != null)
          tempNode = tempNode.next;
        tempNode.next = node;
      }
    }
    void removeDuplicates()
    {
      Node currNode = head;
      while(currNode != null && currNode.next != null)
      {
        if(currNode.data == currNode.next.data)
        {
          currNode.next = currNode.next.next;
          //currNode = currNode.next;
        }
        else
          currNode = currNode.next;
      }
    }
    void printLinkedList()
    {
      Node tempNode = head;
      while(tempNode != null)
      {
        System.out.print(tempNode.data + " ");
        tempNode = tempNode.next;
      }
      System.out.println();
    }
    public static void main(String args[]) throws IOException
    {
    	Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0)
      {
	    	Main main = new Main();
	      int n = sc.nextInt();
	      for(int i = 0; i < n; ++i)
	        main.insertNode(sc.nextInt());
	       main.removeDuplicates();
	       main.printLinkedList();
      }
    }
  }