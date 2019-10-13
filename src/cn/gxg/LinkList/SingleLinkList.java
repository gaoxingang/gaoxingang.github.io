/**
 * Project Name:Algorithm
 * File Name:MyLinkList.java
 * Package Name:cn.gxg
 * Date:2019年8月1日下午7:12:50
 * Copyright (c) 2019, Copyright(C) WellTime 2015 All Rights Reserved.
 *
 */

package cn.gxg.LinkList;

/**
 * ClassName:MyLinkList <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年8月1日 下午7:12:50 <br/>
 * 
 * @author 高新刚
 * @version
 * @since JDK 1.8
 * @see
 */
public class SingleLinkList
{
	private Node head;

	// 尾部插入
	public void insertTail(int data)
	{
		Node newNode = new Node(null, data);
		if (head == null)
		{
			head = newNode;
		}
		else
		{

			Node temp = head;
			while (temp.next != null)
			{
				temp = temp.next;
			}

			temp.next = newNode;
		}
	}

	// 头部插入
	public void insertHead(int data)
	{
		Node newNode = new Node(null, data);
		if (head == null)
		{
			head = newNode;
		}
		else
		{
			newNode.next = head;
			head = newNode;
		}
	}

	// 值查找返回下标
	public int findByValue(int data)
	{
		int index = -1;
		if (head == null)
		{
			return -1;// 代表没找到
		}
		Node temp = head;
		while (temp.data != data)
		{
			if (temp.next == null)
			{
				return -1;
			}
			temp = temp.next;
			index++;
		}
		return index;
	}

	// 下标查找
	public Node findByIndex(int index)
	{
		Node temp = head;
		int pos = 0;
		while (temp != null && pos != index)
		{
			temp = temp.next;
			pos++;
		}
		return temp;
	}

	// 删除节点
	@SuppressWarnings("unused")
	public void deleteNode(Node deleteNode)
	{
		if (deleteNode == null || head == null)
		{
			return;
		}
		Node temp = head;
		if (temp == deleteNode)
		{
			head = head.next;
		}
		else
		{
			while (temp != null && temp.next != deleteNode)
			{
				temp = temp.next;
			}
			// 最后一个节点也没找到
			if (temp == null)
			{
				return;
			}
			// 这种写法比较保险
			// temp.next=temp.next.next;
			temp.next = deleteNode.next;
		}

	}

	// 通过值删除
	public void deleteNodeByValue(int value)
	{
		if (head == null)
		{
			return;
		}
		if (head.data == value)
		{
			head = head.next;
		}
		else
		{
			Node cruNode = head;
			Node preNode = null;
			while (cruNode != null && cruNode.data != value)
			{
				preNode = cruNode;
				cruNode = cruNode.next;
			}
			if (cruNode == null)
			{
				return;
			}
			preNode.next = cruNode.next;
		}
	}

	/**
	 * 打印链表
	 * 
	 * date: 2019年8月22日 下午4:28:08
	 * 
	 * @author 高新刚
	 * @since JDK 1.8
	 */
	public void printAll()
	{
		Node curNode = head;
		while (curNode != null)
		{
			System.out.print(curNode.data);
			curNode = curNode.next;
		}
	}

	// 后指针变前指针法反转
	public void inverseLinkList()
	{
		if (head == null || head.next == null)
		{
			return;
		}
		Node curNode = head;
		Node nextNode = null;
		Node preNode = null;
		while (curNode != null)
		{
			nextNode = curNode.next;
			curNode.next = preNode;
			preNode = curNode;
			curNode = nextNode;
		}
		head = preNode;
	}
	//头部插入法反转（自创）
	public void inverseLinkListTwo()
	{
		if (head == null || head.next == null)
		{
			return;
		}
		Node curNode = head.next;
		Node nextNode = null;
		head.next=null;
		while (curNode != null)
		{
			nextNode = curNode.next;
			curNode.next = head;
			head = curNode;
			curNode = nextNode;
		}
	}

	// 环检测
	public boolean isHaveLoop(Node headNode)
	{
		if (headNode == null || headNode.next == null)
		{
			return false;
		}
		Node slowNode = headNode;
		Node quickNode = headNode;
		while (slowNode != null && quickNode.next != null)
		{
			slowNode = slowNode.next;
			quickNode = quickNode.next.next;
			if (slowNode == quickNode)
				return true;
		}
		return false;
	}

	// 有序列表合并
	// 链表中间节点
	public static class Node
	{
		private Node next;
		private int data;

		public Node(Node next, int data)
		{
			this.data = data;
			this.next = next;
		}

		public int getData(Node node)
		{
			return node.data;
		}
	}

	public static void main(String[] args)
	{
		SingleLinkList singleLinkList = new SingleLinkList();
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		for (int i : arr)
		{
			singleLinkList.insertTail(i);
		}
		//singleLinkList.inverseLinkList();
		singleLinkList.inverseLinkListTwo();
		singleLinkList.printAll();
	}
}
