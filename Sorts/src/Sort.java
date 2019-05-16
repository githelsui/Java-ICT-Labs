import java.util.*;

public class Sort
{
    private long mySteps;   // disregard this for now
    
    public Sort()
    {
        mySteps = 0;    // disregard this for now
    }

    
    public void bubbleSort(ArrayList <Comparable> list)
    {
           for (int outer = 0; outer < list.size() - 1; outer++)
           {
               for (int inner = 0; inner < list.size()-outer-1; inner++)
            {
                if (list.get(inner).compareTo(list.get(inner + 1)) > 0)
                {      
                  Comparable temp = list.get(inner);
                  list.set(inner, list.get(inner + 1));
                  list.set(inner + 1, temp);
                }
            }
        }
    }

    public void selectionSort(ArrayList <Comparable> list)
    {
        int min;
        Comparable temp;
      
        for (int outer = 0; outer < list.size() - 1; outer++)
        {
           min = outer;
           for (int inner = outer + 1; inner < list.size(); inner++)
           {
              if (list.get(inner).compareTo(list.get(min)) < 0)
                min = inner;        
           }
           temp = list.get(outer);
           list.set(outer, list.get(min));
           list.set(min, temp);
       }
    }

    public void insertionSort(ArrayList <Comparable> list)
    {
           for (int outer = 1; outer < list.size(); outer++)
          {
            int position = outer;
            Comparable key = list.get(position);    
            while (position > 0 && list.get(position - 1).compareTo(key) > 0)
            {
              list.set(position, list.get(position - 1));
              position--;
            }
            list.set(position,  key);
          }
        }


    //  Recursively divides a list in half, over and over. When the
    //  sublist has one or two values, stop subdividing.
    public void mergeSort(ArrayList <Comparable> a, int first, int last)
    {
        if(first == last)
        {
            
        }
        else if(last - first == 1)
        {
            if(a.get(first).compareTo(a.get(last)) > 0)
            {
                Comparable num = a.get(first);
                a.set(first, a.get(last));
                a.set(last, num);
            }
        }
        else
        {
            int mid = (first+last) / 2;
            mergeSort(a, first, mid);
            mergeSort(a, mid+1, last);
            merge(a, first, mid, last);
        }
    }

    // creates a copy of ArrayList list called temp, and uses temp’s values to properly merge(sort) list
    // from first to last 
    public void merge(ArrayList<Comparable> list, int first, int mid, int last)
    {
        int index1 = first; int index2 = mid + 1;
        List<Comparable> merged = new ArrayList<Comparable>();
        for(int i = first; i <= last; i++)
        {
            if (index1 > mid)
            {
                merged.add(list.get(index2));
                index2++;
            }
            else if(index2 > last)
            {
                merged.add(list.get(index1));
                index1++;
            }
            else if(list.get(index1).compareTo(list.get(index2)) < 0)
            {
                merged.add(list.get(index1));
                index1++;
            }
            else
            {
                merged.add(list.get(index2));
                index2++;
            }
        }
        int indexArr = 0;
        for(int j = first; j <= last; j++)
        {
            list.set(j,merged.get(indexArr));
            indexArr++;
        }
        
    }

    public void quickSort (ArrayList <Comparable> list, int first, int last)
    {
    	  	int g = first, h = last;

    	  	int midIndex = (first + last) / 2;
    	  	Comparable dividingValue = list.get(midIndex);
    	  	do{
    	   		while (list.get(g).compareTo(dividingValue) < 0) g++;
    	    	while (list.get(h).compareTo(dividingValue) > 0) h--;
    	    	if (g <= h){
    	      		//swap(list[g], list[h]);
    	      		//swap(list,g,h);
    	    			Comparable num = list.get(g);
    	    		  list.set(g, list.get(h));
    	              list.set(h, num);
    	      		g++;
    	      		h--;
    	    	}
    	  	}while (g < h);
    	  	if (h > first) quickSort (list,first,h);
    	  	if (g < last) quickSort (list,g,last);
    }
    


    

    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount()
    {
        return mySteps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(long stepCount)
    {
        mySteps = stepCount;
    }   
}