package com.data.node;

public class Node {

	private Node nextNode;
	private int data;
	
	public Node(){
		
	}
	
	public Node(int data){
		this.data=data;
		
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	
	
}
