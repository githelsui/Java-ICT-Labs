import java.util.*;
import java.io.*;

/**
 *  Implements a recursive mergesort on a LinkedList data type
 *
 * @author     G. Peck
 * @created    July 18, 2002
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006
 */
public class MergeList
{
  private  Scanner inFile;
  private String myFile;
 

  /**
   *  Open a file containing id/inventory pairs of data
   *
   * @param  fileName  File to be opened
   */
  public MergeList(String fileName)
  {
		   
		   myFile = fileName;
	      
  }

  /**
   *  Reads a file containing id/inv data pairs. The first line of the
   *  file contains the number of id/inventory integer pairs listed on
   *  subsequent lines.
   *
   * @param  list  Reference to LinkedList to which data will be added
   */
  public void readData(LinkedList<Item> list)
  {

  	try
  	{
  		inFile = new Scanner(new File(myFile));
  		while(inFile.hasNextInt())
  		{
  		  int id = inFile.nextInt();
          int inv = inFile.nextInt();
          Item it = new Item(id, inv);
          list.addFirst(it);
  		}


    }
  catch(IOException i)
  	{
    	System.out.println("Error: " + i.getMessage());
    }
  }

  /**
   *  Prints contents of list
   *
   * @param  list  linked list to be printed
   */
  public void printList(LinkedList<Item> list)
  {
    

    System.out.printf("%5s%16s","Id","Inventory\n");
    for(int i = 0; i < list.size(); i++)
    {
    System.out.printf("%5s%8s",list.get(i).getId(),list.get(i).getInv());
    System.out.println();
    }
    
    System.out.println();
  }
  
  public LinkedList<Item> mergeSort(LinkedList <Item> listA)
  {
    LinkedList <Item> listB = new LinkedList <Item>();

    if (listA == null)
    {
      return null;
    }
    // Don't sort an empty list or a list with one node
    if (listA.size() <= 1)
    {
      return listA;
    }

    // Split the list in half.  If uneven then make left one larger.
    split(listA, listB);

    return merge(mergeSort(listA), mergeSort(listB));
  }

  /**
   *  Splits listA into two parts. listA retains the first
   *  half of the list, listB contains the last half of
   *  the original list.
   *
   * @param  listA    Original list. reduced by half after split.
   * @param  listB    Contains last half of the original list
   */
  public void split(LinkedList<Item> listA, LinkedList<Item> listB)
  	{
	  Iterator <Item> it = listA.listIterator(listA.size() / 2);
	  while(it.hasNext())
	  {
			 Item obj = it.next();
			 it.remove();
			 listB.add(obj);
		 
	  }


    }
  

  /**
   *  Two linked lists listA and listB are merged into a single
   *  linked list mergedList. They are placed in mergedList starting
   *  with the smallest item on either list and continue working up to
   *  to largest item.
   *
   * @param  listA   LinkedList in nondecreasing order
   * @param  listB   LinkedList in nondecreasing order
   * @return         List  containing all the values from lists listA
   *                 and listB, in nondecreasing order
   */
  public LinkedList<Item> merge(LinkedList<Item> listA, LinkedList<Item> listB)
  {
    // make sure the target list is empty
    LinkedList <Item> merged = new LinkedList <Item>();
    ListIterator<Item> itA = listA.listIterator();
    ListIterator<Item> itB = listB.listIterator();
    
    while(itA.hasNext() && itB.hasNext())
    {
    	Item itemA = itA.next();
        Item itemB = itB.next();
    	if(itemA.compareTo(itemB) <= 0)
             {
            	 merged.add(itemA);
            	 itB.previous();
                 
             }
             else
             {
            	 merged.add(itemB);
            	 itA.previous();
         
             }
    }
    while(itA.hasNext()) 
    {
    	merged.add(itA.next());
    }
    while(itB.hasNext()) 
    {
    	merged.add(itB.next());
    }
    return merged;
  }

  /**
   *  Reverses the order of a list
   *
   * @param  list  LinkedList to be reversed
   * @return       List in reverse order
   */
  public LinkedList<Item> reverseList(LinkedList <Item>list)
  {
	  LinkedList<Item> reverse = new LinkedList<Item>();
    Iterator <Item> it = list.iterator();
    while(it.hasNext())
    {
    	reverse.addFirst(it.next());
    }
return reverse;

    

  }
}
