/**
 *  Description of the Class
 *
 * @author     G. Peck
 * @created    July 18, 2002
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006
 *
 */
import java.io.*;
import java.util.*;

public class heapSort
{
  PriorityQueue <Item> myHeapPQ;
  String myFile;

  public heapSort()
  {
    this("file20.txt");
  }

  public heapSort(String fName)
  {
    myHeapPQ = new PriorityQueue <Item>();
    loadFile(fName);
    myFile = fName;
  }

  private void loadFile(String fileName){
    int id, inv;
    Scanner inFile;
	try{
   		inFile = new Scanner(new File(fileName));

    	while(inFile.hasNext()){
    		id = inFile.nextInt();
      		inv = inFile.nextInt();
      		Item temp = new Item(id,inv);
      		myHeapPQ.add(temp);
      		
    	}
    }
	catch(IOException i)
	{
    	System.out.println("Error: " + i.getMessage());
    }
  }
  
 

  public void sort()
  {
	  int i = 1;
	  try
	  {					//file20.txt
		 String original = myFile;
		  int length = original.length(); //file20update.
		  String without = original.substring(0, length - 4);
		 String fileName = without + "update.txt";
		
		PrintWriter bw = new PrintWriter(fileName);
		while(!myHeapPQ.isEmpty())
		{
			Item temp = myHeapPQ.remove();
			String write = temp.toString();
			bw.println(write);
			
			//buffered writer
			System.out.println(i + "      Written in file: " + write);
			i++;
			
		}
		System.out.println("File has been written: " + fileName);
		bw.close();
	  }
	  catch (IOException ioe) {
		   ioe.printStackTrace();
	  }
}
}