/**
 * Project Name:Algorithm
 * File Name:Search.java
 * Package Name:cn.gxg
 * Date:2019��8��5������5:54:51
 * Copyright (c) 2019, Copyright(C) WellTime 2015 All Rights Reserved.
 *
 */

package cn.gxg;

/**
 * ClassName:Search <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019��8��5�� ����5:54:51 <br/>
 * 
 * @author ���¸�
 * @version
 * @since JDK 1.8
 * @see
 */
public class Search
{
	/**
	 * ���ַ�����
	 *
	 * date: 2019��8��5�� ����6:18:30
	 * 
	 * @author ���¸�
	 * @param data
	 * @param value
	 * @return
	 * @since JDK 1.8
	 */
	public static int binarySearch(int[] data, int value)
	{
		int low = 0;
		int high = data.length;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			if (data[mid] == value)
			{
				return mid;
			}
			if (data[mid] > value)
			{
				high = mid - 1;
			}
			if (data[mid] < value)
			{
				low = mid + 1;
			}
		}

		return -1;
	}

	/**
	 * ���ҵ�һ������������ֵ
	 * 
	 * date: 2019��8��5�� ����6:41:16
	 * 
	 * @author ���¸�
	 * @param data
	 * @param value
	 * @return
	 * @since JDK 1.8
	 */
	public static int binarySearchFirst(int[] data, int value)
	{
		int low = 0;
		int high = data.length;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;

			if (data[mid] > value)
			{
				high = mid - 1;
			}
			else if (data[mid] < value)
			{
				low = mid + 1;
			}
			else
			{
				if (mid == 0 || data[mid - 1] != value)
				{
					return mid;
				}
				else
				{
					high = mid - 1;
				}
			}
		}

		return -1;
	}

	/**
	 * ���ַ��������һ������������ֵ
	 * 
	 * date: 2019��8��5�� ����7:30:52
	 * 
	 * @author ���¸�
	 * @param data
	 * @param value
	 * @return
	 * @since JDK 1.8
	 */
	public static int binarySearchLast(int[] data, int value)
	{
		int low = 0;
		int high = data.length;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;

			if (data[mid] > value)
			{
				high = mid - 1;
			}
			else if (data[mid] < value)
			{
				low = mid + 1;
			}
			else
			{
				if (mid == data.length || data[mid + 1] != value)
				{
					return mid;
				}
				else
				{
					low = mid + 1;
				}
			}
		}

		return -1;
	}

	/**
	 * �������һ������ĳ��ֵ
	 * 
	 * date: 2019��8��5�� ����7:32:51
	 * 
	 * @author ���¸�
	 * @param data
	 * @param value
	 * @return
	 * @since JDK 1.8
	 */
	public static int binarySearchLastSmall(int[] data, int value)
	{
		int low = 0;
		int high = data.length;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;

			if (data[mid] < value)
			{
				low = mid + 1;
			}
			else
			{
				if (mid == 0 || data[mid - 1] < value)
				{
					return mid - 1;
				}
				else
				{
					high = mid - 1;
				}
			}
		}

		return -1;
	}

	/**
	 * ���ҵ�һ������ĳ��ֵ������
	 * 
	 * date: 2019��8��5�� ����7:33:48
	 * 
	 * @author ���¸�
	 * @param data
	 * @param value
	 * @return
	 * @since JDK 1.8
	 */
	public static int binarySearchFirstBig(int[] data, int value)
	{
		int low = 0;
		int high = data.length;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;

			if (data[mid] > value)
			{
				high = mid - 1;
			}
			else
			{
				if (mid == data.length - 1 || data[mid + 1] > value)
				{
					return mid + 1;
				}
				else
				{
					low = mid + 1;
				}
			}
		}

		return -1;
	}
}
