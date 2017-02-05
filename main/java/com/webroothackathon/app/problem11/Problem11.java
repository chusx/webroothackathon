/*
 *	Problem:
 *
 *	The class below creates three threads that execute the Demo class test()
 *	method (representing the work done by each thread). As currently written,
 *	the work consists of appending an index to an index tracker.
 *
 *	The index tracker determines whether or not the work is done concurrently.
 *	When the longest run of consecutive indexes is equal to the number in the
 *	Demo class test() method, then no concurrent work is being done.
 *
 *	When executed, the indexes proceed as 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0,
 *	1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, indicating that
 *	the threads are doing the work sequentially.
 *
 *	Change the TestThread and Demo classes so that each thread performs the
 *	work concurrently.
 */

package com.webroothackathon.app.problem11;

import java.util.*;

/**
 *
 *	@author whoever
 */
public class Problem11 {

	private static final Object theTrackerLock = new Object();
	private static IndexTracker theTracker = null;

	private class IndexTracker {

		private int itsPreviousIndex = -2;
		private int itsConsecutiveIndexes = 0;
		private int itsLongestRun = 0;

		public void addIndex(int index)
		{
			if ((index - itsPreviousIndex) == 1) {

				itsConsecutiveIndexes += 1;
				if (itsConsecutiveIndexes > itsLongestRun) {

					itsLongestRun = itsConsecutiveIndexes;
				}
			}
			else {

				itsConsecutiveIndexes = 0;
			}

			itsPreviousIndex = index;
		}

		public int longestRun()
		{
			return itsLongestRun;
		}
	}

	public static void trackIndex(int index)
	{
		synchronized (theTrackerLock) {

			theTracker.addIndex(index);
		}
	}

	private class TestThread extends Thread {

		Demo itsDemo;

		public TestThread(Demo aDemo)
		{
			itsDemo = aDemo;
			start();
		}

		@Override
		public void run()
		{
			itsDemo.test();
		}
	}

	private class Demo {

		public void test()
		{
			for (int i = 0; i < 10; i++) {

				trackIndex(i);

				try {

					Thread.sleep(50);
				}
				catch (Exception error) {

					System.out.println(error.getMessage());
				}
			}
		}
	}

	public static boolean checkSynchronized()
	{
		try {

			Problem11 classObject = new Problem11();
			Problem11.Demo theDemo = classObject.new Demo();

			theTracker = classObject.new IndexTracker();

			TestThread threadOne = classObject.new TestThread(theDemo);
			TestThread threadTwo = classObject.new TestThread(theDemo);
			TestThread threadThree = classObject.new TestThread(theDemo);

			threadOne.join();
			threadTwo.join();
			threadThree.join();
		}
		catch (Exception error) {

			System.out.println(error.getMessage());
		}

		if (theTracker.longestRun() == 9) {

			return true;
		}
		else {

			return false;
		}
	}
    /*
    public static void main(String[] argv) {
        System.out.println(checkSynchronized());
    }
    */
}
