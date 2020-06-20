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
    void insertMissingNode(int k)
    {
      Node node = new Node(k);
      if(k <= head.data)
      {
        node.next = head;
        head = node;
      }
      else
      {
        Node prevNode = null;
        Node currNode = head;
        while(currNode != null)
        {
          prevNode = currNode;
          currNode = currNode.next;
          if(currNode != null)
          {
            if(prevNode.data <= node.data && node.data <= currNode.data)
            {
              node.next = prevNode.next;
              prevNode.next = node;
              break;
            }
          }
        }
        if(currNode == null)
        {
          prevNode.next = node;
        }
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
	      int k = sc.nextInt();
	      main.insertMissingNode(k);
	      main.printLinkedList();
      }
    }
  }