package com.firstpixel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {

	/**
	 
	 DFS can solve

		Topological sorting.
		
		Finding connected components.
		
		Finding articulation points.
		
		Solving puzzles.
		
		Finding strongly connected components.
	 
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arr = {{1,0,0,0},
					   {1,0,0,0},
					   {1,1,0,1},
					   {1,1,0,1}};
		
		
		DepthFirstSearch dfs = new DepthFirstSearch();
		NodeDFS node00  = new NodeDFS(1);
		NodeDFS node01  = new NodeDFS(0);
		NodeDFS node02  = new NodeDFS(0);
		NodeDFS node03  = new NodeDFS(0);
		NodeDFS node10  = new NodeDFS(1);
		NodeDFS node11  = new NodeDFS(0);
		NodeDFS node12  = new NodeDFS(0);
		NodeDFS node13  = new NodeDFS(0);
		NodeDFS node20  = new NodeDFS(1);
		NodeDFS node21  = new NodeDFS(1);
		NodeDFS node22  = new NodeDFS(0);
		NodeDFS node23  = new NodeDFS(1);
		NodeDFS node30  = new NodeDFS(1);
		NodeDFS node31  = new NodeDFS(1);
		NodeDFS node32  = new NodeDFS(0);
		NodeDFS node33  = new NodeDFS(1);
		
		node00.neighbours.add(node01);
		node00.neighbours.add(node10);
		node00.neighbours.add(node11);
		
		node01.neighbours.add(node00);
		node01.neighbours.add(node10);
		node01.neighbours.add(node11);
		node01.neighbours.add(node12);
		node01.neighbours.add(node02);

		node02.neighbours.add(node01);
		node02.neighbours.add(node11);
		node02.neighbours.add(node12);
		node02.neighbours.add(node13);
		node02.neighbours.add(node03);

		
		dfs.dfsUsingStack(node00);
		
	}
	
	public static int getRegionSize(int[][]arr, int row, int col){
		if(row < 0 || col < 0 || row >= arr.length || col >= arr[row].length ){
			return 0;
		}
		int regionSize = 1;
		arr[row][col] = 0;// or use 2 to have original back once finished we can change it back to 1;
		for(int r=row -1;r <= row+1; r++) {
			for(int c=col -1;c <= col+1; c++) {
				regionSize += getRegionSize(arr, r, c);
			}
		}
		return regionSize;
	} 

	// Iterative DFS using stack
	public void dfsUsingStack(NodeDFS node)
	{
		Stack<NodeDFS> stack=new  Stack<NodeDFS>();
		stack.add(node);
		Set<NodeDFS> visitedHS = new HashSet<NodeDFS>(); 
		visitedHS.add(node);
		while (!stack.isEmpty())
		{
			NodeDFS element=stack.pop();
			System.out.print(element.data + " ");
 
			List<NodeDFS> neighbours=element.neighbours;
			for (int i = 0; i < neighbours.size(); i++) {
				NodeDFS n=neighbours.get(i);
				if(n!=null && !visitedHS.contains(n))
				{
					stack.add(n);
					visitedHS.add(n);
				}
			}
		}
	}
}


class NodeDFS{
	int data;
	ArrayList<NodeDFS> neighbours;
	public NodeDFS(int data) {
		this.data = data;
		this.neighbours = new ArrayList<NodeDFS>();
	}
	
}