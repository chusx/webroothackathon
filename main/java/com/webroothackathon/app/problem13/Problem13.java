/*
 *	Problem:	Thread Problem
 *
 *	The getName() method below generates the name "KongKing". Without changing
 *	the order of the statements in the getName() method try block, change
 *	getName() so that it reverses the words.
 */

package com.webroothackathon.app.problem13;

/**
 *
 *	@author whoever
 */
public class Problem13 {

	private static String theName = "";
	private static Object theLock = new Object();;

	private static void appendName(String aName)
	{
		synchronized (theLock) {

			theName += aName;
		}
	}

	private static synchronized void kong()
	{
		appendName("Kong");
	}

	public static String getName()
	{
		Thread thread = new Thread() {

			public void run()
			{
				kong();
			}
		};

        thread.setPriority(Thread.NORM_PRIORITY - 1);

		try {

			thread.start();
			appendName("King");
			thread.join();
		}
		catch (Exception error) {

			System.out.printf(
				"%s (%d): ",
				Thread.currentThread().getName(),
				Thread.currentThread().getId());
			System.out.println(error.getMessage());
		}

		return theName;
	}
}
