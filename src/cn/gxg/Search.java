/**
 * Project Name:Algorithm
 * File Name:Search.java
 * Package Name:cn.gxg
 * Date:2019年8月5日下午5:54:51
 * Copyright (c) 2019, Copyright(C) WellTime 2015 All Rights Reserved.
 *
 */

package cn.gxg;

/**
 * ClassName:Search <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年8月5日 下午5:54:51 <br/>
 * 
 * @author 高新刚
 * @version
 * @since JDK 1.8
 * @see
 */
public class Search
{
	/**
	 * 二分法查找
	 *
	 * date: 2019年8月5日 下午6:18:30
	 * 
	 * @author 高新刚
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
	 * 查找第一个符合条件的值
	 * 
	 * date: 2019年8月5日 下午6:41:16
	 * 
	 * @author 高新刚
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
	 * 二分法查找最后一个符合条件的值
	 * 
	 * date: 2019年8月5日 下午7:30:52
	 * 
	 * @author 高新刚
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
	 * 查找最后一个大于某个值
	 * 
	 * date: 2019年8月5日 下午7:32:51
	 * 
	 * @author 高新刚
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
	 * 查找第一个大于某个值的数字
	 * 
	 * date: 2019年8月5日 下午7:33:48
	 * 
	 * @author 高新刚
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
