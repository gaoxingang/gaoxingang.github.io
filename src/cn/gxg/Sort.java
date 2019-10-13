/**
 * Project Name:Algorithm
 * File Name:Sort.java
 * Package Name:cn.gxg
 * Date:2019��8��1������5:37:01
 * Copyright (c) 2019, Copyright(C) WellTime 2015 All Rights Reserved.
 *
 */

package cn.gxg;

import java.util.Arrays;

/**
 * ClassName:Sort <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019��8��1�� ����5:37:01 <br/>
 * 
 * @author ���¸�
 * @version
 * @since JDK 1.8
 * @see
 */
public class Sort
{

	/**
	 * ��������
	 * 
	 * date: 2019��8��5�� ����5:06:00
	 * 
	 * @author ���¸�
	 * @param data
	 * @return
	 * @since JDK 1.8
	 */
	public static int[] countSort(int[] data)
	{
		// �ҵ����ֵ
		int maxValue = 0;
		for (int i = 0; i < data.length; i++)
		{
			if (data[i] > maxValue)
			{
				maxValue = data[i];
			}
		}
		// ��������Ͱ
		int[] arrCount = new int[maxValue + 1];
		for (int i = 0; i < arrCount.length; i++)
		{
			arrCount[i] = 0;
		}
		// ���ÿ��ֵ����
		for (int i = 0; i < data.length; i++)
		{
			arrCount[data[i]]++;
		}
		// �������
		for (int i = 0; i < arrCount.length - 1; i++)
		{
			arrCount[i + 1] = arrCount[i] + arrCount[i + 1];
		}
		int[] arrReturn = new int[data.length];
		for (int i = data.length - 1; i >= 0; i--)
		{
			arrReturn[arrCount[data[i]] - 1] = data[i];
			arrCount[data[i]]--;
		}
		return arrReturn;
	}

	/**
	 * ��������
	 * 
	 * date: 2019��8��5�� ����2:56:21
	 * 
	 * @author ���¸�
	 * @param data
	 * @since JDK 1.8
	 */
	public static void quickSort(int[] data)
	{
		quickSortCore(data, 0, data.length - 1);
	}

	public static void quickSortCore(int[] data, int leftIndex, int rightIndex)
	{
		if (leftIndex >= rightIndex)
			return;
		int pivot = partition(data, leftIndex, rightIndex);
		quickSortCore(data, leftIndex, pivot - 1);
		quickSortCore(data, pivot + 1, rightIndex);
	}

	public static int partition(int[] data, int leftIndex, int rightIndex)
	{
		int pivotValue = data[leftIndex];

		while (leftIndex < rightIndex)
		{
			while (leftIndex < rightIndex && pivotValue <= data[rightIndex])
			{
				--rightIndex;
			}
			data[leftIndex] = data[rightIndex];
			while (leftIndex < rightIndex && pivotValue >= data[leftIndex])
			{
				++leftIndex;
			}
			data[rightIndex] = data[leftIndex];
		}
		data[leftIndex] = pivotValue;
		Util.printArray(data);
		return leftIndex;
	}

	/**
	 * �鲢���� �ȶ������㷨
	 * 
	 * ʱ�临�Ӷȣ�O(nlogn) date: 2019��8��5�� ����11:19:15
	 * 
	 * @author ���¸�
	 * @param data
	 * @since JDK 1.8
	 */
	public static void mergeSort(int[] data)
	{
		mergeSortCore(data, 0, data.length);
	}

	/**
	 * �鲢����ݹ鷽��
	 * 
	 * date: 2019��8��5�� ����11:24:20
	 * 
	 * @author ���¸�
	 * @param data
	 * @param front
	 * @param end
	 * @since JDK 1.8
	 */
	private static void mergeSortCore(int[] data, int front, int end)
	{
		if (end - front < 2)
		{
			return;
		}
		int mid = (front + end) / 2;
		mergeSortCore(data, front, mid);
		mergeSortCore(data, mid, end);
		merge(data, front, mid, end);
	}

	/**
	 * �鲢�����еĺϲ�����
	 * 
	 * date: 2019��8��5�� ����11:24:52
	 * 
	 * @author ���¸�
	 * @param data
	 * @param front
	 * @param mid
	 *            �û��ָ�����
	 * @param end
	 * @since JDK 1.8
	 */
	private static void merge(int[] data, int front, int mid, int end)
	{
		int[] leftArr = Arrays.copyOfRange(data, front, mid);
		int[] rightArr = Arrays.copyOfRange(data, mid, end);
		int indexLeft = 0;
		int indexRight = 0;
		int i = front;
		for (; i <= end; i++)
		{
			// ����������Ҳ�����һ���Ѿ�ȫ�����꣬ʣ�����һ��Ͳ���ѭ��������
			if (rightArr.length - 1 < indexRight || leftArr.length - 1 < indexLeft)
			{
				break;
			}
			if (leftArr[indexLeft] < rightArr[indexRight])
			{
				data[i] = leftArr[indexLeft];
				indexLeft++;

			}
			else
			{
				data[i] = rightArr[indexRight];
				indexRight++;
			}
		}
		if (leftArr.length - 1 >= indexLeft)
		{
			for (int j = indexLeft; j < leftArr.length; j++)
			{
				data[i] = leftArr[j];
				i++;
			}

		}
		if (rightArr.length - 1 >= indexRight)
		{
			for (int j = indexRight; j < rightArr.length; j++)
			{
				data[i] = rightArr[j];
				i++;
			}
		}
		Util.printArray(data);
	}

	/**
	 * ð������
	 * 
	 * date: 2019��8��2�� ����4:52:57
	 * 
	 * @author ���¸�
	 * @param data
	 * @param length
	 * @since JDK 1.8
	 */
	public static void bubbleSort(int[] data, int length)
	{
		if (length <= 0)
			return;
		int temp = 0;
		for (int i = 0; i < length; i++)
		{
			for (int j = i + 1; j < length; j++)
			{
				if (data[j] < data[i])
				{
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}

	/**
	 * ��������
	 * 
	 * date: 2019��8��2�� ����4:52:57
	 * 
	 * @author ���¸�
	 * @param data
	 * @param length
	 * @since JDK 1.8
	 */
	public static void insertSort(int[] data, int length)
	{
		if (length <= 1)
		{
			return;
		}
		int temp = 0;
		for (int i = 1; i < length; i++)
		{
			temp = data[i];
			int j = i - 1;
			for (; j >= 0; j--)
			{
				if (data[j] > temp)
				{
					data[j + 1] = data[j];
				}
				else
				{
					break;
				}
			}
			data[j + 1] = temp;
		}
	}

	/**
	 * �����������˼·�Ƚ�˳ ԭ�������������ȶ��ģ�ʱ�临�Ӷ�
	 * 
	 * date: 2019��8��1�� ����7:20:04
	 * 
	 * @author ���¸�
	 * @param data
	 * @since JDK 1.8
	 */
	public static void insertSort(int[] data)
	{
		if (data.length <= 1)
		{
			return;
		}
		for (int i = 1; i < data.length; i++)
		{
			int temp = data[i];
			for (int j = i - 1; j >= 0; j--)
			{
				if (data[j] > temp)
				{
					data[j + 1] = data[j];
					data[j] = temp;
				}
				else
				{
					break;
				}
			}
		}
	}
}
