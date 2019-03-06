package com.firstpixel;

public class ReverseWords {

	public static void main (String[] args) {
		//code
		//Scanner in = new Scanner(System.in);
		//Integer n = Integer.parseInt(in.nextLine());
		//System.out.println(n);
		Integer n = 1;
		
		for(int i=0; i<n; i++){
		    //String line = in.nextLine();
		    String line = "this.is.just.a.test";
			System.out.println(reverseWord(line));
		}
		
	}
	
	private static String reverseWord(String str) {
		
		
	    String delim = "\\.";
    	String[] array = str.split(delim);
    	for(int i = 0; i < array.length / 2; i++)
        {
            String temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        String result = String.join(".",array);
	    return result;
	}

}
