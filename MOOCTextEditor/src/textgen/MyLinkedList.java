package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);// Sentinel nodes
		tail = new LLNode<E>(null);// Sentinel nodes
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		size++;
		if (element == null){
			throw new NullPointerException("Null input");
		}

		LLNode<E> newNode = new LLNode<E>(element);
		newNode.prev = tail.prev;// prev of newNode points to prev of tail
		newNode.next = tail;// next of newNode points to tail
		tail.prev.next = newNode;// the node before tail connected to newNode
		tail.prev = newNode;// tail connected with newNode
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException("Invalid index");
		}

		// head and tail are sentinel nodes
		// which are null, like beacons
		// real nodes with data come between them
		LLNode<E> curNode = head;
		while( index >= 0){
			curNode = curNode.next;
			index--;
		}

		return curNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		size++; // update Size at first
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException("Invalid index");
		} else if (element == null){
			throw new NullPointerException("Null input");
		}

		LLNode<E> curNode = head;// curNode finds where to add newNode
		while( index >= 0){
			curNode = curNode.next;
			index--;
		}
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.next = curNode;
		newNode.prev = curNode.prev;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException("Invalid index");
		}
		LLNode<E> curNode = head;// curNode finds where to remove
		while( index >= 0){
			curNode = curNode.next;
			index--;
		}

		E reData = curNode.data;
		curNode.prev.next = curNode.next;
		curNode.next.prev = curNode.prev;
		size--;

		return reData;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException("Invalid index");
		} else if (element == null){
			throw new NullPointerException("Null input");
		}
		LLNode<E> curNode = head;// curNode finds where to add newNode
		while( index >= 0){
			curNode = curNode.next;
			index--;
		}

		E curData = curNode.data;
		curNode.data = element;
		return curData;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public LLNode(){
		this.prev = null;
		this.next = null;
	}

}
