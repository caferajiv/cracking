package tree;

import java.util.concurrent.ArrayBlockingQueue;

import node.TreeNode;

public class BinaryTree {
	
	private TreeNode root;
	private int count;
	
	public void addChild(int data)
	{
		if(root==null) return ;
		TreeNode node = new TreeNode();
		node=root;
		while(node!=null)
		{
			if(node.getLeftChild()!=null)
			{ 
				node = node.getLeftChild();
			}
			else if(node.getLeftChild()==null)
			{
				node.setLeftChild(new TreeNode(data));
				count++;
			}
			else if(node.getRightChild()!=null)
			{ 
				node= node.getRightChild();
			}
			else if(node.getRightChild()==null)
			{
				node.setRightChild(new TreeNode(data));
				count++;
			}
			
		}
		
	}
	
	public void deleteChild(int data)
	{
		while(root!=null)
		{
			if(root.getData()==data)
			{ count--;
				if(root.getLeftChild()!=null)
				{
					root=root.getLeftChild();
					
				}else if(root.getRightChild()!=null)
				{
					root=root.getRightChild();
					
				}
				else
				{
					root=null;
					
				}
			}
			else
			{
				if(root.getLeftChild()!=null)
				{
					root=root.getLeftChild();
				}
				else if(root.getRightChild()!=null)
				{
					root= root.getRightChild();
				}
			}
		}
	}
	
	public void InorderTraversal(TreeNode node)
	{
		if(root!=null)
		{
			InorderTraversal(root.getLeftChild());
			System.out.println(root);
			InorderTraversal(node.getRightChild());
			
		}
	}
	
	public void PreorderTraversal(TreeNode node)
	{
		if(root!=null)
		{
			System.out.println(root);
			PreorderTraversal(root.getLeftChild());
			PreorderTraversal(node.getRightChild());
			
		}
	}
	
	public void PostorderTraversal(TreeNode node)
	{
		if(root!=null)
		{
			PostorderTraversal(root.getLeftChild());
			PostorderTraversal(node.getRightChild());
			System.out.println(root);
			
		}
	}
	
	public void LevelorderTraversal(TreeNode node)
	{
		if(root==null) return;
		ArrayBlockingQueue<TreeNode> Q = new ArrayBlockingQueue<TreeNode>(count);
		if(root!=null)
		{
			Q.offer(root);
		}
		while(Q.peek()!=null)
		{
			TreeNode tnode = Q.poll();
			System.out.println(tnode);
			if(tnode.getLeftChild()!=null)
			{
				Q.offer(tnode.getLeftChild());
				Q.offer(tnode.getRightChild());
			}
		}
	}

}
