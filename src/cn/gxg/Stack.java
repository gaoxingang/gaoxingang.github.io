/**
 * Project Name:Algorithm
 * File Name:Stack.java
 * Package Name:cn.gxg
 * Date:2019年8月1日下午7:13:12
 * Copyright (c) 2019, Copyright(C) WellTime 2015 All Rights Reserved.
 *
 */

package cn.gxg;

/**
 * ClassName:Stack <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年8月1日 下午7:13:12 <br/>
 * 
 * @author 高新刚
 * @version
 * @since JDK 1.8
 * @see
 */
public class Stack
{
	private Node top = null;

	public void push(int data)
	{
		Node node = new Node(null, data);
		if (top == null)
		{
			top = node;
		}
		else
		{
			node.next = top;
			top = node;
		}

	}

	public int pop()
	{
		if (top == null)
		{
			return -1;
		}
		int data = top.getData();
		top = top.next;
		return data;
	}

	public static class Node
	{
		private Node next;
		private int data;

		public Node(Node node, int data)
		{
			this.next = node;
			this.data = data;
		}

		public int getData()
		{
			return data;
		}
	}
}
