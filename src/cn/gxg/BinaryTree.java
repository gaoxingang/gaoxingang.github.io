/**
 * Project Name:Algorithm
 * File Name:BinaryTree.java
 * Package Name:cn.gxg
 * Date:2019年8月14日下午3:17:33
 * Copyright (c) 2019, Copyright(C) WellTime 2015 All Rights Reserved.
 *
 */

package cn.gxg;

import sun.net.www.content.image.png;

/**
 * ClassName:BinaryTree <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年8月14日 下午3:17:33 <br/>
 * 
 * @author 高新刚
 * @version
 * @since JDK 1.8
 * @see
 */
public class BinaryTree
{

	private Node tree;

	public void insert(int data)
	{
		if (tree == null)
		{
			tree = new Node(data);
			return;
		}
		Node pNode = tree;
		while (pNode != null)
		{
			if (pNode.data < data)
			{
				if (pNode.rightNode == null)
				{
					pNode.rightNode = new Node(data);
					return;
				}
				pNode = pNode.rightNode;
			}
			if (pNode.data > data)
			{
				if (pNode.leftNode == null)
				{
					pNode.leftNode = new Node(data);
					return;
				}
				pNode = pNode.rightNode;
			}
		}
	}

	public Node findNode(int data)
	{
		Node pNode = tree;
		while (pNode != null)
		{
			if (pNode.data < data)
			{
				pNode = pNode.rightNode;
			}
			else if (pNode.data > data)
			{
				pNode = pNode.leftNode;
			}
			else
			{
				return pNode;
			}
		}
		return null;
	}

	public void deleteNode(int data)
	{
		// 要删除的节点
		Node pNode = tree;

		Node ppNode = null;
		while (pNode != null)
		{
			ppNode = pNode;
			if (pNode.data > data)
			{
				pNode = pNode.leftNode;
			}
			if (pNode.data < data)
			{
				pNode = pNode.rightNode;
			}
			if (pNode.data == data)
			{
				break;
			}
		}
		if (pNode == null)
		{
			return;
		}
		Node childNode;
		if (pNode.leftNode != null)
		{
			childNode = pNode.leftNode;
		}
		else if (pNode.rightNode != null)
		{
			childNode = pNode.rightNode;
		}
		else
		{
			childNode = null;
		}
		if (ppNode == null)
		{
			tree = childNode;
		}
		if (ppNode.leftNode == pNode)
		{
			ppNode.leftNode = childNode;
		}
		else if (ppNode.rightNode == pNode)
		{
			ppNode.rightNode = childNode;
		}
		if (pNode.leftNode != null && pNode.rightNode != null)
		{
			Node minNode = pNode.rightNode;
			Node minPNode = pNode;
			while (minNode.leftNode != null)
			{
				minPNode = minNode;
				minNode = minNode.leftNode;
			}
			// minPNode.leftNode=null;
			// minNode.leftNode=pNode.leftNode;
			// minNode.rightNode=pNode.rightNode;
			// ppNode.leftNode=minNode;

			pNode.data = minNode.data;
			pNode = minNode;
			ppNode = minPNode;

		}
	}

	public void preOrder(Node tree)
	{
		if (tree == null)
		{
			return;
		}
		System.out.println(tree.data);
		preOrder(tree.leftNode);
		preOrder(tree.rightNode);
	}

	public void midOrder(Node tree)
	{
		if(tree==null)
		{
			return;
		}
		preOrder(tree.leftNode);
		System.out.println(tree.data);
		preOrder(tree.rightNode);
	}

	public void lastOrder(Node tree)
	{

	}

	public static class Node
	{
		int data;
		Node leftNode;
		Node rightNode;

		public Node(int data)
		{
			this.data = data;
		}

	}

	public static void main(String[] args)
	{
		
	}
}
