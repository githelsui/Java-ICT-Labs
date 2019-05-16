/**
 *  Binary tree lab
 *
 * @author     G. Peck
 * @created    July 2, 2003
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006
 */
import java.util.Scanner;
import java.io.*;


public class BSTree{

  void testFind(BinarySearchTree temp)
  {
	Scanner console = new Scanner(System.in);
	String letterToDelete;
	Object location;

    System.out.println("Testing search algorithm\n");
    System.out.print("Enter letter to search for (-1 to quit) --> ");
    letterToDelete = console.nextLine().toUpperCase();

    while (!letterToDelete.equals("-1"))
    {
      location = temp.find(letterToDelete);
      if (location == null)
        System.out.println("letter = " + letterToDelete + "  does not exist.");
      else
        System.out.println(letterToDelete + " exists");
      System.out.println();
      System.out.print("Enter letter to search for (-1 to quit) --> ");
      letterToDelete = console.nextLine().toUpperCase();
    }
  }
  
  public void printLevel(BinarySearchTree temp)
  {
	  Scanner console = new Scanner(System.in);
	  int level;
	  if(temp.countNodes() != 0)
	  {
	    System.out.println("Print level (Level 0 - Level " + (temp.height()-1) + ")\n");
	  }
	  else
	  {
		  System.out.println("No levels in tree");
	  }
	    System.out.print("Enter level to be printed (-1 to quit) --> ");
	    level = console.nextInt();

	    while (level > -1)
	    {
	    	if(level < temp.height())
	    	{
	    	System.out.println();
	    	System.out.println("Level " + level);
	    	temp.printLevel(level);
	    	System.out.println();
	    	}
	    	else
	    	{
	    		System.out.println("Level does not exist");
	    	}
	    	System.out.println();
	        System.out.print("Enter level to be printed (-1 to quit) --> ");

	        level = console.nextInt();
	    }
  }

  public void testDelete(BinarySearchTree temp)
  {
	  Scanner console = new Scanner(System.in);
	  String letterToDelete ;
    boolean success;

    System.out.println("Testing delete algorithm\n");
    System.out.print("Enter letter to delete (-1 to quit) --> ");
    letterToDelete = console.nextLine().toUpperCase();

    while (!letterToDelete.equals("-1"))
    {

      if (temp.find(letterToDelete) == null)
      {
        System.out.println("letter = " + letterToDelete + "  does not exist");
      }
      else
      {   
        temp.delete(letterToDelete);
        System.out.println("letter = " + letterToDelete + " was deleted");
      }
      System.out.println();
      System.out.print("Enter letter to delete (-1 to quit) --> ");

      letterToDelete= console.nextLine().toUpperCase();
    }

  }
  
  public void ancestorTest(BinarySearchTree temp)
  {
	  Scanner console = new Scanner(System.in);
	  String first;
	  String second;

	    System.out.println("isAncestor\n");
	    System.out.print("Enter ancestor (-1 to quit)--> ");
	    first = console.nextLine().toUpperCase();
	    
	   
	    while (!first.equals("-1"))
	    {
	    	 System.out.print("Enter descendant letter --> ");
	 	    second = console.nextLine().toUpperCase();
	    	  if(temp.isAncestor(first, second) )
	    	  { 	
	    		  if(first.equals(second))
			    	  {
	    		  			System.out.println(first + " is not an ancestor of " + second); 
			    	  }
			    	  else
			    	  {
			    		  System.out.println(first + " is an ancestor of " + second); 
			    	  }
	    	  }
	    	  else
	    	  {
	    		  System.out.println(first + " is not an ancestor of " + second);
	    	  }
	    	System.out.println();      
	    	System.out.print("Enter ancestor (-1 to quit)--> ");
	 	    first = console.nextLine().toUpperCase();
	    }
  }
  
  

  public void readData (BinarySearchTree temp){
    Scanner inFile;

    String fileName = "fileC.txt";
   String letter;
	try{
    	inFile = new Scanner(new File(fileName));
		while(inFile.hasNext()){
      		letter = inFile.nextLine();
      		temp.insert(letter);
    	}
    }catch(IOException i){
    	System.out.println("Error: "+ i.getMessage());
    }
  }

  public void mainMenu (BinarySearchTree root)
  {
	Scanner console = new Scanner(System.in);
    String choice;
    int choiceInt = -1;
    do
    {
    	 System.out.println();
      System.out.println("Binary tree menu\n");
      System.out.println("(1) Fill the tree from a file");
      System.out.println("(2) Preorder output");
      System.out.println("(3) Inorder output (Stacks & Queues)");
      System.out.println("(4) Postorder output");
      System.out.println("(5) Count nodes in tree");
      System.out.println("(6) Count leaves in tree");
      System.out.println("(7) Find the height of the tree"); 
      System.out.println("(8) Find the width of the tree"); 
      System.out.println("(9) Clear the tree");
      System.out.println("(10) Interchange the tree(mirror image)"); //*
      System.out.println("(11) Print level"); 
      System.out.println("(12) isAncestor"); 
      System.out.println("(13) Search tree");
      System.out.println("(14) Delete from tree");
      System.out.println("(15) Print BY level");
      
      System.out.println("(-1) Quit");
      System.out.print("Choice ---> ");
      choice = console.nextLine();
      System.out.println();

     choiceInt = Integer.parseInt(choice);
      if(choiceInt >= 1 && choiceInt <=  15)
      {
        switch (choiceInt)
        {
          case 1 :
            readData(root);
            break;
          case 2 :
            System.out.println();
            System.out.println("The tree printed preorder\n");
            System.out.println();
            root.preOrder();
            System.out.println();
            break;
          case 3 :
        	  System.out.println();
          

              System.out.println();
              root.print();
              System.out.println();
            break;
          case 4 :
        	  System.out.println();
              System.out.println("The tree printed postorder\n");
              System.out.println();
              root.postOrder();
              System.out.println();
            break;
          case 5 :
           System.out.println("Number of nodes = " + root.countNodes ());
            System.out.println();
            break;
          case 6 :  
        	  System.out.println("Number of leaves = " + root.countLeaves());
              System.out.println();
              break;
          case 7 :
        	  System.out.println("Height of the tree = " + root.height());
              System.out.println();
        	  break;
          case 8:
        	  System.out.println("Width of the tree = " + root.width());
              System.out.println();
        	  break;
          case 9:
        	  System.out.println("Tree cleared");
        	  root.clearTree(); 	  
        	  break;
          case 10:
        	  System.out.println("Tree has been mirrored");
        	  System.out.println();
        	  root.interchange();
        	  break;
          case 11:
              printLevel(root);
        	  break;
          case 12:
        	  ancestorTest(root);
        	  break;
          case 13:
        	  testFind(root);
              break;
          case 14:
        	  testDelete(root);
              break;
          case 15:
        	  System.out.println();
              System.out.println("The tree printed by level");
              System.out.println();
              root.printByLevel();
              System.out.println();
        	 
        }
      } 
    }
    while (choiceInt != -1);
  }
  

}