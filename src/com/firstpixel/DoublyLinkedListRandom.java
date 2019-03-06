package com.firstpixel;

public class DoublyLinkedListRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeDRL node1 = new NodeDRL(1);
		NodeDRL node2 = new NodeDRL(2);
		NodeDRL node3 = new NodeDRL(3);
		NodeDRL node4 = new NodeDRL(4);
		NodeDRL node5 = new NodeDRL(5);
		
		//next
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		
		//random
		node1.random = node4;
		node2.random = node5;
		node3.random = node2;
		node4.random = node3;
		node5.random = node1;
		
		
		print(node1);
		
		NodeDRL cloned = clone(node1);
		System.out.println("cloned:");
		print(cloned);

		System.out.println("original:");
		print(node1);

	}
	//rand  4	 5	  2	   3    1  
	//next  1 -> 2 -> 3 -> 4 -> 5
	
	//  1 ->
	static NodeDRL clone(NodeDRL head) {
		NodeDRL original = head;
		NodeDRL copy = null;
		NodeDRL copyHead = null;
		
		//insert a copy of the original on next original
		while(original != null) {
			copy = new NodeDRL(original.data);
			copy.next = original.next;
			original.next = copy;
			original = copy.next;
		}
		
		//copy the random to the next of original random, as its the copy of it
		original = head;
		while(original != null) {
			original.next.random = original.random.next;
			original = original.next.next;
		}
		
		//break into 2 linkedLists
		original = head;
		copy = copyHead = head.next;
		while(original != null && original.next != null) {
			original = original.next = (original.next != null)?original.next.next : original.next;
			copy = copy.next = (copy.next != null)?copy.next.next : copy.next;
		}
		return copyHead;
	}
	
	NodeDRL head = null;
	NodeDRL tail = null;
	
	public DoublyLinkedListRandom(NodeDRL head) {
		this.head = head;
		NodeDRL curr = head.next;
		while(curr!=head) {
			curr = curr.next;
		}
		this.tail = curr;
	}
	
	static void print (NodeDRL head) {
		NodeDRL curr = head;
		while(curr != null) {
			System.out.println( "data[" + curr.data + "] rand[" + curr.random.data + "] -> ");
			curr = curr.next;
		}
	}
	
}




class NodeDRL {
	int data;
	NodeDRL next;
	NodeDRL random;
	
	public NodeDRL( int data){
		this.data = data;
		next = null;
		random = null;
	}
	
	
	
}
