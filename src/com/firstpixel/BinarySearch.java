package com.firstpixel;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int[] arr1 = {1,2,4,7,8,12,15,19,24,50,69,80,100};
	    System.out.println("Key(1) found at: "+binSearch(arr1,1));
	    System.out.println("Key(12) found at: "+binSearch(arr1,12));
	    System.out.println("Key(44) found at: "+binSearch(arr1,44));
	    System.out.println("Key(100) found at: "+binSearch(arr1,100));
	    
	    
	    System.out.println("Key(1) found at: "+binSearchInteractive(arr1,1));
	    System.out.println("Key(15) found at: "+binSearchInteractive(arr1,12));
	    System.out.println("Key(44) found at: "+binSearchInteractive(arr1,44));
	    System.out.println("Key(100) found at: "+binSearchInteractive(arr1,100));
	    
	}
	
	//a is sorted array
	static int binSearch(int[] a, int key) {
	    if(a == null || a.length == 0 || key < 0) {
	      return -1;
	    }
	    return binSearch(a, key, 0, a.length -1);
	}
	static int binSearch(int[] a, int key, int start, int end) {
	      if(start > end){
	        return -1;
	      }
	      int mid = (start + end) / 2;
	      if(a[mid] == key) {
	        return mid;
	      } else if(a[mid] > key) {
	        return binSearch(a,key, start, mid -1);
	      } else {
	        return binSearch(a,key, mid + 1, end);
	      }
	}
	
	
	static int binSearchInteractive(int[] a, int key) {
		if(a == null || a.length == 0 || key < 0) {
			return -1;
		}
		
		int start = 0;
		int end = a.length;
		
		while(start < end ) {
			int mid = (start + end) / 2;
			if(a[mid]==key) {
				return mid;
			}	
			
			if(a[mid] > key) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return -1;
	}

}
