package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Vertex
{
	public char label;
	
	public boolean visited;
	
	public Vertex(char label)
	{
		this.label=label;
		visited = false;
	}
	@Override
	public String toString() {
		
		return label+"";
	}
}
public class Graph {
	private int vertexCount;
	private List<Vertex> vertexList;
	private int [][] adjMatrix;
	@SuppressWarnings("rawtypes")
	private Stack<Integer> stack;
	
	private Queue<Integer> queue;
	
	@SuppressWarnings("rawtypes")
	public Graph(int vertexCount)
	{
		this.vertexCount=vertexCount;
		adjMatrix= new int [vertexCount][vertexCount];
		vertexList = new ArrayList<Vertex>();
		stack = new Stack<Integer>();
		queue = new LinkedList<Integer>();
	}
	
	public void addVertex(char label)
	{
		vertexList.add(new Vertex(label));
	}
	
	public void addEdge(int start, int end, int cost)
	{
		adjMatrix[start][end]=cost;
	}
	
	public void displayVertex(int index)
	{
		System.out.println(vertexList.get(index));
	}
	
	public void BreadthFirstSearch()
	{
		if(vertexList!=null && vertexList.size()!=0)
		{
			vertexList.get(0).visited=true;
			displayVertex(0);
			queue.offer(0);
		}
		int v;
		while(!queue.isEmpty())
		{
			int v1=queue.poll();
			//getUnvisited vertex with lowest cost adjacent to stack top
			while( (v = getAdjLowCostUnvisitedVertex(v1))!=-1)
			{
				vertexList.get(v).visited=true;
				displayVertex(v);
				queue.offer(v);
			}
		}
		//reset all visited flags
		for(Vertex vertex: vertexList)
		{
			vertex.visited=false;
		}
	}
	
	public void DepthFirstSearch()
	{
		if(vertexList!=null && vertexList.size()!=0)
		{
			vertexList.get(0).visited=true;
			displayVertex(0);
			stack.push(0);
		}
		
		while(!stack.isEmpty())
		{
			//getUnvisited vertex with lowest cost adjacent to stack top
			int v = getAdjLowCostUnvisitedVertex(stack.peek());
			if(v==-1)
			{
				stack.pop();
			}
			else
			{
				vertexList.get(v).visited=true;
				displayVertex(v);
				stack.push(v);
			}
		}
		//reset all visited flags
		for(Vertex v: vertexList)
		{
			v.visited=false;
		}
	}

	private int getAdjLowCostUnvisitedVertex(int v) {
		int minCost=999;
		int minIndex=-1;
		for(int i=0; i<vertexCount;i++)
		{
			if(adjMatrix[v][i]>0 && vertexList.get(i).visited==false)
			{
				if(adjMatrix[v][i]<minCost)
				{
					minCost=adjMatrix[v][i];
					minIndex=i;
				}
			}
		}
		if(minCost<999)
			return minIndex;
		return -1;
	}

}


