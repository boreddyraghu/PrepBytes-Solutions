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
	    void reverseLast(int n)
	    {
	      if(n == 1)
	        return;
	      else
	      {
	          Node prevNode = null;
	      Node currNode = head;
	      while(currNode != null && currNode.next != null)
	      {
	        prevNode = currNode;
	        currNode = currNode.next;
	      }
	      prevNode.next = null;
	      currNode.next = head;
	      head = currNode;
	      }
	    }
	    void printLinkedList()
	    {
	      Node currNode = head;
	      while(currNode != null)
	      {
	        System.out.print(currNode.data + " ");
	        currNode = currNode.next;
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
	        main.reverseLast(n);
	        main.printLinkedList();
	      }
	    }
  }