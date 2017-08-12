package com.data.tree;

import com.data.node.TNode;
import com.data.queue.Queue;

public class BinarySearchTree {
	
	private TNode root;
	private int count;
	
	public BinarySearchTree(){
		
	}
	
	public BinarySearchTree(TNode tNode){
		root=tNode;
		root.setLeftChild(null);
		root.setRightChild(null);
		count=1;
	}
	
	public boolean isEmpty(){ 
		if(root!=null){
			return false;
		}
		return true;
	}
	
	public void addChild(int data){
		if(isEmpty()){
			root=new TNode(data);
			count=1;
		}else{
			TNode tempNode=new TNode();
			tempNode=findTNode(root,data);
			tempNode.getData();
			if(tempNode!=null){
			if(data<tempNode.getData()){
				tempNode.setLeftChild(new TNode(data));
			}else{
				tempNode.setRightChild(new TNode(data));
			}
			}
		}
		
	}
	
	private TNode findTNode(TNode tnode, int data){
		TNode leafNode = null;
		if(tnode!=null){
			if(data<tnode.getData()){
				leafNode=findTNode(tnode.getLeftChild(), data);
				if(leafNode==null){
					leafNode=tnode;
				}
				
			}else if(data>tnode.getData()){
				leafNode=findTNode(tnode.getRightChild(), data);
				if(leafNode==null){
					leafNode=tnode;
				}
			}else{
				System.out.println("Data already present!!");
			}
		}
		
		return leafNode;
	}
	
	
	public int removeChild(int data){
	    int removedData=0; 
		if(isEmpty()){
			System.out.println("Tree us Empty!!");
		}else{
			TNode parentNode=searchChild(root, data);
			
			TNode deleteNode=null;
			if(parentNode!=null){
			if(data<parentNode.getData()){
				deleteNode=parentNode.getLeftChild();
				//parentNode.setLeftChild(null);
			}else{
				deleteNode=parentNode.getRightChild();
				//parentNode.setRightChild(null);
			}
			}else{
				deleteNode=root;
			}
			
			if(deleteNode!=null){
				if(isLeafNode(deleteNode)){
					removedData=deleteNode.getData();
					deleteNode=null;
					
				}else if(hasOnlyLeftChild(deleteNode)){
					removedData=deleteNode.getData();
					deleteNode=deleteNode.getLeftChild();
					
				}else if(hasOnlyRightChild(deleteNode)){
					removedData=deleteNode.getData();
					deleteNode=deleteNode.getRightChild();
					
				}else if(hasBothChilds(deleteNode)){
					removedData=deleteNode.getData();
					deleteNode=getRightMostLeafNodeInLeftChildTree(deleteNode);
				}
			}
			if(parentNode!=null){
			if(data<parentNode.getData()){
				//deleteNode=parentNode.getLeftChild();
				parentNode.setLeftChild(deleteNode);
			}else{
				//deleteNode=parentNode.getRightChild();
				parentNode.setRightChild(deleteNode);
			}
			}else{
				root=deleteNode;
			}
			
			
		}
		
		return removedData;
	}
	private TNode getRightMostLeafNodeInLeftChildTree(TNode tnode){
		TNode tempNode= new TNode();
		tempNode=tnode;
		TNode returnNode= new TNode();
		TNode parentNode=null;
		if(tempNode!=null){
			parentNode=tempNode;
			if(tempNode.getLeftChild()!=null){
			tempNode=tempNode.getLeftChild();
			
			while(tempNode.getRightChild()!=null){
				parentNode=tempNode;
				tempNode=tempNode.getRightChild();
			}
			
			if(isLeafNode(tempNode)){
				returnNode=tempNode;
				if(parentNode.getData()!=tnode.getData()){
					parentNode.setRightChild(null);
				}else{
					parentNode.setLeftChild(null);
				}
				
			}else{
				returnNode=tempNode;
				tempNode=tempNode.getLeftChild();
			}
		}
		returnNode.setLeftChild(tnode.getLeftChild());
		returnNode.setRightChild(tnode.getRightChild());
		}else if(tempNode.getRightChild()!=null){
			returnNode=tempNode.getRightChild();
		}
		return returnNode;
	}
	
