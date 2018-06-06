package LinkedStructures;

public class LinkedStack<T> {
  private Node first;
  private int items;
  private class Node {
    T item;
    Node next;
  }
  public boolean isEmpty() {return first ==null;}
  public int size() { return items;}
  public void push(T item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    items++;
  }
  public T pop() {
    T item = first.item;
    first = first.next;
    items--;
    return item;
  }/*
  public static void main(String[] args) {
    LinkedStack<String> stk = new LinkedStack<>();
    stk.push( "Hello");
    stk.push("Stack");
    // should print back words
    System.out.println( stk.pop());
    System.out.println( stk.pop());
  }*/
}
