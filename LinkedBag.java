package linkedstructures;

import java.io.File;
import java.io.FileNotFoundException;

/******************************************************************************
 *  Compilation:  javac LinkedBag.java
 *  Execution:    java LinkedBag < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  A generic bag or multiset, implemented using a singly linked list.
 *
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is
 *
 *  % java LinkedBag < tobe.txt
 *  size of bag = 14
 *  is
 *  -
 *  -
 *  -
 *  that
 *  -
 *  -
 *  be
 *  -
 *  to
 *  not
 *  or
 *  be
 *  to
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The {@code LinkedBag} class represents a bag (or multiset) of generic items.
 * It supports insertion and iterating over the items in arbitrary order.
 * <p>
 * This implementation uses a singly linked list with a non-static nested class
 * Node. See {@link Bag} for a version that uses a static nested class. The
 * <em>add</em>, <em>isEmpty</em>, and <em>size</em> operations take constant
 * time. Iteration takes time proportional to the number of items.
 * <p>
 * For additional documentation, see
 * <a href="https://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 * @author Ryan Migaud
 */
public class LinkedBag<Item> implements Iterable<Item> {
  private Node first; // beginning of bag
  private int n; // number of elements in bag
  
  // helper linked list class
  private class Node {
    private Item item;
    private Node next;
  }
  
  /**
   * Initializes an empty bag.
   */
  public LinkedBag() {
    first = null;
    n = 0;
  }
  
  /**
   * Is this bag empty?
   * 
   * @return true if this bag is empty; false otherwise
   */
  public boolean isEmpty() {
    return first == null;
  }
  
  /**
   * Returns the number of items in this bag.
   * 
   * @return the number of items in this bag
   */
  public int size() {
    return n;
  }
  
  /**
   * Adds the item to this bag.
   * 
   * @param item
   *          the item to add to this bag
   */
  public void add(Item item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    n++;
  }
  
  /**
   * Returns an iterator that iterates over the items in the bag.
   */
  public Iterator<Item> iterator() {
    return new ListIterator();
  }
  
  // an iterator over a linked list
  private class ListIterator implements Iterator<Item> {
    private Node current;
    
    // creates a new iterator
    public ListIterator() {
      current = first;
    }
    
    // is there a next item in the iterator?
    public boolean hasNext() {
      return current != null;
    }
    
    // this method is optional in Iterator interface
    public void remove() {
      throw new UnsupportedOperationException();
    }
    
    // returns the next item in the iterator (and advances the iterator)
    public Item next() {
      if (!hasNext())
        throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
  
  /**
   * Unit tests the {@code LinkedBag} data type.
   *
   * @param args
   *          the command-line arguments
   */
  public static void main(String[] args) {
    LinkedBag<String> bag = new LinkedBag<String>();
    Scanner input = null;
    try {
      input = new Scanner( new File( "../Maze-Runner/src/testfile6.txt"));
    } catch (FileNotFoundException e) {
      // FileNotFoundException
      e.printStackTrace();
    }
    
    while (input.hasNext()) {
      String item = input.nextLine();
      bag.add( item);
    }
    
    System.out.println( "passing each line as an element, size of bag = " + bag.size());
    StringBuilder sb = new StringBuilder();
    
    for (String s : bag) {
      sb.insert( 0, s + "\n"); // reverse stack
    }
    System.out.println( sb.toString());
    input.close();
  }
}
/*
 * Copyright © 2000–2017, Robert Sedgewick and Kevin Wayne. Last updated: Fri
 * Oct 20 12:50:46 EDT 2017.
 */