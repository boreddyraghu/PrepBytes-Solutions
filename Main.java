package com.test;
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
  Node lastNode = null;
  void insertNode(int data)
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
  void segregateEvenOdd()
  {
    Node oddHead = null;
    Node oddEnd = null;
    Node evenHead = null;
    Node currNode = head;
    Node prevNode = null;
    while(currNode != null)
    {
      prevNode = currNode;
      currNode = currNode.next;
      prevNode.next = null;
      if(prevNode.data%2 == 0)
      {
        if(evenHead == null)
        	evenHead = prevNode;
        else
        {
          prevNode.next = evenHead;
          evenHead = prevNode;
        }
      }
      else
      {
        if(oddHead == null)
        {
          oddHead = prevNode;
          oddEnd = oddHead;
        }
        else
        {
          oddEnd.next = prevNode;
          oddEnd = oddEnd.next;
        }
      }
    }
    if(oddHead == null)
    	head = evenHead;
    else if(evenHead == null)
    	head = oddHead;
    else 
    {
    	oddEnd.next = evenHead;
    	head = oddHead;
    }
  }
  Node reverseEvenLinkedList(Node evenHead)
  {
    if(evenHead != null)
    {
      Node prevNode = null, nextNode = null, currNode = evenHead;
      while(currNode != null)
      {
        nextNode = currNode.next;
        currNode.next = prevNode;
        prevNode = currNode;
        currNode = nextNode;
      }
      evenHead = prevNode;
    }
    return evenHead;
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
      main.segregateEvenOdd();
      main.printLinkedList();
    }
  }
}