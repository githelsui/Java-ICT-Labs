/**
 *  Description of the Class
 *
 * @author     G. Peck
 * @created    July 18, 2002
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006 
 */
import java.util.*;

public class HashTable
{
  private int size;
  private int capacity;
  private ListNode[] myHashTable;

  public HashTable()
  {
     size = 0;
    capacity = 600;
    myHashTable = new ListNode[capacity];    
  }

  public HashTable(int numSlots)
  {
    size = 0;
    capacity = numSlots;
    myHashTable = new ListNode[capacity];
  }
 
  public void print()
  {
	  for(int i = 0; i < myHashTable.length; i++)
	  {
		  if(myHashTable[i] != null) 
		  {
			  ListNode temp = myHashTable[i];
				  System.out.print(i + ": ");
				
			
				  
				  while(temp != null)
				  {					       
					  System.out.print("[" + temp.getValue().toString() + "]    ");

					  temp = temp.getNext();
					 
				  }
				  System.out.println();
			  
		  }
		  else
		  {
			  System.out.println(i + ":  " );
		
		  }
		
		
	  }
	
	
  }
  
  private int nonNullList()
  {
	  int non = 0;
	  for(int i = 0; i < 600; i++)
	  {
		  if(myHashTable[i] != null) 
		  {
			  non++;
		  }
	  }
	  return non;
  }
  
  public double averageList()
  {
	  int avg = 0;
	  for(int i = 0; i < 600; i++)
	  {
		  ListNode temp = myHashTable[i];
		
			  while(temp != null)	  
			  {
				  avg++;
				  temp = temp.getNext();
			  }
	  }
	  return  avg / (600.0- getNumberOfNulls());
	  
  }

  
  public int getSize()
  {
    return size;
  }

  public int getCapacity()
  {
    return capacity;
  }

  public void add(Object obj)
  {
    // add to array in location determined by call to hashCode()   
	  int index = obj.hashCode();
	//  ListNode temp = new ListNode(obj);
	  if(myHashTable[index] != null)
	  {
		  ListNode temp = myHashTable[index] ;
		  ListNode listobj = new ListNode(obj, temp);
		  myHashTable[index]  = listobj;
	 
	  }
	  else
	  {
		  ListNode temp =  new ListNode(obj);
		  myHashTable[index] = temp;
	  }

    size++;
  }

  public Object find(Comparable target)
  {
  // will attempt to find idToFind in table, if found return inv amount,
  // else return null  (use hashCode to find location, if it's in there)
    int index = target.hashCode();
    ListNode thing;
    if(myHashTable[index] != null)
    {
    	thing = myHashTable[index];
    	while(!thing.getValue().equals(target))
    	{
    		thing = thing.getNext();
    	}
    	return thing.getValue();
    
    }

	return null;
  }

  public int getNumberOfNulls()
  {
	 
	  int nulls = 0;
	  int i = 0;
      while(i <600)
	    {
		   if( myHashTable[i] == null)
		   {
			   nulls++;
		   }
		   i++;
	    }
	return nulls;
  }
  
  public double percentOfNulls()
  {
	  return (getNumberOfNulls()/600.0) * 100;
  }

  public int getLongestList ()
 {
	  int winner= 0;
	  for(int i = 0; i < 600; i++)
	  {
		  int current = 0;
		  ListNode temp = myHashTable[i];
		  if(temp != null)
		  {
			  while(temp != null)	  
			  {
				  current++;
				  temp = temp.getNext();
			  }
			  if(current > winner)
			  {
				  winner = current;
			  }
		  }
	  }
	return winner;
  }
}