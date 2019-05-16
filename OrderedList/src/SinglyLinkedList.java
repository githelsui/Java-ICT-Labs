import java.util.NoSuchElementException;

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
		 
	 
	  if(last == null)
	  {
		  last =   new ListNode(value, first);;
		  first = last;
	  }
		else
		{
			ListNode val = new ListNode(value, first);
			first = val;
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
  
  public ListNode find(Item obj)
  {
	  ListNode temp = first;  
	  ListNode win = null;
	    while (temp != null) 
	    {
	    	
	    	if(obj.compareTo(temp.getValue()) == 0)
	    	{
	    		win = temp;
	    	}
	     temp = temp.getNext();

	    }
	    return win;
  }
  
  public void insert(Item obj)
  {
	  ListNode temp = first;  
	  if(temp == null)
	  {
		  addLast(obj);
	  }
	  else
	  {
		  ListNode previous = null;
		  while (temp != null && obj.compareTo(temp.getValue()) > 0) 
		    {
			  previous = temp;
			  temp = temp.getNext();
		    }
			
			  if(previous == null)
			  {						
				
				addFirst(obj);							 
			 }
			  else if(previous == last)		 
			  {
			    	
			    		addLast(obj);
			  }
			  
			  else
			  {
				 
				  ListNode val = new ListNode(obj);
		    		previous.setNext(val);
		    		val.setNext(temp);
		    		
				  
			  }
			
		    }

		}
		
	  
  
  public boolean remove(Item obj)
  {
	  	  ListNode i = first;  
		  ListNode previous = null;
		    while (i != null) 
		    {
		    	
		    	if(obj.compareTo(i.getValue()) == 0)
		    	{
		    
		    		if(obj.compareTo(first.getValue()) == 0)
		    		{
		    			first = first.getNext();
		    			return true;
		    		}
		    		else
		    		{
		    		ListNode after = i.getNext();
		    		previous.setNext(after);
		    		return true;
		    		}
		    	}
		    	previous = i;
		    i = i.getNext();
		     
		    }
		    return false;
		    
	  
  }
  
  public void clear()
  {
	  first = null;
	  last = null;
  }
  
  public void printBackwards()
  {
	  ListNode temp = first;
	  if(temp != null)
	  {
		  printHelper(temp);
		  
	  }
  }
  
  private void printHelper(ListNode node)
  {
	  if(node.getNext() != null)
	  {
	  printHelper(node.getNext());
	  }
      System.out.println(node.getValue() + " ");
	 
  }
  
  
  /**
   *  Print the contents of the entire linked list
   */
  public void printList()
  {
	    ListNode temp = first;  
	    while (temp != null)
	    {
	      System.out.println(temp.getValue() + " ");
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
