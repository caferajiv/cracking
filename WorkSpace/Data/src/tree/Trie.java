package tree;

import node.TrieNode;

public class Trie {
	
	private TrieNode root;
	
	public Trie()
	{
		root = new TrieNode(' ');
	}
	
	public TrieNode InsertInTrie(TrieNode node,String s)
	{
		if(node!=null)
		{
		if(s.length()!=0)
		{ boolean charFound=false;
			for(TrieNode everyNode: node.getChild())
			{
				if(everyNode.getData()==s.charAt(0))
				{
					charFound=true;
					InsertInTrie(everyNode,s.substring(1,s.length()));
				}
			}
			if(!charFound)
			{
				TrieNode  newNode = new TrieNode(s.charAt(0));
				node.getChild().add(newNode);
				InsertInTrie(newNode,s.substring(1,s.length()));
			}
		}
		
		}
		return null;
	}
	
	public TrieNode searchInTrie(TrieNode node,String s)
	{
		if(node.getChild().isEmpty())
		return node;
		boolean charFound=false;
		for( TrieNode everyNode : node.getChild())
		{
			if(everyNode.getData()==s.charAt(0))
			{ charFound=true;
				if(s.length()-1!=0)
				{
					return searchInTrie(everyNode, s.substring(1,s.length()));
				}else if(s.length()-1==0)
				{
					everyNode.setEndOfString(true);
					return everyNode;
				}
				
			}
			
		}
		 if(!charFound)
			return node;
		 
		 return null;
	
	}

}
