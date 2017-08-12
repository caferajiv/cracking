package node;

import java.util.Collection;
import java.util.LinkedList;

public class TrieNode {
	
	private char data;
	private boolean endOfString;
	private Collection<TrieNode> child;
	
	public TrieNode()
	{}
	
	public TrieNode(char data){
		this.data=data;
		child = new LinkedList<TrieNode>();
		
	}
	
	public TrieNode getNode(char c)
	{
		if(child!=null)
		{
			for(TrieNode eachChild : child)
			{
				if(eachChild.data==c)
				{
					return eachChild;
				}
			}
		}
		return null;
	}
	/**
	 * @return the data
	 */
	public char getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(char data) {
		this.data = data;
	}
	/**
	 * @return the endOfString
	 */
	public boolean isEndOfString() {
		return endOfString;
	}
	/**
	 * @param endOfString the endOfString to set
	 */
	public void setEndOfString(boolean endOfString) {
		this.endOfString = endOfString;
	}
	/**
	 * @return the child
	 */
	public Collection<TrieNode> getChild() {
		return child;
	}
	/**
	 * @param child the child to set
	 */
	public void setChild(Collection<TrieNode> child) {
		this.child = child;
	}
	

}
