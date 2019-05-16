import java.util.ArrayList;

public class KnightsTour 
{
	private int[][] myMatrix;
	private ArrayList<Integer> horizontal;
	private ArrayList<Integer> vertical;
	private int visited;
	
	public KnightsTour()
	{
		myMatrix = new int[9][9];
		
		
		visited = 0;
		
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
		int count;
		
		ArrayList<Integer> inBounds =  new ArrayList<Integer>();
		//loop terminates when it has checked all possible moves given by the two arraylists (vertical and horizontal)
		for(count = 0 ; count < 8 ; count++)
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
	
	
	public void move()
	{
		int row = 1;
		int col = 1;
		visited++;
		myMatrix[row][col] = visited;
		
		//if list has values inside of it
		while(inBoundsList(row, col).size() > 0)
			{
				//random holds int value of an inBounds move in the arraylist
				int choice = (int)(Math.random() * inBoundsList(row, col).size());
				int tempCol = col;
											//choice that IS IN-BOUNDS AND NOT VISITED
				col = col + vertical.get(inBoundsList(row,col).get(choice));
				row = row + horizontal.get(inBoundsList(row, tempCol).get(choice));
				visited++;
				myMatrix[row][col] = visited;
				
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
		
	}
}
