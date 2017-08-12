package tree;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

import node.AVLTreeNode;
import node.TreeNode;

public class AVLTree {

	private AVLTreeNode root;
	private int count;

	public AVLTreeNode addChild(AVLTreeNode node, int data) {
		if (root == null)
		{
			root = new AVLTreeNode(data); return root;
		}
		if (root != null) {
			if (root.getData() > data) {
				
					root.setLeftChild(addChild(root.getLeftChild(), data));
				}

			else if (node.getData() < data) {
				
					root.setRightChild(addChild(root.getRightChild(),data));
				}
			}
		return root;
	}

		

	

	public AVLTreeNode deleteChild(AVLTreeNode root,int data) {
		if(root==null)
		{
	    	return null;
		}else
		{
			if(data<root.getData())
			{
				root=deleteChild(root.getLeftChild(),data);
			}
			else if(data>root.getData())
			{
				root=deleteChild(root.getRightChild(),data);
			}
			else if(root.getData()==data)
			{
				if(root.getLeftChild()!=null && root.getRightChild()!=null)
				{
					AVLTreeNode temp=FindMax(root.getLeftChild(),data);
					//root= FindMinInRightSubTree(root,data);
					root.setData(temp.getData());
					root=deleteChild(temp, temp.getData());
					
				}
				else
				{
					AVLTreeNode temp = root;
					if(root.getLeftChild()==null)
					{
						root= root.getRightChild();
					}
					else if(root.getRightChild()==null)
					{
						root= root.getLeftChild();
					}
					else if(root.getLeftChild()==null && root.getRightChild()==null)
					{
						root=null;
					}
					
				}
			}
			return root;
		}
	}

	private AVLTreeNode FindMax(AVLTreeNode node, int data) {
		if(node==null)return null;
		while(node.getRightChild()!=null)
		{
			node=node.getRightChild();
			
		}
		return node;
	}
	
	private AVLTreeNode FindMin(AVLTreeNode node, int data) {
		if(node==null)return null;
		while(node.getLeftChild()!=null)
		{
			node=node.getLeftChild();
			
		}
		return node;
	}

	public void InorderTraversal(AVLTreeNode node) {
		if (root != null) {
			InorderTraversal(root.getLeftChild());
			System.out.println(root);
			InorderTraversal(node.getRightChild());

		}
	}

	public void PreorderTraversal(AVLTreeNode node) {
		if (root != null) {
			System.out.println(root);
			PreorderTraversal(root.getLeftChild());
			PreorderTraversal(node.getRightChild());

		}
	}

	public void PostorderTraversal(AVLTreeNode node) {
		if (root != null) {
			PostorderTraversal(root.getLeftChild());
			PostorderTraversal(node.getRightChild());
			System.out.println(root);

		}
	}

	public void LevelorderTraversal(AVLTreeNode node) {
		if (root == null)
			return;
		ArrayBlockingQueue<AVLTreeNode> Q = new ArrayBlockingQueue<AVLTreeNode>(count);
		if (root != null) {
			Q.offer(root);
		}
		while (Q.peek() != null) {
			AVLTreeNode tnode = Q.poll();
			System.out.println(tnode);
			if (tnode.getLeftChild() != null) {
				Q.offer(tnode.getLeftChild());
				Q.offer(tnode.getRightChild());
			}
		}
	}
	
	public AVLTreeNode inorderSuccessor(AVLTreeNode node, AVLTreeNode P)
	{
		if(root == null)
			return null;
		Stack<AVLTreeNode> stack= new Stack<AVLTreeNode>();
		if(root!=null)
		{ 	stack.push(root);
			if(P.getData()>root.getData())
			{
				root=inorderSuccessor(root.getRightChild(), P);
			}
			else if(P.getData()<root.getData())
			{
				root=inorderSuccessor(root.getLeftChild(), P);
			}
			else if(root.getData()==P.getData())
			{   P = stack.pop();
				if(P.getRightChild()==null)
				{
					P=stack.pop();
				}
				else{
					P=P.getRightChild();
					while(P.getLeftChild()!=null)
						stack.push(P);
					P=P.getLeftChild();
				}
			}
		}
		return P;
	}
	
	public AVLTreeNode preorderSuccessor(AVLTreeNode node, AVLTreeNode P)
	{

		if(root == null)
			return null;
		Stack<AVLTreeNode> stack= new Stack<AVLTreeNode>();
		if(root!=null)
		{ 	stack.push(root);
			if(P.getData()>root.getData())
			{
				root=preorderSuccessor(root.getRightChild(), P);
			}
			else if(P.getData()<root.getData())
			{
				root=preorderSuccessor(root.getLeftChild(), P);
			}
			else if(root.getData()==P.getData())
			{   P = stack.pop();
				if(P.getLeftChild()!=null)
				{
					P=P.getLeftChild();
				}
				else{
					while(P.getRightChild()!=null)
						P=stack.pop();
					P=P.getRightChild();
				}
			}
		}
		return P;
	
	}
	
	public AVLTreeNode leftRotation(AVLTreeNode node)
	{
		AVLTreeNode nodeToRotate = node.getRightChild();
		node.setRightChild(nodeToRotate.getLeftChild());
		nodeToRotate.setLeftChild(node);
		
		node.setHeight(Math.max(node.getRightChild().getHeight(), node.getLeftChild().getHeight())+1);
		nodeToRotate.setHeight(Math.max(nodeToRotate.getRightChild().getHeight(),node.getHeight())+1);
		
		return nodeToRotate;
		
	}
	
	public AVLTreeNode rightRotation(AVLTreeNode node)
	{
		AVLTreeNode nodeToRotate = node.getLeftChild();
		node.setLeftChild(nodeToRotate.getRightChild());
		nodeToRotate.setRightChild(node);
		
		node.setHeight(Math.max(node.getRightChild().getHeight(), node.getLeftChild().getHeight())+1);
		nodeToRotate.setHeight(Math.max(nodeToRotate.getLeftChild().getHeight(),node.getHeight())+1);
		
		return nodeToRotate;
	}
	
	public AVLTreeNode leftRightRotation( AVLTreeNode node)
	{
		node.setLeftChild(leftRotation(node.getLeftChild()));
		return rightRotation(node); 
	}
	public AVLTreeNode rightLeftRotation( AVLTreeNode node)
	{
		node.setRightChild(rightRotation(node.getRightChild()));
		return leftRotation(node);
	}
}
