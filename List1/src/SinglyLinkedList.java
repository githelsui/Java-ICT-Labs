import java.util.*;

/**
 *  Implementation of lists, using singly linked elements.
 *
 * @author     G. Peck
 * @created    April 27, 2002
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9,2006
 */
public class SinglyLinkedList
{
  private ListNode first;  
  private ListNode last; // first element
  /**
   *  Constructor for the SinglyLinkedList object
   *  Generates an empty list.
   */
  public SinglyLinkedList()
  {
    first = null;   
    last = null;
  }

  /**
   *  Returns the first element in this list.
   *
   * @return  the first element in the linked list.
   */
  public Object getFirst()
  {
    if (first == null)
    {
      throw new NoSuchElementException();
    }
    else
      return first.getValue();
  }  
  
  public Object getLast()
  {
    if (last == null)
    {
      throw new NoSuchElementException();
    }
    else
      return last.getValue();
  }  

  /**
   *  Inserts the given element at the beginning of this list.
   *
   * @param  value  the element to be inserted at the beginning of this list.
   */
  public void addFirst(Object value)
  {
		 
	  first = new ListNode(value, first);
	  if(last == null)
	  {
		  last =first;
	  }
   
  }
  
  public void addLast(Object value)
//Takes in value, creates a new node, adds the new node
//at the end of the list.
{
	
	if(first == null)
	  {
		last = new ListNode(value, null);
		  first = last;
	  }
	else
	{
		ListNode val = new ListNode(value, null);
		last.setNext(val);
		last = last.getNext();
    }
	 
	
}
  
  
  /**
   *  Print the contents of the entire linked list
   */
  public void printList()
  {
	    ListNode temp = first;  
	    while (temp != null)
	    {
	      System.out.print((Integer)temp.getValue() + " ");
	      temp = temp.getNext(); 
	    }

  }
  
  public int size()
  {
	  ListNode temp = first;  
	  int count = 0;
	    while (temp != null) 
	    {
	     count++;
	     temp = temp.getNext();

	    }
	    return count;
  }

  /**
   *  Returns a string representation of this list. The string
   *  representation consists of the list's elements in order,
   *  enclosed in square brackets ("[]"). Adjacent elements are
   *  separated by the characters ", " (comma and space).
   *
   * @return    string representation of this list
   */
  public String toString()
  {
    String s = "[";

    ListNode temp = first;  // start from the first node
    while (temp != null)
    {
      s += temp.getValue(); // append the data
      temp = temp.getNext();      // go to next node
      if (temp != null)
        s += ", ";
    }
    s += "]";
    return s;
  }  
  
}
