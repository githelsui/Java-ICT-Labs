import java.io.*;
import java.util.Scanner;
public class Main
{
    private Scanner console;
    private ArrayList<String> myList;

    public Main()
    {
        console = new Scanner(System.in);
        myList = new ArrayList<String>();
    }
    
    public Main(int cap)
    {
        console = new Scanner(System.in);
        myList = new ArrayList<String>(cap);
    }
    
  

    private void singleInput()
    {
        console = new Scanner(System.in);
        System.out.println("All inputs will be added to the list as strings");
        String input;
        boolean test = true;
        do
        {
            System.out.print("Enter String input (Enter -1 twice to exit): ");
            input = console.nextLine();
            if(input.equals("-1"))
            {
            	 System.out.print("Hit any key to add -1 to list OR ");
            	 System.out.print("Enter -1 to exit: ");
            	 input = console.nextLine();
            	 if(input.equals("-1") != true)
            	 {
            		 myList.add("-1");
            		 System.out.println("-1 has been added to list");
            		 test = false;
            	 }
            }
            else
            {
                myList.add(input);
                System.out.println("'" + input + "' has been added to the list");
                
            }
	}
        while(input.equals("-1") == false);
    }

    private void doubleInput()
    {
        System.out.println("All inputs will be added to the list as strings");
        String input ="";
        int index ;
        do
        {
        	 console = new Scanner(System.in);
           	 System.out.print("Enter valid index (-1 to quit): ");
             index = console.nextInt();
        	 
          
        
            
            if(index != -1)
            {				//10
            	if(index <= myList.size() && index >= 0)
            	{
            	console = new Scanner(System.in);
                System.out.print("Enter String input: ");
                input = console.nextLine();
            	
             	  
                     myList.add(index,input);
                     System.out.println("Object '" + input + "' has been added to slot " + index);
              
            	}
            	else
            	{
            		try
            		{
            			
            			 myList.add(index,input);
            		}
            		catch(IndexOutOfBoundsException e)     
                 	{
                 		System.out.println(e.getMessage());
                 	}

            	}
            }
            
            
            
        }while(index != -1);
    }

    private void set()
    {
        
        String item = "";
        int index;
       
        System.out.println("All new inputs will be handled as Strings");
    
        do
        {
        	console = new Scanner(System.in);
        	System.out.print("Enter Valid Index (-1): ");
            index = console.nextInt();
            if(index != -1)
            {
	        	if(index < myList.size() && index >= 0)
	        	{	
		            
		            	console = new Scanner(System.in);
		            	System.out.print("Enter New String:");
		                item = console.nextLine();
		            	
		            		 myList.set(index,item);
		            		 System.out.println("Object '" + item + "' has replaced slot " + index);
		            	
		            
	        	}
	        	else
	        	{
	        		try
            		{
            			
            			 myList.set(index,item);
            		}
            		catch(IndexOutOfBoundsException e)     
                 	{
                 		System.out.println(e.getMessage());
                 	}
	        	}
        }
            
        }while(index != -1);
    }

    private void printList()
    {
    	if(myList.isEmpty())
    	{
    		System.out.println("List is empty.");
    	}
    	else
    	{
	        for(int i = 0; i < myList.size(); i++)
	        {
	            System.out.println(i + ":     " + myList.get(i));
	        }
    	}
    	System.out.println();
    }

    private void get()
    {
        console = new Scanner(System.in);
        int index;
        do
        {
            System.out.print("Enter input (-1 to quit): ");
            index = console.nextInt();
            if(index != -1)
            {
            	 if(index < myList.size() && index >= 0)
                 {
	                
	                    Object gotten = myList.get(index);
	                    System.out.println("Object at index " + index + " is: " + gotten);
	               
                 }
            	 else
            	 {
            		 try
             		{
             			
             			 myList.get(index);
             		}
             		catch(IndexOutOfBoundsException e)     
                  	{
                  		System.out.println(e.getMessage());
                  	}
            	 }
            }
        }while(index != -1);
    }

