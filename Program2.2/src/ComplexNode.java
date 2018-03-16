/**
 * @author Khang Tran 2-23-2016
 * This is my ComplexNode class that keeps track of all Complex objects in one node and it's left and right references. It has methods that allows the node class to get it's left and right sub values and toString and isLeaf methods
 *
 */
public class ComplexNode {
	protected Complex data;
	protected ComplexNode left;
	protected ComplexNode right;
	
	public ComplexNode(Complex initialData, ComplexNode l, ComplexNode r){
		data = initialData;
		l = left;
		r = right;
	}
	/**
	 * This method gets the Complex data
	 * @return Complex number
	 */
	public Complex getData(){
		return data;
	}
	/**
	 * This method sets the data of the object to the one passed into the parameter
	 * @param newData - the new complex number to be inserted in the ComplexNode
	 */
	public void setData(Complex newData){
		data = newData;
	}
	/**
	 * This method returns the left reference of the root node or starting node
	 * @return ComplexNode of the node this method was passed on
	 */
	public ComplexNode getLeft(){
		return left;
		
	}
	/**
	 * This method sets the left reference of the starting node to the newLeft value
	 * @param newLeft - the new ComplexNode's value that will be inserted to the left reference of the root node
	 */
	public void setLeft(ComplexNode newLeft){
		left = newLeft;
		
	}
	/**
	 * This method returns the right reference of the root node or starting node
	 * @return ComplexNode of the node this method was passed on
	 */
	public ComplexNode getRight(){
		return right;
	}
	/**
	 * This method sets the right reference of the starting node to the newRight value
	 * @param newRight - the new ComplexNode's value that will be inserted to the right reference of the root node
	 */
	public void setRight(ComplexNode newRight){
		right = newRight;
	}
	/**
	 * determines whether the root/node is a leaf or not
	 * @return boolean
	 */
	public boolean isLeaf(){
		return (left == null) || (right == null); 
	}
	/**
	 * method that will return all Complex objects into string format
	 */
	public String toString(){
		return data.toString();
	}

}
