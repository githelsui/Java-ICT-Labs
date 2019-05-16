import java.util.*;
import java.io.*;

public class Life
{
    // specs say matrix to be 20 x 20.  If you'd like, you can make it 22 x 22 
    // and ignore row/col 0 and 21.  This will allow you to not have to test the 
    // condition of going out of bounds when you're counting neighbors.
    // You can make the matrix to store ints or Strings    
    private String[][] myMatrix;
    
    // initialize matrix (fill with " " if make String matrix)
    // call loadFile
    public Life(String fileName)
    {
        myMatrix = new String[22][22];
        
        for(int i = 0; i < myMatrix.length ; i++)
        {
            for(int j = 0; j < myMatrix[i].length ; j++)
            {
                myMatrix[i][j] = " ";
            }
        }
        
        loadFile(fileName);
    }
    
    // loads file and updates matrix so that matrix[r][c] is alive if (r,c) 
    // is present in file
    private void loadFile(String fileName)
    {
        try
        {
            Scanner file = new Scanner(new File(fileName));
          
            while (file.hasNextInt())
            {
                int row = file.nextInt();
                int col = file.nextInt();
                myMatrix[row][col] = "*"; // = 1 if int matrix
            }
            
        }
        catch (IOException error)
        {
            System.out.println (error.getMessage());
        }            
    }
    
    // updates the matrix based on the number of neighbors around each cell.
    // make a copy matrix
    // count nbrs around each cell in copy (separate method)
    // 0,1, or 4+ nbrs --> death to myMatrix[r][c]
    // 3 nbrs --> life to myMatrix[r][c]   
    public void nextGeneration()
    {
        String[][] copy = new String[22][22];
        for(int i = 0; i < myMatrix.length; i++)
        {
            for(int j = 0; j < myMatrix[i].length; j++)
            {
                copy[i][j] = myMatrix[i][j];
            }
        }
        
         //killing off proccceeesssssss
         for(int i = 1; i < myMatrix.length - 1; i++)
        {
            for(int j = 1; j < myMatrix[i].length - 1; j++)
            {
                int neighbors = countNeighbors(myMatrix,i,j);
                if(myMatrix[i][j].equals("*"))
                {
                    if(neighbors <= 1 || neighbors >= 4)
                    {
                        copy[i][j] = " ";
                    }
                }
                else
                {
                    if(neighbors  == 3)
                    {
                        copy[i][j] = "*";
                    }
                }
            }
        }
        
        for(int i = 0; i < myMatrix.length ; i++)
        {
            for(int j = 0; j < myMatrix[i].length; j++)
            {
                myMatrix[i][j] = copy[i][j];
            }
        }
        
    }
                                                  //2       2         
    // counts and returns number of living organisms around max[r][c]   
    private int countNeighbors(String[][] max, int row, int col)
    {
        int neighbors = 0;
        for(int i = row - 1; i <= row + 1; i++)
        {
            for(int j = col - 1; j <= col + 1; j++)
                {
                        if(i != row || j != col) //if max is not at max[row][col]
                        {
                            if(max[i][j].equals("*"))
                            {
                               neighbors++;
                            }   
                        }
                }
        }
        return neighbors;
    }
    
    // counts and returns total # of living organisms in myMatrix
    public int countLiving()
    {
        int living = 0;
         for(int i = 1; i < 21; i++)
         {
            for(int j = 1; j < 21; j++)
            {
                if(myMatrix[i][j].equals("*"))
                    living++;
            }
         } 
        return living;
    }
    
    // counts and returns # of living organisms in row
    public int countRow(int row)
    {
       int living = 0;
        for(int i = 1; i < myMatrix[row].length-1; i++ )
        {
            if(myMatrix[row][i].equals("*"))
                living++;
        }
        return living;
    }        
    
     // counts and returns # of living organisms in col
    public int countCol(int col)
    {
        int living = 0;
        for(int i = 1; i < myMatrix.length-1; i++ )
        {
            if(myMatrix[i][col].equals("*"))
            {
                living++;
            }
        }
        return living;
    }
    
    // displays contents of myMatrix ( "*" if alive, " " if dead)
    // include row # and col # (make a table)
    public void output()
    {
        int horiz = 1;
        System.out.printf("%10s", " ");
            for(int i = 0; i < 20; i++)
            {
                System.out.print(horiz);
                horiz++;
                if( horiz > 9 )
                {
                    horiz = 0;
                }
        }
        System.out.println();
        System.out.println();
        for(int j = 1; j <  myMatrix.length - 1; j++)
        {
            System.out.print(j);
            System.out.printf("%9s", " ");
            for(int k = 1; k < myMatrix[j].length - 1; k++)
            {
                if(myMatrix[j][k].equals("*"))
                {
                    System.out.print("*");
                 }
               else
               {
                    System.out.print(" ");
                }
            }
          System.out.println();
        }
}

public void result()
{
    System.out.println();
    System.out.println("Number in Row 10 ---> " + countRow(10));
    System.out.println();
    System.out.println("Number in Column 10 ---> " + countCol(10));
    System.out.println();
    System.out.println("Number of living organisms ---> " + countLiving());
    System.out.println();
}

}