	private boolean isLeafNode(TNode tnode){
		if(tnode!=null){
			if(tnode.getLeftChild()!=null || tnode.getRightChild()!=null){
				return false;
			}
			return true;
		}
		return false;
	}
	private boolean hasOnlyLeftChild(TNode tnode){
		
		if(tnode!=null){
			if(tnode.getLeftChild()!=null && tnode.getRightChild()==null){
				return true;
			}
			return false;
		}
		return false;
	}
	private boolean hasOnlyRightChild(TNode tnode){
		if(tnode!=null){
			if(tnode.getLeftChild()==null && tnode.getRightChild()!=null){
				return true;
			}
			return false;
		}
		return false;
	}
	private boolean hasBothChilds(TNode tnode){
		if(tnode!=null){
			if(tnode.getLeftChild()!=null && tnode.getRightChild()!=null){
				return true;
			}
			return false;
		}
		return false;
	}
	public  TNode searchChild(TNode tnode,int data){
		TNode parentNode=null;
		TNode tempNode = new TNode();
		tempNode=tnode;
		while(tempNode!=null && tempNode.getData()!=data){
			if(data < tempNode.getData()){
				parentNode=tempNode;
				tempNode=tempNode.getLeftChild();
		    }else if(data > tempNode.getData()){
		    	parentNode=tempNode;
		    	tempNode=tempNode.getRightChild();
		    }
		}
		
		return parentNode;
	}
	
	public void inOrderTraversal(){
		if(isEmpty()){
			System.out.println("Tree is Empty!!");
		}else{
			
			doInOrder(root);
			System.out.println();
		}
		
	}
	
	private void doInOrder(TNode tnode){
		if(tnode.getLeftChild()!=null){
		doInOrder(tnode.getLeftChild());
		}
		System.out.print(tnode.getData()+" ");
		if(tnode.getRightChild()!=null){
		doInOrder(tnode.getRightChild());
		}
	}
	
	public void preOrderTraversal(){
		if(isEmpty()){
			System.out.println("Tree is Empty!!");
		}else{
			doPreOrder(root);
			System.out.println();
		}
	}
	private void doPreOrder(TNode tnode){
		System.out.print(tnode.getData()+" ");
		if(tnode.getLeftChild()!=null){
			doPreOrder(tnode.getLeftChild());
		}
		if(tnode.getRightChild()!=null){
			doPreOrder(tnode.getRightChild());
		}
	}
	
	public void postOrderTraversal(){
		if(isEmpty()){
			System.out.println("Tree is Empty!!");
		}else{
			doPostOrder(root);
			System.out.println();
		}
	}
	private void doPostOrder(TNode tnode){
		if(tnode.getLeftChild()!=null){
			doPostOrder(tnode.getLeftChild());
		}
		if(tnode.getRightChild()!=null){
			doPostOrder(tnode.getRightChild());
		}
		System.out.print(tnode.getData()+" ");
	}
	
	public void breadthFirstTraversal(){
		if(isEmpty()){
			System.out.println("Tree is Empty!!");
		}
		else{
			doBreadthFirst(root);
		}
	}
	
	private void doBreadthFirst(TNode tnode){
		
		TNode newTNode=tnode;
		Queue queue = new Queue(newTNode);
		while(newTNode!=null){
			newTNode=(TNode)queue.dequeueNode();
			System.out.println(newTNode.getData()+ " ");
			//queue.enqueue(newTNode);
			if(newTNode.getLeftChild()!=null){
				queue.enqueue(newTNode.getLeftChild());
			}
			if(newTNode.getRightChild()!=null){
				queue.enqueue(newTNode.getRightChild());
			}
			if(!queue.isEmpty()){
			newTNode=(TNode)queue.dequeueNode();
			}else{
				newTNode=null;
			}
		}
	}

}