    private void remove()
    {
        console = new Scanner(System.in);
        int index;
        do
        { 
        
            System.out.print("Enter index to remove (-1 to quit): ");
            index = console.nextInt();
            if(index != -1)
            {
                if(index < myList.size() && index >= 0)
                {
                    String returned = myList.remove(index);
                    System.out.println("Object at index " + index + " , " + returned + ", has been removed.");
                }
                else
                {
                	try
            		{
            			
            			 myList.remove(index);
            		}
            		catch(IndexOutOfBoundsException e)     
                 	{
                 		System.out.println(e.getMessage());
                 	}
                }
            }
        }while(index != -1);
    }
    
    public void askCapacity()
    {
    	System.out.println("Nondefault constructor");
    	int cap = 0;
    	 console = new Scanner(System.in);
    	 
	    	System.out.print("Enter capacity of array: ");
	    	cap = console.nextInt();
	    	if(cap >= 0)
	    	{
	    		if(cap == 0) 
	    		{
	    		
	    			System.out.println("Cannot create ArrayList with 0 capacity.");
	    			System.out.println("Capacity must be greater than 0. Try again.");
	    			System.out.println();
	    			createNew();
	    		}
	    		else
	    		{
		       	 myList  = new ArrayList<String>(cap);
		       	 System.out.println("New ArrayList created with capacity of " + myList.getCapacity());
	    		}
	    	}  		
	    	else
	    	{
	    		System.out.println("Capacity cannot be less than zero.");
	    		System.out.println("Capacity must be greater than 0. Try again.");
	    				createNew();
	    	}
    
    	
    	 
    }
    
   public void createNew()
    {
    	 int choice;
    	 System.out.println("Choose constructor for new ArrayList");
 		Scanner console = new Scanner(System.in);
 		 System.out.println();
 		 System.out.println(" (1) Default");
          System.out.println(" (2) Nondefault");
          System.out.println(" (-1) Quit");
          System.out.print("Choice ---> ");
          choice = console.nextInt();
          
          System.out.println();
          
          console = new Scanner(System.in);
          if (choice > 0 && choice <= 2)
          {
         	 switch(choice)
         	 {
         	 
          	case 1:
          		System.out.println("ArrayList with default capacity of 10 created.");
          		 myList  = new ArrayList<String>();
             break;
             
          	case 2:
          		askCapacity();
          	
         	 }
          }
          else if (choice != -1)
          {
         	 System.out.println("Invalid Input. Try again.");
         	 createNew();
          }
    }

    public void mainMenu()
    {
        int choice;
       
     
        
        do
        {
            System.out.println(" (1) Size");
            System.out.println(" (2) isEmpty");
            System.out.println(" (3) Add w/ 1 Parameter");
            System.out.println(" (4) Add w/ 2 Parameter");
            System.out.println(" (5) Set");
            System.out.println(" (6) Get");
            System.out.println(" (7) Remove");
            System.out.println(" (8) Print List");
            //System.out.println(" (9) Create new ArrayList (Deletes current list)");
            System.out.println("(-1) Quit\n");
            System.out.print("Choice ---> ");
            choice = console.nextInt();
            System.out.println();

            if (choice > 0 && choice <= 8)
            {
                switch(choice)
                {
                    case 1:
                    System.out.println("List Size: " + myList.size());
                    break;

                    case 2:
                    if(myList.isEmpty())
                    {
                        System.out.println("List is Empty");
                    System.out.println();
                    }
                    else
                    {
                        System.out.println("List is not Empty");
                    System.out.println();
                    }
                    break;

                    case 3:
                    singleInput();
                    break;

                    case 4:
                    doubleInput();
                    break;

                    case 5:
                    set();
                    break;

                    case 6:
                    get();
                    break;

                    case 7:
                    remove();
                    break;

                    case 8:
                    printList();
                    break;
                    
                    /*case 9:
                   createNew();	
                    break;*/
                    
                   
                    
                }
            }
            else if(choice == -1)
            {
                break;
            }
            else
            {
                System.out.println("Invalid Option Selected");
            }
        }
        while (choice != -1);
    }
}

