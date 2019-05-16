import java.util.LinkedList;

public class Driver 
{
	 public static void main(String[] MEMES)
	    { 
		 LinkedList<Item> items = new LinkedList<Item>();
		 MergeList merge = new MergeList("file20.txt");
		 merge.readData(items);
		 System.out.println("Initial");
		 merge.printList(items);
		 System.out.println("Sorted");
		 items = merge.mergeSort(items);
		 merge.printList(items);
		System.out.println("Reverse");
		merge.printList(merge.reverseList(items));
		 
	    }
}
