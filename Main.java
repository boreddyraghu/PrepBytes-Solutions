import java.util.*;
import java.io.*;

class Node
{
  char data;
  Node next;
  Node(char data)
  {
    this.data = data;
    this.next = null;
  }
}

public class Main 
{
  Node head = null;
  Node lastNode = null;
  void insertNode(char data)
  {
    Node node = new Node(data);
    if(head == null)
    {
      head = node;
      lastNode = head;
    }
    else
    {
      lastNode.next = node;
      lastNode = node;
    }
  }
  void segregateVowelsAndConsonants()
  {
    Node vowelsHead = null;
    Node vowelsEnd = null;
    Node consonantsHead = null;
    Node consonantsEnd = null;
    Node currNode = head;
    Node prevNode = null;
    while(currNode != null)
    {
      prevNode = currNode;
      currNode = currNode.next;
      prevNode.next = null;
      char c = prevNode.data;
      if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
      {
        if(vowelsHead == null)
        {
          vowelsHead = prevNode;
          vowelsEnd = vowelsHead;
        }
        else
        {
          vowelsEnd.next = prevNode;
          vowelsEnd = prevNode;
        }
      }
      else
      {
        if(consonantsHead == null)
        {
          consonantsHead = prevNode;
          consonantsEnd = consonantsHead;
        }
        else
        {
          consonantsEnd.next = prevNode;
          consonantsEnd = prevNode;
        }
      }
    }
    if(vowelsHead == null)
    	head = consonantsHead;
    else if(consonantsHead == null)
    	head = vowelsHead;
    else 
    {
    	vowelsEnd.next = consonantsHead;
    	head = vowelsHead;
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
        main.insertNode(sc.next().charAt(0));
      main.segregateVowelsAndConsonants();
      main.printLinkedList();
    }
  }
}