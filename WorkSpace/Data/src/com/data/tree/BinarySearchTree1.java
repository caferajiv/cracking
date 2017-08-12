package com.data.tree;

import com.data.node.TNode;
import com.data.queue.Queue;

public class BinarySearchTree1 {
	
	private TNode root;
	private int count;
	
	public BinarySearchTree1(){
		
	}
	
	public BinarySearchTree1(TNode tNode){
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
	
	
	private void addAtNode(TNode node, int data){
		if(data<node.getData()){
			if(node.getLeftChild()!=null){
				addAtNode(node.getLeftChild(), data);
			}else{
				node.setLeftChild(new TNode(data));
			}
		}else{
			if(node.getRightChild()!=null){
				addAtNode(node.getRightChild(), data);
			}else{
				node.setRightChild(new TNode(data));
			}
		}
	}
	
	public void add(int data){
		if(isEmpty()){
			root=new TNode(data);
			count=1;
		}else{
			addAtNode(root, data);
		}
		
	}
	
	
	public void addNonRecursive(int data){
		if(isEmpty()){
			root=new TNode(data);
			count=1;
		}else{
			addAtNodeNonRecursive(root, data);
		}
		
	}
	private void addAtNodeNonRecursive(TNode node, int data) {
		
		while(node!=null){
			if(data<node.getData()){
				if(node.getLeftChild()!=null){
					node = node.getLeftChild();
				}else{
					node.setLeftChild(new TNode(data));
				}
			}else{

				if(node.getRightChild()!=null){
					node = node.getRightChild();
				}else{
					node.setRightChild(new TNode(data));
				}
			
			}
		}
		
	}

	public void addChild(int data){
		
	}
	

	
	/**
	 * deletes the node with value as data and return true.
	 * returns false if data does not exist
	 * @param data
	 * @return
	 */
	public boolean delete(int data){
		
		if(isEmpty()){
			System.out.println("Tree Empty!!");
			return false;
		}else{
			return deleteAtNode(root,data);
		}
		
	}
	
	private boolean deleteAtNode(TNode node, int data) {
		
		while(node!=null){
			if(data<node.getData()){
				node=node.getLeftChild();
			}else if(data>node.getData()){
				node = node.getRightChild();
			}else if(data == node.getData()){
				deleteThisNode(node);
				return true;
			}else{
				System.out.println("data not found");
				return false;
			}
		}
		return true;
		
	}

	private boolean deleteThisNode(TNode node) {
	
		if(node.getLeftChild()!=null && node.getRightChild()!=null){
			TNode tempNode = findMinimumNodeInRightTree(node);
			if(tempNode.getData()==node.getData()){
				tempNode = findMaxNodeInLeftTree(node);
			}
			
			if(tempNode.getData()==node.getData()){
				node.setData(node.getLeftChild().getData());
				deleteThisNode(node.getLeftChild());
			}else{
				int data = node.getData();
				node.setData(tempNode.getData());
				deleteAtNode(tempNode,data);
			}
			
		}else if(node.getLeftChild()!=null && node.getRightChild()==null){
			node.setData(node.getLeftChild().getData());
			deleteThisNode(node.getLeftChild());
		}else if(node.getLeftChild()==null && node.getRightChild()!=null){
			node.setData(node.getRightChild().getData());
			deleteThisNode(node.getRightChild());
		}else if(node.getLeftChild()==null && node.getRightChild()==null){
			node=null;
			return true;
		}
		return false;
		
	}

	private TNode findMaxNodeInLeftTree(TNode node) {

		while(node.getRightChild()!=null){
			node = node.getRightChild();
		}
		return node;
	
	}

	private TNode findMinimumNodeInRightTree(TNode node) {
		while(node.getLeftChild()!=null){
			node = node.getLeftChild();
		}
		return node;
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
