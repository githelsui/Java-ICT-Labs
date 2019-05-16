import java.io.*;
public class ArrayList<E>
{
	
	private int mySize;
	private int myCapacity;
	private E[] myArray;
	
	public ArrayList()
	{
		this(10);
	}
	
	public ArrayList(int capacity)
	{
		myCapacity = capacity;
		myArray = (E[]) new Object[myCapacity];
		mySize = 0;
		
	}
	
	public boolean add(E element)
	{
		if(mySize < myCapacity)
		{
			myArray[mySize] = element;
			mySize++;
		}
		else
		{
			
			myArray = increaseCapacity(element);
		
		
		}
		return true;
	
	}
	
	public int getCapacity()
	{
		return myCapacity;
	}
	
	private E[] increaseCapacity(E element)
	{						
		int newCapacity = myCapacity * 2;
		int oldCapacity = myCapacity; //10
		myCapacity = newCapacity; //20
		
		E[] newArray =  (E[]) new Object[newCapacity];
		for(int i = 0; i < mySize; i++)
		{
			newArray[i] = myArray[i];
		}
		newArray[mySize] = element;
		mySize++;
		return newArray;
	}
	
	public int size()
	{
		return mySize;
	}
	
	public boolean isEmpty()  
	{
		if(mySize <= 0)
			return true;
		else
			return false;
	}
					//1
	public void add(int i, E element)
	{		
		if(i <= mySize && i >= 0)
		{
			if(mySize < myCapacity) 
			{
				
				   if(i == mySize) //at the end , no pushing
					{
						
						add(element);
					}
					else if(i == 0) // first element , push array to the right
					{
						  
						   E[] temp =  (E[]) new Object[myCapacity];
							temp[0] = element;
							int myArrayCount = 0;
							for(int j = 1; j < mySize+1; j++)
							{
								temp[j] = myArray[ myArrayCount];
								 myArrayCount++;
							}
							myArray = temp;
							mySize++;
					}
					else
					{
						
						 myArray = newArray(i, element);
						
					}
			}
			else
			{
				
				myArray = increaseCapacity(element);

			}
		}
		else
		{
			throw new IndexOutOfBoundsException("Index out of bounds exception. Index = " 
						+ i + "    Size = " + mySize);
		}
	}
	
	private E[] firstPart(int i)
	{ 
		E[] first =  (E[]) new Object[i];
		int count = 0;
		while(count < i )
		{
			first[count] = myArray[count];
			count++;
		}
		return first;
	}
	
	private E[] lastPart(int i, int firstLength)
	{
		int newCapacity = mySize - firstLength;
		E[] last =  (E[]) new Object[newCapacity];
		int count = 0;
		while(i < newCapacity)
		{
			last[count] = myArray[i];
			i++;
			count++;
		}
		return last;
	}
								//size = 7			//index = 3
	private E[] newArray(int i, E element)
	{
		E[] first = firstPart(i);  // 1, 2, 3 //length = 3
		int firstLength = first.length;
		E[] last = lastPart(i, firstLength); //4 , 5, 6, 7
		E[] newA =   (E[]) new Object[myCapacity];
		int fullLength = firstLength + last.length;
		for(int j = 0; j < firstLength; j++)
		{
			newA[j] = myArray[j];
		}
		newA[firstLength] = element; // index = 4
		int countOriginal = firstLength;
		for(int k = (firstLength + 1); k < fullLength+1; k++)
		{
			newA[k] = myArray[countOriginal];
			countOriginal++;
		}
		mySize++;
		return newA;
		
	}
	
	public E set(int i, E element)
	{
		if(i < mySize && i >= 0)
		{
			
				E old = myArray[i];
				myArray[i] = element;
				return old;
			
		}
		else	
		{
			throw new IndexOutOfBoundsException("Index out of bounds exception. Index = " 
					+ i + "    Size = " + mySize);
			}
	
	}
	
	public E get(int i)
	{
		if(i < mySize && i >= 0)
        {
		E obj = myArray[i];
		return obj;
        }
		else
		{
			throw new IndexOutOfBoundsException("Index out of bounds exception. Index = " 
					+ i + "    Size = " + mySize);
	
		}
	}

	public E remove(int i)
	{
		
		
		
		if(i < mySize && i >= 0)
        {
			E oldVal = myArray[i];
			if(i == mySize-1)// remove last
			{
			myArray[i] = null;
			mySize--;
			return oldVal;
			}
			else if(i == 0)
			{
				myArray[i] = null;
				E[] temp =  (E[]) new Object[myCapacity];;
				int newSize = mySize - 1;
				for(int j = 0; j < newSize; j++)
				{
					if(myArray[i] == null)
					{
						temp[j] = myArray[j+1];
					}
					else
					{
						temp[j] = myArray[j];
					}
					
				}
				myArray = temp;
				mySize--;
				return oldVal;
				
			}
			else //remove middle slot
			{	//3
	
				boolean check = true;
				myArray[i] = null; //make slot null
				E[] temp =  (E[]) new Object[myCapacity];;
				int newSize = mySize - 1;
				for(int j = 0; j < newSize; j++)
				{			//3
					if(check == true && myArray[j] == null)
					{
						check = false;
						temp[j] = myArray[j+1];
					}
					else if (check == true)
					{
						temp[j] = myArray[j];
					}	
					else if(check == false && myArray[j+1] != null)
					{
						temp[j] = myArray[j+1];
					}
				}
				
				/*while(myArray[i+1] != null)
				{
					temp[i+1] = myArray[i + 2];
				}*/
				
				myArray = temp;
				mySize--;
				return oldVal;
				
				
			}
        }
		else
		{
			throw new IndexOutOfBoundsException("Index out of bounds exception. Index = " 
					+ i + "    Size = " + mySize);
		}
		//account for middle index removal
		
	}
	
}
