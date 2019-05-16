import java.util.NoSuchElementException;

public class CircularlyLinkedList
{
	private ListNode first;
	private ListNode last; // first element

	/**
	 * Constructor for the SinglyLinkedList object Generates an empty list.
	 */
	public CircularlyLinkedList()
	{
		first = null;
		last = null;
	}

	/**
	 * Returns the first element in this list.
	 *
	 * @return the first element in the linked list.
	 */
	public Object getFirst()
	{
		if (first == null)
		{
			throw new NoSuchElementException();
		} else
			return first.getValue();
	}

	public Object getLast()
	{
		if (last == null)
		{
			throw new NoSuchElementException();
		} else
			return last.getValue();
	}

	/**
	 * Inserts the given element at the beginning of this list.
	 *
	 * @param value
	 *            the element to be inserted at the beginning of this list.
	 */
	public void addFirst(Object value)
	{

		if (first == null)
		{

			first = new ListNode(value);
			first.setNext(first);
			first.setPrevious(first);
			last = first;

		} else
		{

			ListNode val = new ListNode(value, first, last);
			first.setPrevious(val);
			last.setNext(val);
			first = val;

		}

	}

	public void addLast(Object value)
	// Takes in value, creates a new node, adds the new node
	// at the end of the list.
	{
		if (last == null)
		{

			last = new ListNode(value);
			last.setNext(last);
			last.setPrevious(last);
			first = last;
		} else
		{

			ListNode val = new ListNode(value, first, last);
			last.setNext(val);
			first.setPrevious(val);
			last = val;
		}
	}

	public ListNode find(Item obj)
	{
		ListNode temp= first;
		ListNode win = null;
		if(temp == null) 
		{
			return null;
		}
		else
		{
			do
			{
				if (obj.compareTo(temp.getValue()) == 0)
				{
					win = temp;
				}
				temp = temp.getNext();
			} while (temp != first);
			return win;
		}
	}

	public void insert(Item obj)
	{
		ListNode current = first;
		if (first == null)
		{
			addFirst(obj);
		} 
		else if (obj.compareTo(first.getValue()) < 0)
		{
			addFirst(obj);
		} 
		else if(obj.compareTo(last.getValue()) > 0)
		{
			addLast(obj);
		}
		else
		{
			do
			{
				current = current.getNext();
			} while (current != last && obj.compareTo(current.getValue()) > 0);

			
				ListNode before = current.getPrevious();
				ListNode val = new ListNode(obj, current, before);
				before.setNext(val);
				current.setPrevious(val);

			
		}
	}

	public boolean remove(Item obj)
	{
		ListNode current = first;
		if(current == null)
		{
			return false;
		}
		if(current == first && current == last && obj.compareTo(current.getValue()) == 0)
		{
			
			clear();
			return true;
		}
		else
		{
			if(obj.compareTo(first.getValue()) == 0)
			{
				
				ListNode newFirst = first.getNext();
				newFirst.setPrevious(last);
				last.setNext(newFirst);
				first = newFirst;
				return true;
			}
			else
			{
				do
				{
					current = current.getNext();
				} while (current != first  && !(obj.compareTo(current.getValue()) == 0));
				
		
				if (current == first)
				{
					
					return false;
				}
		
				if (current == last)
				{
					
					last.getPrevious().setNext(first);
					last = last.getPrevious();
					first.setPrevious(last);
					return true;
				} else
				{
					
					ListNode after = current.getNext();
					ListNode before = current.getPrevious();
					before.setNext(after);
					after.setPrevious(before);
					return true;
				}
			}
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
		if(first != null && last != null)
		{
			
			do
			{
				System.out.println(i + ":  " + temp.getValue() + " ");
				temp = temp.getPrevious();
				i++;
			} while (temp != last);
		
		}
		else
		{
			System.out.println("Nothing in list");
		}
		
	}

	/**
	 * Print the contents of the entire linked list
	 */
	public void printList()
	{
		int i = 1;
		ListNode temp = first;
		if(first != null && last != null)
		{
			do
			{
	
				System.out.println(i + ":  " + temp.getValue() + " ");
				temp = temp.getNext();
				i++;
			} while (temp != first);
		}
		else
		{
			System.out.println("Nothing in list");
		}

	}

	public int size()
	{
		ListNode temp = first;
		int count = 0;
		if(temp != null)
		{
			do
			{
				count++;
				temp = temp.getNext();
			} while (temp != first);

			return count;
		}
		else
		{
			return 0;
		}
			
	}

	
	/**
	 * Returns a string representation of this list. The string representation
	 * consists of the list's elements in order, enclosed in square brackets
	 * ("[]"). Adjacent elements are separated by the characters ", " (comma and
	 * space).
	 *
	 * @return string representation of this list
	 */
	public String toString()
	{
		String s = "[";

		ListNode temp = first; // start from the first node
		while (temp != null)
		{
			s += temp.getValue(); // append the data
			temp = temp.getNext(); // go to next node
			if (temp != null)
				s += ", ";
		}
		s += "]";
		return s;
	}
}