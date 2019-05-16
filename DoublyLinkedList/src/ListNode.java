public class ListNode
{
  private Object value;
  private ListNode next;
  private ListNode previous;
  
  // Constructor:
  public ListNode(Object initValue, ListNode initNext, ListNode initPrevious)
  {
  
    value = initValue;
    next = initNext;
    previous = initPrevious;
  }
  
  public ListNode(Object initValue)
  {
	  this(initValue, null, null);
  }
  
  public Object getValue(){
    return value;
  }
  
  public ListNode getNext(){  
    return next;
  }
  
  public ListNode getPrevious(){
    return previous;
  }
  
  public void setValue(Object theNewValue){
    value = theNewValue;
  }
  
  public void setNext(ListNode theNewNext){
    next = theNewNext;
  }
  
  public void setPrevious(ListNode theNewPrevious){
    previous = theNewPrevious;
  }
}
