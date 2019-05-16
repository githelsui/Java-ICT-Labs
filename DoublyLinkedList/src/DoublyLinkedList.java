import java.util.NoSuchElementException;

public class DoublyLinkedList 
{
	private ListNode first;  
	  private ListNode last; // first element
	  /**
	   *  Constructor for the SinglyLinkedList object
	   *  Generates an empty list.
	   */
	  public DoublyLinkedList()
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
			 
		 
		  if(first == null)
		  {
			  first = new ListNode(value);
			 last = first;
		  }
			else
			{
				
				ListNode val = new ListNode(value);
				val.setNext(first);
				first.setPrevious(val);
				val.setPrevious(null);
				first = val;
		    }
	   
	  }
	  
	  public void addLast(Object value)
	//Takes in value, creates a new node, adds the new node
	//at the end of the list.
	{
		if(last == null)
		  {
			ListNode obj = new ListNode(value);
			last = obj;
			first = last;
		  }
		else
		{
			
			ListNode val = new ListNode(value, null, last);
			last.setNext(val);
			last = val;
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
		  ListNode current = first;  
		  if(current == null)
		  {
			  addLast(obj);
		  }
		  else 
		  {
				  while (current != null && obj.compareTo(current.getValue()) > 0) 
				    {
					  current = current.getNext();				
				    }
				  
				  	if( current == first )
				  	{
				  	   
				  		addFirst(obj);
				  	}
				  	else if(current == null)
				  	{
				  		addLast(obj);
				  	}
				  	else
				  	{
				  		ListNode before = current.getPrevious();
						  ListNode val = new ListNode(obj);
						 before.setNext(val);	
						  val.setPrevious(before);
						  val.setNext(current);
						  current.setPrevious(val);
						  
				  	}			    
			  }
		  }
	
	  
			
		  
	  
	  public boolean remove(Item obj)
	  {
		  	  ListNode current = first;
		  	  while(current != null && !( obj.compareTo( current.getValue() ) == 0 ))
		  	  {
		  		  current = current.getNext();
		  	  }
		  	  
		  	  if(current == null)
		  	  {
		  		  return false;
		  	  }
		  	  
		  	  if(current == first)
		  	  {
		  		 
		  		  first = current.getNext();
		  		  if(first != null)
		  		  {
		  			  
		  			  first.setPrevious(null);
		  		  }
		  		  else
		  		  {
		  			  last = null;
		  		  }
		  		//  System.out.println("first");
		  		 
		  		  return true;
		  	  }
		  	  else if (current ==last)
		  	  {
		  		  last.getPrevious().setNext(null);
		  		  if(last != null)
		  		  {		  		  
		  			  last = last.getPrevious();
		  		  }
		  		  else
		  		  {
		  			  first = null;
		  		  }
		  		  return true;
		  	  }
		  	  else
		  	  {
		  		  ListNode after = current.getNext();
		  		  ListNode before = current.getPrevious();
		  		  before.setNext(after);
		  		  after.setPrevious(before);
		  		  return true;
		  	  }
	  }
	  
	  public void clear()
	  {
		  first = null;
		  last = null;
	  }
	  
	  public void printBackwards()
	  {
		  int i = 1;
		  ListNode temp = last;
		  while(temp != null)
		  {
			  System.out.println(i + ":  " + temp.getValue() + " ");
			  temp = temp.getPrevious();
			  i++;		  
		  }
	  }
	  
	  
	  /**
	   *  Print the contents of the entire linked list
	   */
	  public void printList()
	  {
		  int i = 1;
		    ListNode temp = first;  
		    while (temp != null)
		    {
		      System.out.println(i + ":  " + temp.getValue() + " ");
		   /*   if(temp.getPrevious() == null)
				{
					 System.out.println("    " + "previous: null");
				}
				else
				{
		      System.out.println("    " + "previous: " + (temp.getPrevious()).getValue());
				}
		      if(temp.getNext() == null)
		      {
		      System.out.println("    " + "next: null");
		      }
		      else{  System.out.println("    " + "next: " + (temp.getNext()).getValue());
		      }
		      System.out.println();*/
		      temp = temp.getNext(); 
		      i++;
		    }
		    
		 // testPrevious();
		    
		   
	  }
	  
	  public void testPrevious()
	  {
		  int i = 1;
		    ListNode temp = first;  
		    while (temp != null)
		    {
		      System.out.println(i + ":  " + (temp.getPrevious()).getValue() + " ");
		      temp = temp.getNext(); 
		      i++;
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
