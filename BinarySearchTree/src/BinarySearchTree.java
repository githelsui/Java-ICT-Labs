import java.util.*;

/**
 *  Implements a Binary Search Tree
 *
 * @author     G. Peck
 * @created    July 2, 2003
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006
 */

public class BinarySearchTree
{
  // create private TreeNode called myRoot

	private TreeNode myRoot;
	
  public BinarySearchTree()
  {
    myRoot = null;
  }

  public void insert(Comparable next)
  {
	  myRoot = insertHelper(myRoot,  next);
  }

  private TreeNode insertHelper(TreeNode root, Comparable next)
  {
	  TreeNode inserted = new TreeNode(next);
	 
	  if(root == null)
	  {
		  return inserted;
	  }
	  else if(next.compareTo(root.getValue()) < 0)
	  {
		  
			 root.setLeft(insertHelper(root.getLeft(), next));
			 return root;
	  }
	  else
	  {
		  		  root.setRight(insertHelper(root.getRight(), next));
				return root;
		  
	  }
  }

  public Object find(Comparable target)
  {
    return findHelper(myRoot, target);
  }

  private Object findHelper(TreeNode root, Comparable target)
  {		
	  

	  if (root == null) 
	  {
	    return null;
	  }
	  else if (target.equals(root.getValue()))
	  {
		 //ystem.out.println(root.getValue());
	     return root.getValue();
	  }
	  else if (target.compareTo(root.getValue()) < 0)
	  {
		return findHelper(root.getLeft(), target);
	  }
	  else
	  { 
		  return findHelper(root.getRight(), target);
	  }
  }

  public int countNodes()
  {
	 return countNodesHelper(myRoot);
  }

  private int countNodesHelper(TreeNode root)
  {
	  
	  if (root != null)
	  {	
		  return  1 + countNodesHelper(root.getLeft()) +  countNodesHelper(root.getRight());
	  }
	return 0;
  }	
  
  public int countLeaves()
  {
	 return countLeavesHelper(myRoot);
  }

  private int countLeavesHelper(TreeNode root)
  {
	  
	  if (root != null)
	  {	
		  TreeNode rightChild = root.getRight();
		  TreeNode leftChild = root.getLeft();
		  if(rightChild == null && leftChild == null)
			  return 1;
		  else
			return  countLeavesHelper(rightChild) +  countLeavesHelper(leftChild);
		  }
	return 0;
  }

  public void print()
  {
	  printInorder(myRoot);
  }

  private void printInorder(TreeNode root)
  {

	  if (root != null)
	  {	
		    printInorder(root.getLeft());
		    System.out.println(root.getValue());
		    if (root.getLeft() != null) {
		    	System.out.println( "LEFT: " +root.getLeft().getValue());
				if (root.getRight() != null) System.out.println( "     RIGHT: " +root.getRight().getValue());
				else System.out.println( "     RIGHT: null");
			}
			else {
				System.out.println( "     LEFT: null");
				if (root.getLeft() != null) System.out.println( "     RIGHT: " +root.getRight().getValue());
				else System.out.println( "     RIGHT: null");
			}
		    System.out.println();
		    printInorder(root.getRight());
	  }

  }
  
  public void postOrder()
  {
	  printPostOrder(myRoot);
  }

  private void printPostOrder(TreeNode root)
  {

	  if (root != null)
	  {	
		    printPostOrder(root.getLeft());
		    printPostOrder(root.getRight());
		    System.out.println(root.getValue());
	  }  
  }
  
  public void preOrder()
  {
	  printPreOrder(myRoot);
  }

  private void printPreOrder(TreeNode root)
  {

	  if (root != null)
	  {	
		  System.out.println(root.getValue());
		  	printPreOrder(root.getLeft());
		  	 printPreOrder(root.getRight());
			
	  }  
  }

  public void delete(Comparable target)
  {   
	  myRoot = deleteHelper(myRoot, target);
  }

  private TreeNode deleteHelper(TreeNode node, Comparable target)
  {
		  if (node == null) 
		  {
		    throw new NoSuchElementException();
		  }
		  else if (target.equals(node.getValue()))
		  {
		     return deleteTargetNode(node);
		  }
		  else if (target.compareTo(node.getValue()) < 0)
		  {
			  
		    node.setLeft(deleteHelper(node.getLeft(), target));
		    return node;
		  }
		  else
		  {
		    node.setRight(deleteHelper(node.getRight(), target));
		    return node;
		  }

  }
//(left)smallest value in the right subtree
  private TreeNode deleteTargetNode(TreeNode target)
  {
		  if (target.getRight() == null)
		  {
		    return target.getLeft();
		  }
		  else if (target.getLeft() == null)
		  {
		    return target.getRight();
		  }
		  else if (target.getRight().getLeft() == null) 
		  {
		     target.setValue(target.getRight().getValue());
		     target.setRight(target.getRight().getRight());
		     return target;
		  }
		  else
		  { //left child has right child
		  
		     TreeNode marker = target.getRight();
		     while (marker.getLeft().getLeft() != null)
		     {
		       marker = marker.getLeft();
		     }
		     target.setValue(marker.getLeft().getValue());
		     marker.setLeft(marker.getLeft().getRight());
		     return target;
		  }
  }
  
  public void clearTree()
  {
	  myRoot = null;
  }
  
  public int height()
  {
	 return height(myRoot);
  }

  private int height(TreeNode root)
  {
	  if(root != null)
	  {
		  return 1 + max(height(root.getLeft()), height(root.getRight()));
	  }
	  return 0;
}
  

  public int width()
  {
	return width(myRoot);
  }

  private int width (TreeNode root)
  {
	  if(root != null)
	  {
		  return  max( width(root.getLeft()) + width(root.getRight())
		  ,height(root.getLeft()) + height(root.getRight()) );
	  }
	  return 0;
  }
  
private int max(int a, int b)
  {
   return Math.max(a, b);
  }

 public void interchange()
  // post: tree becomes a mirror image of itself
  {
    interchange(myRoot);
  }

  private void interchange(TreeNode root)
  {
    if(root != null)
    {
    	TreeNode right = root.getRight();
    	TreeNode left = root.getLeft();
    	root.setLeft(right);
    	root.setRight(left);
    	interchange(root.getLeft());
    	interchange(root.getRight());
    }
 
  }

  public boolean isAncestor(Comparable ancestor, Comparable descendant)
  {
	  if(myRoot != null)
	  {
	  return isAncestor(myRoot, ancestor, descendant);
	  }
	  else
	  {
		  return false;
	  }
  }

  public boolean isAncestor(TreeNode root, Comparable a, Comparable d)
  {
    if (findPtr(findPtr(root, a), d) != null)
      return true;
    else
      return false;
  }

  private TreeNode findPtr(TreeNode root, Comparable target)
  {
   TreeNode node = root;
   if(node != null)
   {
	   if( target.compareTo(node.getValue()) == 0)
	   {
		   return node;
	   }
	   else if(target.compareTo(node.getValue()) < 0)
	   {
		   return findPtr(node.getLeft(), target);
	   }
	   else
	   {
		   return findPtr(node.getRight(), target);
	   }
   }
   return null;
  }

  public void printLevel(int level)
  // post: prints the data fields of the tree, one per line
  {
   printLevel(myRoot, level);
  }

  private void printLevel(TreeNode root, int level)
  {
	  if(root != null && level == 0)
	  {
			System.out.print( root.getValue() + " ");
	  }
	  else if(root != null)
	  {	
		  	printLevel(root.getLeft(), level - 1);
		    printLevel(root.getRight(), level - 1);
		   
	  }
  }



}