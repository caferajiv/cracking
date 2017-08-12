package com.data.list;

import com.data.node.DNode;
import com.data.node.Node;

public class DoubleLinkedList {
	
	private DNode Head;
	private int count;


	public DoubleLinkedList(){

	}
	
	public DNode getHead(){
		return Head;
	}
	public DNode setHead( DNode dnode){
		return Head = dnode;
	}
	public DoubleLinkedList(DNode dNode){
		Head=dNode;
		Head.setNextDNode(null);
		Head.setPrevDNode(null);
		count=1;
	}

	public boolean isEmpty(){
		if(Head!=null){
			return false;
		}
		return true;
	}
	
	public void addFirst(int data){
		DNode dNode=new DNode(data);
		if(isEmpty()){
			Head=dNode;
			Head.setNextDNode(null);
			Head.setPrevDNode(null);
			count = 1;

		}else{
			dNode.setNextDNode(Head);
			dNode.setPrevDNode(null);
			Head=dNode;
			count++;
		}
	}

	public void addLast(int data){
		DNode dNode=new DNode(data);
		if(isEmpty()){
			Head=dNode;
			Head.setNextDNode(null);
			Head.setPrevDNode(null);
			count = 1;
		}else{
			DNode tempDNode=new DNode();
			tempDNode=Head;
			while(tempDNode.getNextDNode()!=null){
				tempDNode=tempDNode.getNextDNode();
			}
			tempDNode.setNextDNode(dNode);
			dNode.setPrevDNode(tempDNode);
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
					DNode tempDNode = new DNode();
					tempDNode=Head;
					int tempCount=0;
					while(tempDNode.getNextDNode()!=null && tempCount!=loc-1){
						tempDNode=tempDNode.getNextDNode();
						tempCount++;
					}
					
					DNode dNode=new DNode(data);
					dNode.setNextDNode(tempDNode.getNextDNode());
					dNode.setPrevDNode(tempDNode);
					tempDNode.setNextDNode(dNode);
					dNode.getNextDNode().setPrevDNode(dNode);
				}

			}

		}

	}
	
	public int removeFirst(){
		if(isEmpty()){
			System.out.println("List is empty!!");
			return 0;
		}else{
			DNode delDNode= new DNode();
			delDNode=Head;
			Head=Head.getNextDNode();
			Head.setPrevDNode(null);
			int removedData=delDNode.getData();
			delDNode=null;
			count--;
			return removedData;
		}
		
	}
	
	public int removeLast(){
		if(isEmpty()){
			System.out.println("List is empty!!");
			return 0;
		}else{
			DNode delDNode= new DNode();
			delDNode=Head;
			while(delDNode.getNextDNode()!=null){
				delDNode=delDNode.getNextDNode();
			}
			int removedData=delDNode.getData();
			delDNode.getPrevDNode().setNextDNode(null);
			delDNode=null;
			count--;
			return removedData;
		}
	}
	
	public int remove(int data){
		if(isEmpty()){
			System.out.println("List is empty!!");
			return 0;
		}else{
			DNode delDNode= new DNode();
			delDNode=Head;
			while(delDNode.getNextDNode()!=null && delDNode.getData()!=data){
				delDNode=delDNode.getNextDNode();
			}
			if(delDNode.getData()==data){
				
			delDNode.getPrevDNode().setNextDNode(delDNode.getNextDNode());
			delDNode.getNextDNode().setPrevDNode(delDNode.getPrevDNode());
			int removedData=delDNode.getData();
			delDNode=null;
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
			DNode searchDNode= new DNode();
			searchDNode=Head;
			while(searchDNode.getNextDNode()!=null && searchDNode.getData()!=data){
				searchDNode=searchDNode.getNextDNode();
				index++;
			}
			if(searchDNode.getData()!=data){
				System.out.println("Data Not Found in List");
			}else{
				System.out.println("Data Found in List at: " + index);
			}
		}
		return index;
	}
	
	public void showDoubleLinkedList(){
		if(isEmpty()){
			System.out.println("DoubleLinkedList is Empty");
		}else{
			DNode dNode= new DNode();
			dNode=Head;
			while(dNode.getNextDNode()!=null){
				System.out.print(dNode.getData());
				dNode=dNode.getNextDNode();
			}
			System.out.println(dNode.getData());
		}
	}
	
	
	public void sort(){
		
	}

}
