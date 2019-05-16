
import java.util.*;




public class Prompt
{


  public void prompt()
  {
	  Scanner console = new Scanner(System.in);
	String input;
	  

	  //System.out.println("Enter C to Calculate (single-digit)");
      
      Stack<Integer> myStack = new Stack<Integer>();
	  Queue<String> myOperations = new LinkedList<String>();
	  Queue<String> keyStrokes = new LinkedList<String>();
	  //enters inputs until Q quits
	  
	  
	  System.out.println();
      System.out.println("RPN CALCULATOR \n");
   
      
      System.out.println("Enter C to Calculate");
      System.out.println("Enter Q to Quit");
      System.out.println();
	  
	 do	 
	 {
		 
		 System.out.print("INPUT:");
          input = console.nextLine().toUpperCase();
          
			  if (!input.equals("C") && !input.equals("Q"))
			  {
			      if(input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/"))
			      {
				    	myOperations.add(input);
				    	String temp = calculate(myStack, myOperations, keyStrokes);
				    	if(temp.equals("no"))
				    	{
				    		System.out.println("error");
				    		System.out.println();
				    	}
				    	else
				    	{
				    	int result = Integer.parseInt(temp);
				    	myStack.push(result);
				    	keyStrokes.add(input);
				    	}
			  }
			      
			      else  // if input is a single digit integer
			      {
			    	  try
			    	  {
					      int number = Integer.parseInt(input);
					      myStack.add(number);
					  	 keyStrokes.add(input);
			    	  }
			    	  catch(NumberFormatException e)
			    	  {
			    		  e.printStackTrace();
			    	  }
			      }
		  }	
		  
		  else if(!input.equals("Q"))
	      {
	    	  while(!keyStrokes.isEmpty())
	    	  {
	    		  System.out.print(keyStrokes.remove() + " ");
	    	  }
	    	  System.out.println("= " + myStack.pop());
	    	   System.out.println();
	      }
	      
	  }
	 while(!input.equals("Q") );
		
		  
  }
  
  private String calculate(Stack<Integer> nums, Queue<String> ops, Queue<String> keys)
  {
	  Stack<Integer> stackCopy = nums;
	  Queue<String> qCopy = ops;
	  String result = "";
	  
	  while(!ops.isEmpty())
	  {
		  int num1 = nums.pop();	
	
		  int num2 = nums.pop();
		 
		  String op = ops.remove();

		  if(op.equals("+") )
	      {
		    result = "" + (num2 + num1) ;
	      }
		  if(op.equals("-") )
		  {
			  result = "" + (num2 - num1) ;
		  }
		  if(op.equals("*") )
		  {
			  result = "" + (num2 * num1) ;
		  }
		  if(op.equals("/") )
		  {
			  String temp = "" + num1;
			  if(temp.equals("0"))
			  {
				  result = "no";
				  
			  }
			  else
			  {
				  result = "" + (num2 / num1);
			  }
		  }
	  }
	  
	 return result;
	  
	
  
  }
  

}