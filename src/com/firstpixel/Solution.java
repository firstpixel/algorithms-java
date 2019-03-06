package com.firstpixel;

import java.util.Stack;

public class Solution {
	

	/*
		Given a string, find the length of the longest substring without repeating characters.
		Examples:
		Given "abcabcbb", the answer is "abc", which the length is 3.
		Given "bbbbb", the answer is "b", with the length of 1.
		Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	  */
	
	
	 public int lengthOfLongestSubstring(String s) {
	        StringBuilder currentString = new StringBuilder();
	        String maxString = "";
	        int index = 0;
	        char [] charArray = s.toCharArray();
	        
	        while(index < s.length()) {
	        		if(currentString.indexOf(String.valueOf(charArray[index])) == -1) {
	        			currentString.append(charArray[index]);
	        		}else {
	        			String ns = currentString.substring(currentString.indexOf(String.valueOf(charArray[index])) + 1 ) + String.valueOf(charArray[index]);
	        			currentString = new StringBuilder(ns);
	        			currentString.setLength(ns.length());
	        		}
	        		if(currentString.length() > maxString.length()) {
	    				maxString = currentString.toString();
	    			}
	        		index++;
	        }
	        
	        return maxString.length();
	    }
	 
	 /*
	  Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
		Example:
		
		Input: "babad"
		Output: "bab"
		Note: "aba" is also a valid answer.

		Input: "cbbd"
		Output: "bb"
	  */
	 	public String longestPalindrome(String s) {
	 		int low = 0, high = 0, 
	 		maxLength = 1,
	 		len = s.length();
	 		if (len < 2) return s;
	 		int start = 0;
	 		
	 		for(int i = 1; i < len; i++) {
	 			low = i - 1;
	 			high = i;
	 			
	 			//check palindrome
	 			while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
	 				int curLen = high - low + 1;
	 				if(curLen > maxLength) {
	 					start = low;
	 					maxLength = curLen;
	 					if(maxLength == len ) return s;
	 				}
	 				low--;
	 				high++;
	 			}
	 			
	 			low = i - 1;
	 			high = i + 1;
	 			//check palindrome
	 			while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
	 				int curLen = high - low + 1;
	 				if(curLen > maxLength) {
	 					start = low;
	 					maxLength = curLen;
	 					if(maxLength == len ) return s;
	 				}
	 				low--;
	 				high++;
	 			}
	 		}
	 		return s.substring(start, start + maxLength);

	    }
	 
	 	public String convert(String s, int numRows) {
	 		if(s.equals("") || s.length() <= numRows || numRows == 1) return s;
	        int len = s.length();
	        StringBuffer [] stringArray = new StringBuffer[numRows];
	        for(int i=0; i<numRows; i++) {
	            stringArray[i] = new StringBuffer("");
	        }
	        boolean isDown = true;
	        int row = 0;
	        int index = 0; 
	        while(isDown && index < len) {
	            if(row == numRows - 1) {
	                isDown = false;
	            }else{
	                stringArray[row].append(s.charAt(index));
	                row++;
                    index++;
	            }
	            while(!isDown && index < len) {
	                if(row == 0) {
	                    isDown = true;
	                }else{
                        stringArray[row].append(s.charAt(index));
                        row--;
                        index++;
                    }
                    
	            }
	        }
            int j = 1; 
            while(j < numRows){
                stringArray[0].append(stringArray[j].toString());
                j++;                
            }    
	        return stringArray[0].toString();
	    }
	 	
	 	/**
	 	 * reduce find all possible results for parenteses 
	 	 * Example : "(a)((b)c)d)" -> (a)((b)c)d, (a)((bc)d), (a)((b)cd) 
	 	 * Example2 : "(a)c)" -> (ac), (a)c
	 	 * Example3 : "(a))" -> (a), (a) 
	 	 * 
	 	 * @param inputString
	 	 * @return
	 	 */
	 	
	 	
	 	public StringBuffer[] reduce(String inputString) {
	 		StringBuffer[] result = new StringBuffer[]{};
	 		Stack<Character> st = new Stack<Character>();
	 		
	 		
	 		if(isBalanced(inputString)) {
	 			result[0] = new StringBuffer(inputString);
	 			return result;
	 		} else {
	 			int opening = 0;
		 		int closing = 0;
		 		
	 			for(char c:  inputString.toCharArray()) {
		 			if( c == '(' ) {
			 			opening++;
		 			} else if( c == ')') {		 				
		 				closing++;
		 			}
		 		}
	 			if(closing > opening) {
	 				
	 			}
	 		}
	 		
	 		
	 		
	 		return result;
	 	}
	 	
	 	
	 	private boolean isBalanced(String inputString) {
	 		Stack<Character> st = new Stack<Character>();
	 		int index = 0;
	 		boolean balanced = true;
	 		while( index < inputString.length() && balanced) {
	 			char c = inputString.charAt(index);
	 			if( c == '(' ) {
		 				st.push(c);
	 			} else if( c == ')') {
	 				if (st.isEmpty()) {
	 					balanced = false;
		 			} else {
		 				st.pop();
		 			}
	 			}
	 			index++;
	 		}
	 		if(balanced && st.isEmpty()) {
	 			return true;
	 		}
	 		return false;
	 	}
	 	
	 
}