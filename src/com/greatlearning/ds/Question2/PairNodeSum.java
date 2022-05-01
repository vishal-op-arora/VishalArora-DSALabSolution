package com.greatlearning.ds.Question2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class PairNodeSum {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> inputNodeValues = new ArrayList<Integer>();
		System.out.println("Enter Node values or Non-numeric string or character to to exit");
			
		while(scan.hasNextInt()) {
			inputNodeValues.add(scan.nextInt());
		}
		if(!scan.hasNextInt()) {
			String dummy = scan.next(); // just to hold the input value
		}
		
		// Display the values
		System.out.print("\nNode Values : ");
		for(int value : inputNodeValues) {
			System.out.print(value + ", ");
		}
		
		// Sum value input 
		System.out.print("\nEnter the Sum of Pair : ");
		int sum = scan.nextInt();
		scan.close();
		
		//int[] inputNodeValues = {40, 20, 10, 30, 60, 50, 70, 5, 15, 25, 35, 45, 55, 65, 75};
		
		Node root = null;
		
		for(int value : inputNodeValues) {
			if(root == null) {
				root = insert(root, value);
			}
			else {
				insert(root, value);
			}
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		if(!findPair(root, sum, set)) {
			System.out.println("Nodes are not found.");
		}
	}
	 
	
	/**
	 * if root node is null, set its value 
	 * if value is less than to the root node value than set value to the left node otherwise to the right node.
	 * @param root current root node
	 * @param value Node value
	 * @return Node
	 */
	public static Node insert(Node root, int value) {
		
		if(root == null) {
			root = new Node(value);
		}
		else if(value < root.value) {
			root.left = insert(root.left, value);
		}
		else {
			root.right = insert(root.right, value);
		}
		
		return root;
	}
	
	/**
	 * Return true if found the at least a pair and node values 
	 * @param root is a Node
	 * @param sum
	 * @param set HashSet<Integer> to store the values
	 * @return
	 */
	public static boolean findPair(Node root, int sum, HashSet<Integer> set) {
		
		if(root == null) {
			return false;
		}
		
		if(findPair(root.left, sum, set)) {
			return true;
		}
		
		if(set.contains(sum - root.value)) {
			System.out.println("Pair is (" + (sum - root.value) + "," + root.value + ")" );
			return true;
		}
		else {
			set.add(root.value);
		}
		
		return findPair(root.right, sum, set);
	}
}