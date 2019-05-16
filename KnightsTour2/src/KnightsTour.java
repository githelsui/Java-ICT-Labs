import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class KnightsTour 
{
	private int[][] myAccess;
	private int[][] myMatrix;
	private ArrayList<Integer> horizontal;
	private ArrayList<Integer> vertical;
	private int visited;
	
	public KnightsTour(String fileName)
	{
		myAccess = new int[9][9];
		myMatrix=new int[9][9];
		loadFile(fileName);
		initializeMovesList();
		visited = 0;
	
	
		
	}
	
	 private void loadFile(String fileName)
	    {
	        try
	        {
	            Scanner file = new Scanner(new File(fileName));
	            while (file.hasNextInt())
	            {
	            	for(int i = 1; i < myAccess.length; i++)
	        		{
	        			for(int j = 1; j < myAccess[i].length; j++)
	        			{
	        				  myAccess[i][j] = file.nextInt(); 
	        			}
	        		}
	            }
	            file.close();
	            
	        }
	        catch (IOException error)
	        {
	            System.out.println (error.getMessage());
	        }            
	    }
	
	 private void initializeMovesList()
	 {
		    vertical = new ArrayList<Integer>();
			horizontal = new ArrayList<Integer>();
			horizontal.add(1);
			horizontal.add(2);
			horizontal.add(2);
			horizontal.add(1);
			horizontal.add(-1);
			horizontal.add(-2);
			horizontal.add(-2);
			horizontal.add(-1);
			vertical.add(-2);
			vertical.add(-1);
			vertical.add(1);
			vertical.add(2);
			vertical.add(2);
			vertical.add(1);
			vertical.add(-1);
			vertical.add(-2);
	
	 }
	
	
	 private ArrayList<Integer> inBoundsList(int row, int col)
		{
			
			ArrayList<Integer> inBounds =  new ArrayList<Integer>();
			//loop terminates when it has checked all possible moves given by the two arraylists (vertical and horizontal)
			for(int count = 0 ; count < 8 ; count++)
			{
		
				//checks if inbounds between 0 and matrix length
				int newRow = horizontal.get(count) + row;
				int newCol = vertical.get(count) + col;
				if(   (newRow > 0) &&(newRow < myMatrix.length)
						&& ( newCol > 0)
						&& ( newCol < myMatrix[newRow].length  ))
				{
					
					//if square has NOT been visited
					if(myMatrix[newRow][newCol] == 0)
					{
						//adds all in-bound, non-visited choices to arraylist
						inBounds.add(count);
					}
				}
				
			}
			return inBounds;
		}
		
		private void reduceAccess(int row, int col)
		{
			for(int i = 0; i < 8; i++)
			{
			
				int newRow = horizontal.get(i) + row;
				int newCol = vertical.get(i) + col;
				if(   (newRow > 0) &&(newRow < myMatrix.length)
						&& ( newCol > 0)
						&& ( newCol < myMatrix[newRow].length  ))
				{
					myAccess[newRow][newCol] = myAccess[newRow][newCol] - 1;
				}
			
			}
			
		}
	
		public void move()
		{
			int row = 1;
			int col = 1;
			visited++;
			myMatrix[row][col] = visited;
			reduceAccess(row, col);
			
			//if list has values inside of it
			while(inBoundsList(row, col).size() > 0)
				{
				   
					 int winRow = 0;
			    	 int winCol = 0;
		    		int min  = Integer.MAX_VALUE; 
				    for(int i = 0; i < inBoundsList(row,col).size(); i++)
				    {
				    	int move = inBoundsList(row, col).get(i);				    	
				    	
						int potentialRow = row + horizontal.get(move);
						int potentialCol = col + vertical.get(move);
						
						if(myAccess[potentialRow][potentialCol] < min)
						{
							min = myAccess[potentialRow][potentialCol];
							winRow =potentialRow;
							winCol = potentialCol;
						}
				    	
				    }
				    row = winRow;
				    col = winCol;
				
					visited++;
					myMatrix[row][col] = visited;
					
					reduceAccess(row, col);
					
				}
			}
	
		
		
			
	
	public void result()
	{
		System.out.print(" ");
        for(int i = 1; i < 9; i++)
        {
           System.out.printf("%2s", " ");
           System.out.print(" " + i);
        }
        System.out.println();
        System.out.println();
        for(int i = 1; i < 9; i++)
        {
        	 System.out.print(i);
        	 
        	 for(int j = 1; j < 9; j++)
        	 {
        		 if(myMatrix[i][j] < 10)
        		 {
        			 System.out.printf("%2s", " ");
        			 System.out.print(" " + myMatrix[i][j]);
        		 }
        		 else
        		 {
        			 System.out.printf("%2s", " ");
        			 System.out.print(myMatrix[i][j]); 
        		 }
            	
        	 }
        	 System.out.println();
        }
        System.out.println();
        System.out.println(visited + " squares were visited.");
        
        //prints access
        System.out.println();
        System.out.println("access matrix");
        System.out.println();
        System.out.println();
        
        System.out.printf("%3s", " ");
        for(int i = 1; i < 9; i++)
        {
       
           System.out.print(i + "  ");
        }
        System.out.println();
        System.out.println();
        for(int i = 1; i < 9; i++)
        {
        	 System.out.print(i);
        	 
        	 for(int j = 1; j < 9; j++)
        	 {
        		 System.out.printf("%2s", " ");
        		 System.out.print(myAccess[i][j]);
        	 }
        	 System.out.println();
        }
        
        
		
	}
}
