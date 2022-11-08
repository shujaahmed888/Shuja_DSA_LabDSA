package com.gl.balancingBrackets;

import java.util.Scanner;
import java.util.Stack;

public class balancingBrackets{

	private static boolean balancedBrackets(String str) {
		Stack<Character> stack = new Stack<Character>();
		
		char[] charArray = str.toCharArray();
		for(int i=0;i<charArray.length;i++) {
			char c = charArray[i];
			
			if(c=='('||c=='{'||c=='[') {
				stack.push(c);
				continue;
			}
			if(stack.isEmpty()) {
				return false;
			}
			
			char popStr;
			
			switch(c) {
			
			case')':
				popStr=(char)stack.pop();
				if(popStr=='{'||popStr=='[')
					return false;
				break;
			
			case'}':
				popStr=(char)stack.pop();
				if(popStr=='('||popStr=='[')
					return false;
				break;
				
			case']':
				popStr=(char)stack.pop();
				if(popStr=='('||popStr=='{')
					return false;
				break;
			default: 
				return false;
			}
		}
		
		return (stack.isEmpty());
	}
	
	
	// Driver code
	public static void main(String[] args) {
		
		String inputString;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Strings or Brackets to check for Balancing Brackets");
		inputString=sc.nextLine();
		
		
	if(balancedBrackets(inputString))
		System.out.println("The entered Strings "+inputString+" has balanced brackets");
	else {
		System.out.println("The entered Strings "+inputString+" DO NOT contain balanced brackets");	
	}
	sc.close();
}
}