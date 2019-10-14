/**
 * Project Name:Algorithm
 * File Name:ThreadSample.java
 * Package Name:cn.gxg
 * Date:2019年8月23日下午5:01:55
 * Copyright (c) 2019, Copyright(C) WellTime 2015 All Rights Reserved.
 *
 */

package cn.gxg;


/**
 * ClassName:ThreadSample <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年8月23日 下午5:01:55 <br/>
 * 
 * @author 高新刚
 * @version
 * @since JDK 1.8
 * @see
 */
public class ThreadSample extends Thread
{
	private String first;
	private String second;
	public ThreadSample(String name, String first, String second)
	{
		super(name);
		this.first = first;
		this.second = second;
	}

	public void run()
	{
		synchronized (first)
		{
			System.out.println(this.getName() + "obtain:" + first);
			try
			{
				Thread.sleep(1000L);
				synchronized (second)
				{
					System.out.println(this.getName() + "obtain:" + second);
				}
			}
			catch (Exception e)
			{
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		String lockA = "lockA";
		String lockB = "lockB";
		ThreadSample threadSampleA = new ThreadSample("Thread1", lockA, lockB);
		ThreadSample threadSampleB = new ThreadSample("Thread2", lockB, lockA);
		threadSampleA.start();
		threadSampleB.start();
		threadSampleA.join();
		threadSampleB.join();
	}
}
