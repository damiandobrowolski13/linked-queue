/******************************************************************************
 *
 * Implements the generic queue interface using a linked list.
 * @author Damian Dobrowolski
 * @date 10.16.2023
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code LinkedQueue} class represents a first-in-first-out
 * (FIFO) queue of object references. It supports the usual
 * <em>enqueue</em> and <em>dequeue</em> operations, along with
 * methods for peeking at the top item, etc.
 *
 * This implementation uses a singly-linked list with a nested class
 * for linked-list nodes. The <em>enqueue</em>, <em>dequeue</em>,
 * <em>peek</em>, <em>size</em>, and <em>isEmpty</em> operations all
 * take constant time in the worst case.
 * @author S. Anderson based
 */

public class LinkedQueue<T> implements Queue<T>, Iterable<T> {
    private int n;        // number of elements on queue
    private Node head;    // beginning of queue
    private Node tail;    // end of queue

    // helper class for nodes in a linked structure
    private class Node {
        private T item;   // the item in the node
        private Node next;   // reference to next item

        public Node(T theitem, Node thenext) {
           this.item = theitem;
           this.next = thenext;
       }

    } // end of Node class

    /**
     * Initializes an empty queue.
     */
    public LinkedQueue() {
        head = null;
        tail = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        // DONE
        return n == 0;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T peek() throws NoSuchElementException{
        // DONE
        if (isEmpty()){
            throw new NoSuchElementException("Cannot peek at empty queue.");
        }
        return head.item;
    }

    /**
     * Add the item to the queue.
     */
    public void enqueue(T item) {
        // DONE
        Node oldTail = tail;
        tail = new Node(item, null);
        if (isEmpty()){
            head = tail;
        }
        else {
            oldTail.next = tail;
        }
        n++;
    }

    /**
     * Removes and returns the head item.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T dequeue() throws NoSuchElementException{
        // DONE
        if (isEmpty()){
            throw new NoSuchElementException("Cannot dequeue an empty queue.");
        }
        T oldItem = head.item;
        head = head.next;
        n--;
        return oldItem;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        // DONE
        String items = "";
        Node node = head;
        while (node != null){
            items += node.item + " ";
            System.out.println(node.item);
            node = node.next;
        }
        return items;
    }


    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<T> {
        private Node current = head;  // node containing current item

        public boolean hasNext() {
            // DONE
            return current.next != null;
        }

        // Not implemented
        public void remove() {
	    // leave this next line.
        throw new UnsupportedOperationException();
        }

        public T next() throws NoSuchElementException{
            // DONE
            if (!hasNext()){
                throw new NoSuchElementException("No next element.");
            }
            current = current.next;
            return current.item;
        }
    } // end of ListIterator

} // end of LinkedQueue

