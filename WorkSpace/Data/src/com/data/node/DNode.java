package com.data.node;

public class DNode extends Node{
	
	private DNode nextDNode;
	private DNode prevDNode;
	private int data;
	private Object item ;
	
	public DNode(){
		
	}
	
	public DNode(int data){
		this.data=data;
		
	}
	public DNode(Object item){
		this.setItem(item);
		
	}

	public DNode getNextDNode() {
		return nextDNode;
	}

	public void setNextDNode(DNode nextDNode) {
		this.nextDNode = nextDNode;
	}

	public DNode getPrevDNode() {
		return prevDNode;
	}

	public void setPrevDNode(DNode prevDNode) {
		this.prevDNode = prevDNode;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the item
	 */
	public Object getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Object item) {
		this.item = item;
	}

}
