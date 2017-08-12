package com.data.node;

public class TNode extends Node{
	
	private TNode leftChild;
	private TNode rightChild;
	private int data;
	
	public TNode(){
		
	}
	public TNode(int data){
		this.data=data;
	}
	public TNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(TNode leftChild) {
		this.leftChild = leftChild;
	}
	public TNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(TNode rightChild) {
		this.rightChild = rightChild;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	

}
