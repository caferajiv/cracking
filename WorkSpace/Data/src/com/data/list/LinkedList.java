package com.data.list;

import com.data.node.Node;

public class LinkedList {

	private Node Head;
	private int count;


	public LinkedList(){

	}
	
	public Node getHead(){
		
		return  Head;
	}
	
	public void setHead(Node head){
		Head = head;
	}
	public LinkedList(Node node){
		Head=node;
		Head.setNextNode(null);
		count=1;
	}

	public boolean isEmpty(){
		if(Head!=null){
			return false;
		}
		return true;
	}

	public void addFirst(int data){
		Node node=new Node(data);
		if(isEmpty()){
			Head=node;
			Head.setNextNode(null);
			count = 1;

		}else{
			node.setNextNode(Head);
			Head=node;
			count++;
		}
	}

	public void addLast(int data){
		Node node=new Node(data);
		if(isEmpty()){
			Head=node;
			Head.setNextNode(null);
			count = 1;
		}else{
			Node tempNode=new Node();
			tempNode=Head;
			while(tempNode.getNextNode()!=null){
				tempNode=tempNode.getNextNode();
			}
			tempNode.setNextNode(node);
			count++;
		}
	}

	public void insertAtLoc(int data, int loc){
		if(loc<0){
			System.out.println("Location cannot be negative!!");
		}else{
			if(loc>count){
				System.out.println("Cannot insert at location "+loc);
			}else{
				if(loc==0){
					addFirst(data);
				}else if(loc==count){
					addLast(data);
				}else{
					Node tempNode = new Node();
					tempNode=Head;
					int tempCount=0;
					while(tempNode.getNextNode()!=null && tempCount!=loc-1){
						tempNode=tempNode.getNextNode();
						tempCount++;
					}
					
					Node node=new Node(data);
					node.setNextNode(tempNode.getNextNode());
					tempNode.setNextNode(node);
				}

			}

		}

	}
	
	public int removeFirst(){
		if(isEmpty()){
			System.out.println("List is empty!!");
			return 0;
		}else{
			Node delNode= new Node();
			delNode=Head;
			Head=Head.getNextNode();
			int removedData=delNode.getData();
			delNode=null;
			count--;
			return removedData;
		}
		
	}
	
	public int removeLast(){
		if(isEmpty()){
			System.out.println("List is empty!!");
			return 0;
		}else{
			Node delNode= new Node();
			Node prevNode= new Node();
			delNode=Head;
			prevNode=delNode;
			while(delNode.getNextNode()!=null){
				prevNode=delNode;
				delNode=delNode.getNextNode();
			}
			int removedData=delNode.getData();
			prevNode.setNextNode(null);
			delNode=null;
			count--;
			return removedData;
		}
	}
	
	public int remove(int data){
		if(isEmpty()){
			System.out.println("List is empty!!");
			return 0;
		}else{
			Node delNode= new Node();
			Node prevNode= new Node();
			delNode=Head;
			prevNode=delNode;
			while(delNode.getNextNode()!=null && delNode.getData()!=data){
				prevNode=delNode;
				delNode=delNode.getNextNode();
			}
			if(delNode.getData()==data){
			prevNode.setNextNode(delNode.getNextNode());
			int removedData=delNode.getData();
			delNode=null;
			count--;
			return removedData;
			}else{
				System.out.println("Data Not Found");
				return 0;
			}
		}
	}
	
	public int search(int data){
		int index=0;
		
		if(isEmpty()){
			System.out.println("List is empty!!");
		}else{
			Node searchNode= new Node();
			searchNode=Head;
			while(searchNode.getNextNode()!=null && searchNode.getData()!=data){
				searchNode=searchNode.getNextNode();
				index++;
			}
			if(searchNode.getData()!=data){
				System.out.println("Data Not Found in List");
			}else{
				System.out.println("Data Found in List at: " + index);
			}
		}
		
		return index;
	}
	
	public void reverse(){
		
		if(isEmpty()){
			System.out.println("List is empty!!");
		}else{
			Node tempNode=null;
			Node revNode= null;
			Node saveNode= null;
			tempNode=Head;
			revNode=tempNode;
			
			
			while(tempNode.getNextNode()!=null){  //working logic 
				tempNode=tempNode.getNextNode();
				revNode.setNextNode(saveNode);
				saveNode=revNode;
				revNode=tempNode;
			}
			revNode.setNextNode(saveNode);
			
			
			Head=revNode;
			tempNode=null;
			saveNode=null;
			revNode=null;
		}
		
	}
	
	public void showLinkedList(){
		if(isEmpty()){
			System.out.println("LinkedList is Empty");
		}else{
			Node node= new Node();
			node=Head;
			while(node.getNextNode()!=null){
				System.out.print(node.getData());
				node=node.getNextNode();
			}
			System.out.println(node.getData());
		}
	}
	
	public void sort(){
		
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.showLinkedList();
		list.reverse();
		list.showLinkedList();
	}
}
