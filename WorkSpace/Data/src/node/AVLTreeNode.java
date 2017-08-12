package node;

public class AVLTreeNode {

	private int height;
	private AVLTreeNode leftChild;
	private AVLTreeNode rightChild;
	private int data;
	
	public AVLTreeNode(){}
	
	public AVLTreeNode(int data)
	{
		this.data=data;
	}
	/**
	 * @return the leftChild
	 */
	public AVLTreeNode getLeftChild() {
		return leftChild;
	}

	/**
	 * @return the rightChild
	 */
	public AVLTreeNode getRightChild() {
		return rightChild;
	}


	
	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(AVLTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(AVLTreeNode rightChild) {
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


	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
