import java.util.Scanner;

public class Driver
{
	public static void main(String[] args)
	  {
		
		 System.out.println("ArrayList Tester Has Been Initiated");
		 System.out.println();
		 System.out.println("Choose constructor for new ArrayList: ");
		 options();
		
		
		   
	  }
	
	private static void options()
	{
		 int choice;
	       
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
         		System.out.println("Arraylist with default capacity of 10 created.");
         	Main menu = new Main();
         	menu.mainMenu();
            break;
            
         	case 2:
         		Main non = new Main();
         		non.askCapacity();
         		non.mainMenu();
        	 }
         }
         else if (choice != -1)
         {
        	 System.out.println("Invalid Input. Try again.");
        	 options();
         }
	}
}
