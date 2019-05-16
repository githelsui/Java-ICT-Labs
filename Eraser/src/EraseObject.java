import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EraseObject 
{
	private String[][] myImage;
	private int myMaxRow;
	private int myMaxCol;
	
	public EraseObject(String fileName)
	{
		myImage = new String[21][21];
		for(int i = 1; i <= 20; i++)
		{
			for(int j = 1; j <= 20; j++)
			{
				myImage[i][j] = "-";
				
			}
		}
		myMaxRow = myImage.length;
		myMaxCol = myImage[0].length;
		loadFile(fileName);
	}
	

	 private void loadFile(String fileName)
	    {
	        try
	        {
	            Scanner file = new Scanner(new File(fileName));
	            file.nextInt();
	            while (file.hasNextInt())
	            {	 
	            	  int row = file.nextInt();
	                  int col = file.nextInt();
	            	myImage[row][col] = "@";
	            }
	            file.close();
	            
	        }
	        catch (IOException error)
	        {
	            System.out.println (error.getMessage());
	        }            
	    }
	 

	  public void prompt(int row, int col)
	  {
		 traceImage(myImage, row, col);
	  }
	  
	  public void traceImage(String[][] maze, int row, int col)
	  {

	    if (1 <= row && row < myMaxRow && 1 <= col && col < myMaxCol)
	    {
	      if (myImage[row][col].equals("@"))
	      {
	    	  		myImage[row][col] = "-";
			    	  traceImage(myImage, row - 1, col);
			          traceImage(myImage, row, col + 1);
			          traceImage(myImage, row + 1, col);
			          traceImage(myImage, row, col - 1);
				       
				      
		 }
				        
		}
	   }
	    
	  
	  
	  
	  public boolean isOutOfBounds(int row, int col)
	  {
		  if (1 <= row && row <= myMaxRow && 1 <= col && col <= myMaxCol)
		    {
			  return false;
		    }
		  return true;
	  }

	  public boolean isThereImage(int row,int col)
	  {
		  if((myImage[row][col]).equals("-"))
		  {
			  return false;
		  }
		  return true;
	  }


	 
	 public String result()
		{
		 	String result = "";
			result += "   ";
			int num = 1;
	        for(int i = 1; i <= 20; i++)
	        {
	   
	           result += (num % 10);
	           num++;
	         
	        }
	        result = result + "\n";
	        for(int i = 1; i <= 20; i++)
	        {
	        	if(i < 10)
	        	{
	        		result += i + "  ";
	        	}
	        	else
	        	{
	        	result += i + " ";
	        	}
	        	 
	        	 for(int j = 1; j <= 20; j++)
	        	 {
	        		 if(myImage[i][j].equals(("@")))
	        		 {
	        			 result += "@";
	        		 }
	        		 else
	        		 {
	        			 result += "-";
	        		 }
	            	
	        	 }
	        	 result = result + "\n";
	        }
	        result = result + "\n";
	        return result;
		}
	 

}
