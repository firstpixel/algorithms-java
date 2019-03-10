package com.firstpixel;

public class DoublyCircularLinkedListCorrupted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeDRLC node1 = new NodeDRLC(1);
		NodeDRLC node2 = new NodeDRLC(2);
		NodeDRLC node3 = new NodeDRLC(3);
		NodeDRLC node4 = new NodeDRLC(4);
		NodeDRLC node5 = new NodeDRLC(5);
		
		node1.next = node2;
		node2.next = null;
		node3.next = node4;
		node4.next = node5;
		node5.next = node1;
		
		node1.prev = node5;
		node2.prev = node1;
		node3.prev = null;
		node4.prev = node3;
		node5.prev = node4;
		

		print(node1);
		
		fixCorrupted(node1);
		System.out.println("Fixed:");
		print(node1);
		
	}
	static NodeDRLC fixCorruptedReverse(NodeDRLC tail) {
		if(tail == null) {
			tail = new NodeDRLC(0);
			return tail;
		}
		NodeDRLC curr = tail.prev;
		//fix all next is 
		curr = tail.prev;
		while (curr != tail ) {
			if(curr.prev != null && curr.prev.next == null) {
				curr.prev.next = curr;
			}else {
				curr = curr.prev;
			}
			curr = curr.prev;
		}
		return tail;
	}
	
	static NodeDRLC fixCorrupted(NodeDRLC head) {
		if(head == null) {
			head = new NodeDRLC(0);
			return head;
		}
		//fix all the previous
		NodeDRLC curr = head.next;
		while (curr != head) {
			if(curr.next == null && head.prev != null) {
				curr = fixCorruptedReverse(head.prev);
				curr =curr.next.next;
			} else {
				if(curr.next == null && head.prev.prev != null) {
					curr = fixCorruptedReverse(head.prev.prev);
					curr =curr.next.next;
				}
			}
			if(curr.next.prev == null) {
				curr.next.prev = curr;
			}
			curr = curr.next;
		}
		
		return head;
	}
	
	static void print (NodeDRLC head) {
		NodeDRLC curr = head.next;
		System.out.println( "data[" + head.data + "] prev[" + head.prev.data + "] -> ");
		while(curr != head && curr.next != null && curr.prev != null) {
			System.out.println( "data[" + curr.data + "] prev[" + curr.prev.data + "] -> ");
			curr = curr.next;
		}
	}
	
}

class NodeDRLC {
	int data;
	NodeDRLC next;
	NodeDRLC prev;
	
	public NodeDRLC(int data){
		this.data = data;
		next = null;
		prev = null;
	}
	
	
	
}

