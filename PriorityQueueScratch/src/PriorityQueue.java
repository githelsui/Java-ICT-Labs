import java.io.*;
import java.util.NoSuchElementException;
public class PriorityQueue<E>
{
    //private E[] myQueue;
    private ArrayList<E> myList;
    
    public PriorityQueue()
    {
         myList  = new ArrayList<E>();
         myList.add(null);
    }
                    //196
    public void add(E item)
    {       
            myList.add(item);   
        //    int temp = myList.size() -1; //2
            heapUp();  
    }
    					//index = 
    private void heapUp()
    {
    	int i =  myList.size() -1; 
        E item = myList.get(i);
        if(i/2 != 0) 
        {
        
            Comparable insert = (Comparable)item;
                //runs only if insert(18618)    < parent(196)
            while(i/2 != 0 && insert.compareTo((Comparable)myList.get(i/2)) < 0)
            {
                            //3
                E temp = myList.get(i/2);
                myList.set((i/2), item);
                //4 
                myList.set(i, temp);
                i = i / 2; 
                
            }
        }
    }
    
    public int mySize()
    {
        return myList.size() - 1;
    }
    
    public boolean isEmpty()
    {
        if(myList.size()  == 1)
        {
            return true;
        }
        else
        {
        	return false;
        }
    }
    
    
    public E peek()
    {
    	if(isEmpty())
    	{
    		return null;
    	}
    	else
    	{
        return myList.get(1);
    	}
    }
    
    public void print()
    {
        for(int i = 0; i < myList.size(); i++)
        {
            System.out.println(i + ": " + myList.get(i));
        }
    }
    
    public E remove()
    {
    	if(isEmpty())
    	{
    		throw new NoSuchElementException("Queue is empty. Nothing to remove.");
    	}
    	else
    	{
        E removed = myList.get(1); 
        myList.set( 1, myList.get(myList.size() - 1) );
        myList.set(myList.size()-1, removed);
        // E newNode = myList.get(1);
        myList.remove(myList.size()-1);
        if(myList.size() > 1)
        {
        heapDown();
        }
        
        return removed;
    	}
    }
    					//element is node heaping down node
    public void heapDown()
    {
        int i = 1;
        E element = myList.get(i);
        //System.out.println("runhello");
         Comparable node = (Comparable)element; //97 i/2 != 0 && 
         
            while(2*i <= myList.size()-1 && ((2*i) + 1) <= myList.size()-1)
            {
            	
            	
                Comparable leftChild = (Comparable)myList.get(2*i); //196
                Comparable rightChild= (Comparable)myList.get((2*i) + 1); //206
         
                if( node.compareTo(leftChild) > 0 || node.compareTo(rightChild) > 0 )
                {
                   // System.out.println("the node is larger than its children");
                    if(leftChild.compareTo(rightChild) < 0)
                    {
                        if(leftChild.compareTo(node) < 0)
                        {
                            E temp = myList.get(2*i); //18
                            myList.set(2*i, element);
                            //index at 1 is now 18
                            myList.set(i, temp);
                            i = 2 * i; 
                        }
                    }
                    else if(rightChild.compareTo(leftChild) < 0)//test2 > test1 or if its null???
                    {
                        if(rightChild.compareTo(node) < 0)
                        {
                            E temp = myList.get((2*i) + 1); //18
                            myList.set((2*i) + 1, element);
                            //index at 1 is now 18
                            myList.set(i, temp);
                            i = (2*i) + 1; 
                        }
                    }
                }
                else //first element is already smaller than both its chil
                {
                    i = (2 * i); 
                }
            }
        }
}
