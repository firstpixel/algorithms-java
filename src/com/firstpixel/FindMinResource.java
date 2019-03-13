package com.firstpixel;

import java.util.Arrays;

public class FindMinResource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Calendar {
	    int start;
	    int end;
	    int resource; 

	    Calendar (int start, int end, int resource ){
	        this.start = start;
	        this.end = end;
	        this.resource = resource;
	    }
	    
	    public boolean compareTo(Integer a, Integer b) {
	    	return a > b;
	    }
	}


	int findMinResources(Calendar [] arr) {
	    if(arr == null || arr.length == 0) return 0;
	    if(arr.length == 1 ) return arr[0].resource;
/*
	    Arrays.sort(arr, new Comparator<Calendar>() {
	        @Override
	        public int compare(Calendar o1, Calendar o2) {
	            return o1.start.compareTo(o2.start);
	        }
	    });
	    */
	    int i = 0;
	    int j = 1;
	    int end = arr[i].end;
	    int start = arr[j].start;
	    int tempResource = arr[i].resource;  //0 
	    int maxResource = 0;                    // 8
	    while(i < j && j < arr.length) {
	        end = arr[i].end;
	        start = arr[j].start;
	            //500   700  
	        if(end > start) {
	            tempResource += arr[j].resource; // 8
	        } else {
	            tempResource = arr[j].resource;
	        }
	        j++;
	        i++;
	        maxResource = Math.max(tempResource, maxResource);
	    }   

	    return maxResource; 
	}

}
