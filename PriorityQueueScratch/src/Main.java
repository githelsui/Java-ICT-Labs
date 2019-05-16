
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main
{
    PriorityQueue<Item> myQueue;
    
    public Main()
    {
        myQueue = new PriorityQueue<Item>();
    }
     
    private void loadFile(String fileName)
    {
        int id, inv;
        Scanner inFile;
        try
        {
            inFile = new Scanner(new File(fileName));

            while(inFile.hasNext())
            {
                id = inFile.nextInt();
                inv = inFile.nextInt();
    
                Item temp = new Item(id,inv);
                myQueue.add(temp);
                
            }
        }
        catch(IOException i)
        {
            System.out.println("Error: " + i.getMessage());
        }
    }
    
    private void singleInput()
    {
        Scanner console = new Scanner(System.in);
        System.out.println("All items will be added to the list as int");
        int id;
        int inventory;
       do
        {
                System.out.print("Enter ID (-1 to quit): ");
                id = console.nextInt();
                if(id != -1)
                {
                    System.out.print("Enter inventory: ");
                    inventory = console.nextInt();
                    Item temp = new Item(id, inventory);
                    myQueue.add(temp);
                    System.out.println("Item: " + id + ", " + inventory + " has been added to the queue");
                }
        }
        while(id != -1);
    }
      
    private void askEmpty()
    {
       if(myQueue.isEmpty())
         	{
         		System.out.println("Queue is empty.");
         	}
       else
       {
     		System.out.println("Queue is not empty");
     	}
    }
    
    public void printList()
    {
        PriorityQueue<Item> temp = new PriorityQueue<Item>();
        temp = myQueue;
        int i = 1;
        while(myQueue.isEmpty() == false)
        {
              System.out.println(i + ": " + myQueue.remove());
              i++;
        }
    }
    
    private void peekPrompt()
    {
       
        System.out.println("First element in queue is: " + myQueue.peek()); 
      
     
    }
    
    private void removePrompt()
    {
        try
        {
            System.out.println("First element: " + myQueue.remove() + " has been removed.");
        }
        catch(NoSuchElementException e)     
     	{
        	System.out.println(e.getMessage());
        }
    }
    
    
    
      public void menu()
      {
        Scanner console = new Scanner(System.in);
        String choice;
        int choiceInt = -1;
        do
        {
          System.out.println();
          System.out.println("Priority Queue Main Menu\n");
          System.out.println("(1) Load Queue from File");
          System.out.println("(2) Add");
          System.out.println("(3) Is Empty");
          System.out.println("(4) Peek");
          System.out.println("(5) Remove");
        /* System.out.println("(6) Print in Order");
          System.out.println("(7) Print from Tree");*/
          // System.out.println("(8) Size");
          System.out.println("(-1) Quit");
          System.out.print("Choice ---> ");
          choice = console.nextLine();
          System.out.println();
          
          choiceInt = Integer.parseInt(choice);
          if(choiceInt >= 1 && choiceInt <= 5)
          {
                switch (choiceInt)
                {
                  case 1 :
                      System.out.println("File has been loaded.");
                      loadFile("file20.txt");
                     
                      break;
                  case 2 :
                      singleInput();
                      //ask for id and inv then create item
                      break;
                  case 3 :
                      askEmpty();
                      break;
                  case 4:
                      peekPrompt();
                      break;
                  case 5:
                      removePrompt();
                      break;
                     /* case 6: //print through queue
                       printList();
                     
                     break;
                case 7: //print through arraylist
                  myQueue.print();
                    break;
                    case 8:
                    System.out.println(myQueue.mySize());
                      break;*/
                  
                    
                      
                }
          }
        }
        while (choiceInt != -1);
      }
}
           
          
          
          
          
          
          
          
          
          
