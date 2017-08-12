package tree;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

import node.TreeNode;

public class BinarySearchTree {

	private TreeNode root;
	private int count;
	
		
	public TreeNode getRoot() {
		return root;
	}

	public TreeNode addChild(int data) {
		if (root == null)
		{
			root = new TreeNode(data); return root;
		}
		if (root != null) {
			
			return addChild(root,data);
		}
		return root;
	}
	
	public TreeNode addChild(TreeNode node,int data) {
	
		if (node != null) {
			if (node.getData() > data) {
				
					addChild(node.getLeftChild(), data);
				}

			else if (node.getData() <= data) {
				
					addChild(node.getRightChild(),data);
				}
			}
		return node;
	}

		

	

	public TreeNode deleteChild(TreeNode node,int data) {
		if(node==null)
		{
	    	return null;
		}else
		{
			if(data<node.getData())
			{
				node=deleteChild(node.getLeftChild(),data);
			}
			else if(data>node.getData())
			{
				node=deleteChild(node.getRightChild(),data);
			}
			else if(node.getData()==data)
			{
				if(node.getLeftChild()!=null && node.getRightChild()!=null)
				{
					TreeNode temp=FindMax(node.getLeftChild(),data);
					//root= FindMinInRightSubTree(root,data);
					node.setData(temp.getData());
					node=deleteChild(temp, temp.getData());
					
				}
				else
				{
					TreeNode temp = node;
					if(node.getLeftChild()==null)
					{
						node= node.getRightChild();
					}
					else if(node.getRightChild()==null)
					{
						node= node.getLeftChild();
					}
					else if(node.getLeftChild()==null && node.getRightChild()==null)
					{
						node=null;
					}
					
				}
			}
			return node;
		}
	}

	private TreeNode FindMax(TreeNode node, int data) {
		if(node==null)return null;
		while(node.getRightChild()!=null)
		{
			node=node.getRightChild();
			
		}
		return node;
	}
	
	private TreeNode FindMin(TreeNode node, int data) {
		if(node==null)return null;
		while(node.getLeftChild()!=null)
		{
			node=node.getLeftChild();
			
		}
		return node;
	}

	public void InorderTraversal(TreeNode node) {
		if (node != null) {
			InorderTraversal(node.getLeftChild());
			System.out.println(node);
			InorderTraversal(node.getRightChild());

		}
	}

	public void PreorderTraversal(TreeNode node) {
		if (node != null) {
			System.out.println(node);
			PreorderTraversal(node.getLeftChild());
			PreorderTraversal(node.getRightChild());

		}
	}

	public void PostorderTraversal(TreeNode node) {
		if (node != null) {
			PostorderTraversal(node.getLeftChild());
			PostorderTraversal(node.getRightChild());
			System.out.println(node);

		}
	}

	public void LevelorderTraversal(TreeNode node) {
		if (node == null)
			return;
		ArrayBlockingQueue<TreeNode> Q = new ArrayBlockingQueue<TreeNode>(count);
		if (node != null) {
			Q.offer(node);
		}
		while (Q.peek() != null) {
			TreeNode tnode = Q.poll();
			System.out.println(tnode);
			if (tnode.getLeftChild() != null) {
				Q.offer(tnode.getLeftChild());
			}
				if (tnode.getRightChild() != null) {
				Q.offer(tnode.getRightChild());
			}
		}
	}
	
	public TreeNode inorderSuccessor(TreeNode node, TreeNode P)
	{
		if(node == null)
			return null;
		Stack<TreeNode> stack= new Stack<TreeNode>();
		if(node!=null)
		{ 	stack.push(node);
			if(P.getData()>node.getData())
			{
				node=inorderSuccessor(node.getRightChild(), P);
			}
			else if(P.getData()<node.getData())
			{
				node=inorderSuccessor(node.getLeftChild(), P);
			}
			else if(node.getData()==P.getData())
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
	
	public TreeNode preorderSuccessor(TreeNode node, TreeNode P)
	{

		if(node == null)
			return null;
		Stack<TreeNode> stack= new Stack<TreeNode>();
		if(node!=null)
		{ 	stack.push(node);
			if(P.getData()>node.getData())
			{
				node=preorderSuccessor(node.getRightChild(), P);
			}
			else if(P.getData()<node.getData())
			{
				node=preorderSuccessor(node.getLeftChild(), P);
			}
			else if(node.getData()==P.getData())
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
}
