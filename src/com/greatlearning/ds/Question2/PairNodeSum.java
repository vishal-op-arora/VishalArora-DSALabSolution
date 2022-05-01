package com.greatlearning.ds.Question2;




public class PairNodeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(14);

		root.left = new Node(20);
		root.left.left = new Node(10);
		root.left.right = new Node(30);
		
		root.right = new Node(60);
		root.right.left = new Node(50);
		root.right.right = new Node(70);
		
		boolean pairFound = false;
		int sum = 130;
		
		pairSum(root, 10);
		
		
	}
	
	
	/**
	 * if root node is null, set its value 
	 * if value is less than to the root node value than set value to the left node otherwise to the right node.
	 * @param root current root node
	 * @param value Node value
	 * @return Node
	 */
	public Node insert(Node root, int value) {
		
		if(root == null) {
			root = new Node(value);
		}
		else if(value < root.left.value) {
			root.left = insert(root.left, value);
		}
		else {
			root.right = insert(root.right, value);
		}
		
		return root;
	}
	
	
	public static void pairSum(Node node, int sum) {
		
		if(node.right != null) {
			System.out.println(node.value + " - " + node.right.value);
			pairSum(node.right, sum);
		}
	}
	
	

}


