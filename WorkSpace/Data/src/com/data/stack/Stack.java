package com.data.stack;

import com.data.node.Node;

public class Stack {
	
	private Node Top;
	private int count;
	
	public Stack(){
		
	}
	public Stack(Node node){
		Top=node;
		count=1;
	}
	public boolean isEmpty(){
		if(Top!=null){
			return false;
		}
		return true;
	}
	public void push(int data){
		Node node = new Node(data);
		if(isEmpty()){
			Top=node;
			count=1;
		}else{
			node.setNextNode(Top);
			Top=node;
			count++;
		}
	}
	public int pop(){
		int data=0;
		if(isEmpty()){
			System.out.println("Stack is empty!!");
		}else{
			 data = Top.getData();
			Top=Top.getNextNode();
			count--;
		}
		return data;
	}
	
	public void showStack(){
		if(isEmpty()){
			System.out.println("Stack is Empty!!");
		}else{
			Node node= new Node();
			node=Top;
			while(node.getNextNode()!=null){
				System.out.print(node.getData());
				node=node.getNextNode();
			}
			System.out.println(node.getData());
		}
	}

}
