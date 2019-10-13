/**
 * Project Name:Algorithm
 * File Name:MyLinkList.java
 * Package Name:cn.gxg
 * Date:2019��8��1������7:12:50
 * Copyright (c) 2019, Copyright(C) WellTime 2015 All Rights Reserved.
 *
 */

package cn.gxg.LinkList;

/**
 * ClassName:MyLinkList <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019��8��1�� ����7:12:50 <br/>
 * 
 * @author ���¸�
 * @version
 * @since JDK 1.8
 * @see
 */
public class SingleLinkList
{
	private Node head;

	// β������
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

	// ͷ������
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

	// ֵ���ҷ����±�
	public int findByValue(int data)
	{
		int index = -1;
		if (head == null)
		{
			return -1;// ����û�ҵ�
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

	// �±����
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

	// ɾ���ڵ�
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
			// ���һ���ڵ�Ҳû�ҵ�
			if (temp == null)
			{
				return;
			}
			// ����д���Ƚϱ���
			// temp.next=temp.next.next;
			temp.next = deleteNode.next;
		}

	}

	// ͨ��ֵɾ��
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
	 * ��ӡ����
	 * 
	 * date: 2019��8��22�� ����4:28:08
	 * 
	 * @author ���¸�
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

	// ��ָ���ǰָ�뷨��ת
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
	//ͷ�����뷨��ת���Դ���
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

	// �����
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

	// �����б�ϲ�
	// �����м�ڵ�
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
