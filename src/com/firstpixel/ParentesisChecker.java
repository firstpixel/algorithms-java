package com.firstpixel;
import java.util.*;
import java.lang.*;
import java.io.*;

public class ParentesisChecker {

	/*package whatever //do not write package name here */


		public static void main (String[] args) {
			//code
			try {
	    		// Using Scanner for Getting Input from User 
	            //Scanner in = new Scanner(System.in); 
	      
	            //int a = in.nextInt(); 
	            int a = 1;
	            
	            ArrayList<String> arr = new ArrayList<String>();
	            
	            arr.add("{}{(}))}"); 
	            arr.add("{}{({})}"); 
	            arr.add("{}{()}"); 
	            	            for (int i=0; i< arr.size(); i++) {
	            	                String str = arr.get(i).trim();
	            	                if(isBalanced(str)) {
	            	                	System.out.println("balanced");
	            	                }else {
	            	                	System.out.println("not balanced");
	            	                }
	        	                }
	            			} catch (RuntimeException e) {
	            			    System.out.println(e);
	            			}
	            		
	            
		}
		
		private static boolean isBalanced(String str) {
			if(str.length() % 2 != 0 || str.length() == 0) {
                return false;
            }
            //Create a stack to add itens and remove if matches, 
            //if at the end stack is empty, its balanced
            Stack<Character> stack = new Stack<Character>();
            for(int j=0; j < str.length(); j++) {
               if('{'== str.charAt(j)) {
                   stack.add('}');
               } 
               if('[' == str.charAt(j)) {
                   stack.add(']');
               } 
               if('(' == str.charAt(j)) {
                   stack.add(')');
               } 
               if('}' == str.charAt(j)) {
            	   if(stack.isEmpty()) return false;
                   Character result = stack.pop();
                   if(result != '}') {
                       return false;
                   }
               } 
               if(']' == str.charAt(j)) {
            	   if(stack.isEmpty()) return false;
                   Character result = stack.pop();
                   if(result != ']') {
                       return false;
                   }
               } 
               if(')' == str.charAt(j)) {
            	   if(stack.isEmpty()) return false;
                   Character result = stack.pop();
                   if(result != ')') {
                	   return false;
                   }
               } 
               
               
            }
            if(!stack.isEmpty()) {
                return false;
            }
            return true;
            
		}
	

}
