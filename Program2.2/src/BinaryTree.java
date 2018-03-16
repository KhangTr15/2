/**
 * 
 * @author Khang Tran
 * This code is based off my own code that I used for my previous class in 240. It's an implementation of a binary search tree based on the Complex and ComplexNode classes
 * Also I used this https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java to implement some methods that were not easily able to be figured out, such as the toString class.
 */
public class BinaryTree  {
	private ComplexNode root;
	
	public BinaryTree(){
		root = null;
	}
/**
 * recursive method that adds a new node to the BST 
 * @param cp - Complex object that will be added to the BST
 */
	public void add (Complex cp) {
		if (root == null)
			root = new ComplexNode(cp,null,null);
		else
			add(cp,root);
	}
	/**
	 * This method compares whether the Complex object is less than the ComplexNode's complex value, if it is it moves to the left, if it isn't it moves to the right
	 * @param cp - complex object to be passed into the method
	 * @param cn - ComplexNode object that will be passed into the method
	 */
	protected void add (Complex cp, ComplexNode cn) {
		if( cp.compareTo(cn.getData()) <= 0){
			if(cn.getLeft() == null)
				cn.setLeft(new ComplexNode(cp,null,null));
			else
				add(cp, cn.getLeft());
		}
		else
			if (cn.getRight() == null)
				cn.setRight(new ComplexNode(cp,null,null));
			else{
				add(cp,cn.getRight());
			}
	}
/**
 * Method that will determine the numberofNodes in the BST
 * @return integer number of nodes in BST
 */
	public int numberOfNodes() {
		ComplexNode cur = root;
		if (cur == null)
			return 0;
		else
			return numberOfNodes(cur);
	}
	/**
	 * Same as above
	 */
	private int numberOfNodes(ComplexNode cn){
		if (cn == null)
			return 0;
		else
			return 1 + (numberOfNodes(cn.getLeft()) + numberOfNodes(cn.getRight()));
	}

/**
 * recursive method that will determine how deep the node passed in the parameter is
 * @param cn - the complexNode object that will be used to determine how deep the tree is
 * @return integer number that represents the depth of the ComplexNode
 */
	private int depth(ComplexNode cn){
		if (cn == null)
			return -1;
		return 1 + Math.max(depth(cn.getLeft()),depth(cn.getRight()));
	}
	public int depth(){
		return depth(root);
	}
	/**
	 * toString method that converts all the complexNode values into String values and then returns all of them from least to greatest
	 * @param root - ComplexNode object that is used to start the method
	 * @return String form of all ComplexNodes
	 */
	public String toString(ComplexNode root){
		StringBuilder builder = new StringBuilder();
		if (root == null)
			return "";
		builder.append(toString(root.left));
		builder.append(toString(root.right));
		return builder.append(root.data.toString()).toString();
	}

// This method I borrowed from https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
	/**
	 * This method calls upon retrieveData and the other delete to remove a node from the BST
	 * @param cp - Complex object that will be the start to the delte method
	 */
    public void delete(Complex cp)
    {
    	root = delete(root,cp);
    }
    /**
     * The recursive method that calls upon the other delete and retrieve data to remove a node from the BST. it does this by comparing the ComplexNode's complex value with the Complex argument passed in. If 
     * @param cn ComplexNode object 
     * @param cp Complex object
     * @return The deleted ComplexNode
     */
    public ComplexNode delete(ComplexNode cn, Complex cp)
    {
    	if (cn == null) throw new RuntimeException("cannot delete");
    	if (cp.compareTo(cn.getData()) < 0){
    		cn.left = delete(cn.left,cp);
    	}
    	else if (cp.compareTo(cn.getData()) > 0){
    		cn.right = delete(cn.right,cp);
    	}
    	else{
    		if(cn.left == null)
    			return cn.right;
    		else if (cn.right == null)
    			return cn.left;
    		else{
    			cn.data = retrieveData(cn.left);
    			cn.left = delete(cn.left,cn.data);
    		}
    	}
    	return cn;
    }
    /**
     * Method used in delete methods
     * @param cn ComplexNode object
     * @return Complex object
     */
    private Complex retrieveData(ComplexNode cn){
    	while (cn.right != null){
    		cn = cn.right;
    	}
    	return cn.data;
    }
 /**
  * Method that will use the other search method to return the ComplexNode that was searched
  * @param cp - Complex object
  * @return Complex object
  */
	public Complex search(Complex cp){
		ComplexNode temp = search(root,cp);
		if (temp == null){
			return null;
		}
		else{
			return temp.getData();
		}
	}
	/**
	 * Other part of search method that compares whether two objects are equal, less than or greater than each other and then traverses the side of the list with the intended value to find the correct Node value
	 * @return ComplexNode object
	 */
	protected ComplexNode search(ComplexNode cn, Complex cp){
		if (cn == null){
			return null;
		}
		else{
			if (cp.compareTo(cn.getData()) == 0) {
				return cn;
			}
			else if (cp.compareTo(cn.getData()) < 0){
				return search(cn.getLeft(),cp);
			}
			else{
				return search(cn.getRight(),cp);
			}
		}
	}
	public static void main(String[] args) {
		Complex c1 = new Complex(50,40);
		Complex c2 = new Complex(8,10);
		Complex c3 = new Complex(5,15);
		BinaryTree bst = new BinaryTree();
		bst.add(c2);
		bst.add(c1);
		bst.add(c3);
		//bst.preOrder();
		//System.out.println(bst.search(c3));
		bst.delete(c2);
		
	}


}

