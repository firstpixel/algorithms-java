package com.firstpixel;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(4);
		LinkedListNode node20 = new LinkedListNode(20);
		LinkedListNode node0 = new LinkedListNode(0);
		
		
		node4.next = node3;
		node3.next = node2;
		node2.next = node20;
		node20.next = node1;
		node1.next = null;
		
		System.out.println("Original: ");
		print(node4);
		LinkedListNode head = reverseList(node4);
		print(head);
		
		
		System.out.println("delete: ");
		head = deleteNode(head, 20);
		print(head);
		
		node3.next = node1;
		node1.next = node2;
		node2.next = node20;
		node20.next = node4;
		node4.next = node0;
		node0.next = null;
		
		System.out.println("sort: ");
		head = insertionSort(node3);
		print(head);
		
		
	}
	
	public static void print(LinkedListNode head) {
		LinkedListNode curr = head;
		while(curr != null) {
			System.out.print(curr.data + "-> " );
			curr = curr.next;
		}
		System.out.println("");
	}
	
// copyHead
//               curr 
//          temp
//1 -> 2   3 -> 4
// temp
//  2  -> 1
	  public static LinkedListNode reverseList(LinkedListNode head) {
	    if (head == null || 
	        head.next == null) {
	      return head;
	    }
	    LinkedListNode curr = head.next;
	    LinkedListNode reverseHead = head;
	    reverseHead.next = null;
	       
	    while(curr != null) {
	      LinkedListNode temp = curr;
	      curr = curr.next;
	      temp.next = reverseHead;
	      reverseHead = temp;
	    }
	    return reverseHead;
	  }
	  
	  
	  
	  public static LinkedListNode deleteNode(LinkedListNode head, int key) 
	  {
	     //TODO: Write - Your - Code
	    if(head == null || head.next == null) {
	      return head;
	    }
	    LinkedListNode temp = null;
	    
	    if(key == head.data){
	      temp = head;
	      head = head.next;
	      temp.next = null;
	      temp = null;
	    }
	    LinkedListNode prev = head;
	    LinkedListNode curr = head.next;
	    
	    while( curr != null) {
	      
	      if(key == curr.data){
	          prev.next = prev.next.next;
	          temp = curr;
	      } else {
	        prev = curr;
	      }
	      
	      curr = curr.next;
	      if(temp != null && temp.next != null){
	        temp.next = null;
	        temp = null;
	      }
	    
	    }
	    return head;
	  } 
	  
	  
	  
	  public static LinkedListNode insertionSort(LinkedListNode head) {

			    if(head == null || head.next == null){
			      return head;
			    }
			    LinkedListNode copyHead = head;
			    LinkedListNode curr = head.next;
			    LinkedListNode copyCurr = copyHead;
			    LinkedListNode copyPrev = copyHead;
			    copyHead.next = null;
			    
			    while(curr != null){
			    	copyPrev = copyHead;
			    	while(copyCurr.next != null && copyCurr.data <= curr.data) {
			    		copyPrev = copyCurr;
			    		copyCurr = copyCurr.next;
			    	}
			        if(copyCurr.data <= curr.data) {
			        	
			        		copyCurr.next = curr;
			        		copyCurr = curr;
			        		curr = curr.next;
			        		copyCurr.next = null;
			        	
			          
			        } else {
			        	LinkedListNode temp = curr.next;
		        		if(copyPrev.equals(copyCurr)) {
		        			curr.next = copyCurr;
				        	
			        		copyHead = curr;
			        	} else {
			        		curr.next = copyPrev.next;
			        		copyPrev.next =  curr;
			        	}
			        	curr = temp;
			        }
			        copyCurr = copyHead;
			    }
		  
		    return copyHead;
	  }
	  
	  
	  
	  public static LinkedListNode intersect(
			    LinkedListNode head1,
			    LinkedListNode head2) {
			    
			    if(head1 == null || head2 == null) {
			      return null;
			    }
			    if(head1.equals(head2)){
			      return head1;
			    }
			    
			    Set<LinkedListNode> hs = new HashSet<>();
			    LinkedListNode curr1 = head1;
			    LinkedListNode curr2 = head2;
			    while(curr1 != null) {
			      hs.add(curr1);
			      curr1 = curr1.next;
			    }
			    while(curr2 != null) {
			      if(hs.contains(curr2)){
			        return curr2;
			      }
			      curr2 = curr2.next;
			    }
			    
			    
			    //TODO: Write - Your - Code
			    return null;
			  } 
	  
}

class LinkedListNode {
	int data;
	LinkedListNode next;
	public LinkedListNode(int data) {
		this.data = data;
		this.next = null;
	}
	
}