package com.data.test;

import java.util.Stack;

import com.data.node.TNode;
import com.data.tree.BinarySearchTree;

public class PreorderToPostorderTree {
	
	public static int[] preOrderArray={6,3,2,4,5,9,10,23,13};
	private static TNode tnode= new TNode();
	private static BinarySearchTree tree= new BinarySearchTree(tnode);
	private static Stack<TNode> stack= new Stack<TNode>();
	
	
	
	public static void main(String[] args) {
		int low=0;
		int high=preOrderArray.length-1;
		tnode.setData(preOrderArray[low]);
		tnode.setLeftChild(null);
		tnode.setRightChild(null);
		stack.push(tnode);
		//makeTree(tnode,low+1, high);
		nonRecursiveStackSol(low+1, high);
		tree.inOrderTraversal();
	}
	
	
	private static void nonRecursiveStackSol(int low, int high)
	{
		for( int i=low; i<=high;i++)
		{
			TNode node= new TNode();
			node.setData(preOrderArray[i]);
			if(node.getData()<stack.peek().getData())
			{
				stack.peek().setLeftChild(node);
			}
			else
			{
				TNode popped=null;
				while(!stack.isEmpty() && stack.peek().getData()<=node.getData())
				{
					popped= stack.pop();
				}
				popped.setRightChild(node);
			}
			stack.push(node);
		}
	}
	



	private static void makeTree(TNode root, int low, int high) {
		int i=low;
		while(low<high)
		{		
			if(preOrderArray[i]>=root.getData())
			{
				TNode leftChild=new TNode();
				leftChild.setData(preOrderArray[low]);
				TNode rightChild=new TNode();
				rightChild.setData(preOrderArray[i]);
				
				root.setLeftChild(leftChild);
				root.setRightChild(rightChild);
				makeTree(leftChild, low+1, i-1);
				makeTree(rightChild, i, high);
			}
			i++;
		}
		
	}

}
