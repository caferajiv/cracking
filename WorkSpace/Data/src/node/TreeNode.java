package node;

public class TreeNode {
	
	private TreeNode leftChild;
	private TreeNode rightChild;
	private int data;
	
	public TreeNode(){}
	
	public TreeNode(int data)
	{
		this.data=data;
	}
	/**
	 * @return the leftChild
	 */
	public TreeNode getLeftChild() {
		return leftChild;
	}
	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	/**
	 * @return the rightChild
	 */
	public TreeNode getRightChild() {
		return rightChild;
	}
	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		
		return String.valueOf(data);
	}
	
	

}
