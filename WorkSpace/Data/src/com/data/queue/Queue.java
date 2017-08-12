package com.data.queue;

import com.data.node.Node;
import com.data.node.TNode;

public class Queue {
	
	private Node Front;
	private Node Rear;
	private int count;
	
	public Queue(){
		
	}
	public Queue(Node node){
		Front = node;
		Rear = node;
		count = 1;
	}
	public boolean isEmpty(){
		if(Rear!=null && Front!=null){
			return false;
		}
		return true;
	}
	
	public void enqueue(int data){
		Node node = new Node(data);
		if(isEmpty()){
			Front=node;
			Rear=node;
			count=1;
		}else{
			Rear.setNextNode(node);
			Rear=node;
			count++;
		}
	}
	
	public void enqueue(Node node){
		if(isEmpty()){
			Front=node;
			Rear=node;
			count=1;
		}else{
			Rear.setNextNode(node);
			Rear=node;
			count++;
		}
	}
	
	public Object dequeue(){
		int data=0;
		if(isEmpty()){
			System.out.println("Queue is Empty!!");
		}else{
			data=Front.getData();
			if(Front!=Rear){
				Front=Front.getNextNode();
			}else{
				Front=Rear=null;
			}
			count--;
		}
		return data;
	}
	
	public Node dequeueNode(){
		Node node= new Node();
		if(isEmpty()){
			System.out.println("Queue is Empty!!");
		}else{
			node=Front;
			if(Front!=Rear){
				Front=Front.getNextNode();
			}else{
				Front=Rear=null;
			}
			count--;
		}
		return node;
	}
	
	
	public void showQueue(){
		if(isEmpty()){
			System.out.println("Queue is Empty!!");
		}else{
			Node node= new Node();
			node=Front;
			while(node.getNextNode()!=null){
				System.out.print(node.getData());
				node=node.getNextNode();
			}
			System.out.println(node.getData());
		}
	}

}
