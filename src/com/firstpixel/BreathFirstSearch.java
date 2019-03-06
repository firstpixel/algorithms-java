package com.firstpixel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreathFirstSearch {
	/** 
	 
	 BFS can solve:

		Checking given graph is connected or not
		
		Checking given graph is having cycle or not.
		
		Finding number of connected components.
		
		Finding shortest path between two nodes.
		
		We can test condition of bipartiteness.
	 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeBFS node1 = new NodeBFS(1);
		NodeBFS node2 = new NodeBFS(2);
		NodeBFS node3 = new NodeBFS(3);
		NodeBFS node4 = new NodeBFS(4);
		NodeBFS node5 = new NodeBFS(5);
		NodeBFS node6 = new NodeBFS(6);
		NodeBFS node7 = new NodeBFS(7);
		NodeBFS node8 = new NodeBFS(8);

		node1.right = node2;
		node1.left = node3;
		node2.right = node4;
		node2.left = node5;
		node3.right = node6;
		node3.left = node7;
		node5.right = node8;
		
        boolean search = BFS(node1, 8);

        if(search) {
            System.out.print("Path Found!");
            
        } else {
        	System.out.print("Path NOT Found!");
        }
        
        NodeBFSTree nodeTree1 = new NodeBFSTree(1);
        NodeBFSTree nodeTree2 = new NodeBFSTree(2);
        NodeBFSTree nodeTree3 = new NodeBFSTree(3);
        NodeBFSTree nodeTree4 = new NodeBFSTree(4);
        NodeBFSTree nodeTree5 = new NodeBFSTree(5);
        NodeBFSTree nodeTree6 = new NodeBFSTree(6);
        NodeBFSTree nodeTree7 = new NodeBFSTree(7);
        NodeBFSTree nodeTree8 = new NodeBFSTree(8);

        nodeTree1.children.add(nodeTree2);
        //nodeTree1.children.add(nodeTree7);
        nodeTree2.children.add(nodeTree3);
        nodeTree3.children.add(nodeTree4);
        nodeTree3.children.add(nodeTree5);
        nodeTree4.children.add(nodeTree1);
        nodeTree5.children.add(nodeTree6);
        nodeTree6.children.add(nodeTree7);
        nodeTree7.children.add(nodeTree8);
        
		boolean search1 = BFS(nodeTree1, 8);

        if(search1) {
            System.out.print("Path Tree Found!");
            
        } else {
        	System.out.print("Path Tree NOT Found!");
        }
        
        Integer distance = shortestPath(nodeTree1, nodeTree5);
        System.out.print(distance);
	}
	
	public static boolean BFS(NodeBFS head, int search) {
		if(head == null) {
			return false;
		}
		if(head.value == search) {
			//System.out.println(head);
			return true;
		}
		
		Queue<NodeBFS> queue = new LinkedList<>();
        ArrayList<NodeBFS> visited = new ArrayList<>();
        queue.add(head);
        
        while( !queue.isEmpty()) {
        	NodeBFS curr = queue.remove();
        	if (curr.value == search) {
        		//System.out.println(visited);
        		return true;
        	} else {
        		if(curr.left == null && curr.right == null && queue.isEmpty()) {
        			return false;
        		} else {
        			if(curr.right != null)queue.add(curr.right);
        			if(curr.left != null)queue.add(curr.left);
        		}
        	}
        	visited.add(curr);
        }		
		return true;
	}
	
	
	public static boolean BFS(NodeBFSTree head, int search) {
		if(head == null) {
			return false;
		}
		if(head.value == search) {
			//System.out.println(head);
			return true;
		}
		
		Queue<NodeBFSTree> queue = new LinkedList<>();
        ArrayList<NodeBFSTree> visited = new ArrayList<>();
        queue.add(head);
        
        while( !queue.isEmpty()) {
        	NodeBFSTree curr = queue.remove();
        	if (search == curr.value) {
        		return true;
        	} else {
        		if(curr.children.size() == 0 && queue.isEmpty()) {
        			return false;
        		} else{
        			for (NodeBFSTree child: curr.children) {
        				if(!visited.contains(child)) {
            				queue.add(child);    					
        				}
        			}
        		}
        	}
        	visited.add(curr);
        }		
		return true;
	}
	
	//find shortest path
	
	
	static Integer shortestPath(NodeBFSTree start, NodeBFSTree end) {
		Queue<NodeBFSTree> queue = new LinkedList<NodeBFSTree>();
		queue.add(start);
		Map<NodeBFSTree, Integer> distances = new HashMap<NodeBFSTree, Integer>();
		distances.put(start, new Integer(0));
		while( !queue.isEmpty()) {
        	NodeBFSTree curr = queue.remove();
        	if (end.value == curr.value) {
        		distances.put(end, distances.get(curr) );
        		return distances.get(end);
        	} else {
        		if(curr.children.size() == 0 && queue.isEmpty()) {
        			return null;
        		} else{
        			for (NodeBFSTree child: curr.children) {
        				if(distances.get(child) == null) {
        					distances.put(child, distances.get(curr) + 1 );
            				queue.add(child);					
        				}
        			}
        		}
        	}
        }		
		return null;
	}
	
}
	


class NodeBFS{
	int value;
	NodeBFS left;
	NodeBFS right;
	
	public NodeBFS(int value) {
		this.value = value;
	}
}


class NodeBFSTree{
	int value;
	List<NodeBFSTree> children;
	public NodeBFSTree(int value) {
		this.value = value;
		this.children = new ArrayList<NodeBFSTree>();
		
	}
}