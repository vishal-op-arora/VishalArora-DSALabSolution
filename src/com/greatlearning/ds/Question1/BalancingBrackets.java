package com.greatlearning.ds.Question1;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Sample input");
		String brackets = scan.next();
		scan.close();
		
		boolean isBalaced = isBracketsBalanced(brackets);
		
		System.out.println("\nSample output");
		if(isBalaced) {
			System.out.println("The entered String has Balanced Brackets");
		}
		else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}

	}
	
	public static boolean isBracketsBalanced(String brackets) {
		
		Stack<Character> stack = new Stack<Character>();
		
		// if the length is odd
		if(brackets.length() % 2  == 1 ) {
			return false;
		}
		
		for(char ch : brackets.toCharArray()) {
			
			// Add brackets to the stack
			if (ch == '{' || ch == '[' || ch == '(') {
				stack.add(ch);
			}
			// Check corresponding closing bracket
			else {
				
				boolean isBalaced = false;
				switch(ch) {
					case '}':
						if(stack.pop() == '{') {
							isBalaced = true;
						}
						break;
						
					case ']':
						if(stack.pop() == '[') {
							isBalaced = true;
						}
						break;
					
					case ')':
						if(stack.pop() == '(') {
							isBalaced = true;
						}
						break;
				}
				
				if(!isBalaced) {
					return false;
				}
			}
		}	
		return true;
	}
}
