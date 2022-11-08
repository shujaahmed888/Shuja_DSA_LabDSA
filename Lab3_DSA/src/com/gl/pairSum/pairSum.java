package com.gl.pairSum;

import java.util.*;

public class pairSum {

	static class Node {
		int nodeData;
		Node leftNode, rightNode;
	};

	static Node NewNode(int nodeData)
	{
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;

		return temp;
	}

	public Node insert(Node root, int key)
	{
		if (root == null)
			return NewNode(key);
		if (key < root.nodeData)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}

	public boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
		
		if(root==null) {
			return false;
		}
		
		if(findpairUtil(root.leftNode, sum, set)) {
			return true;
		}
		//check if the sum - root.nodeData
		if(set.contains(sum-root.nodeData)) {
			System.out.println("Pair is found in the nodes "+ (sum - root.nodeData) + ","+ root.nodeData);
			return true;
		}
		else {
			set.add(root.nodeData);
			return findpairUtil(root.rightNode, sum, set);
			}
	}
 
	public void findPairWithGivenSum(Node root, int sum){
		HashSet<Integer> set = new HashSet<>();
		if(!findpairUtil(root, sum, set)) {
			System.out.println("Pair does not exists");
		}
		return;
		
	}

	// Driver code
	public static void main(String[] args)	{
		
		Scanner sc = new Scanner(System.in);
		
		
		Node root = null;
		
		pairSum findSP = new pairSum();
		root = findSP.insert(root, 40);
		root = findSP.insert(root, 20);
		root = findSP.insert(root, 60);
		root = findSP.insert(root, 10);
		root = findSP.insert(root, 30);
		root = findSP.insert(root, 50);
		root = findSP.insert(root, 70);

		System.out.println("Enter the Sum you are looking for in the Pairing nodes of the BST:");

		int sum = sc.nextInt();
		
		findSP.findPairWithGivenSum(root, sum);
		sc.close();
	}

}