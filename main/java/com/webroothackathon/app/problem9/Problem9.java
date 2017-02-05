/*
 *	Problem:	Visibility
 *
 *	Each thread in the code below adds one to a shared counter and then
 *	subtracts one from the counter. Since the TestThread run() method controls
 *	execution using a critical section, one would expect that the value of the
 *	counter would be zero at the beginning of each thread's run() method. That
 *	is not the case with the code below.
 *
 *	Change the code so that value of the counter is zero before and after any
 *	thread's run() method is called (e.g. subtraction always immediately
 *	follows addion for the same thread before any other thread's changes the
 *	value of counter.
 *
 *	Note: Do not remove the call to the Thread.sleep() method between the
 *	calls to the add() and sub() methods.
 */

package com.webroothackathon.app.problem9;

/**
 *
 * @author whoever
 */
public class Problem9 {

	static int theCounter = 0;
	static int theCounterMaximum = 0;

	private class TestThread extends Thread {

		Object itsLock = new Object();

		public TestThread()
		{
			run();
		}

		@Override
		public void run()
		{

			synchronized (itsLock) {
				add();

				try {

					Thread.sleep(1);
				}
				catch (Exception error) {

				}

				sub();
			}
		}

        public void add()
		{
			    theCounter += 1;
			if (theCounter > theCounterMaximum) {

				theCounterMaximum = theCounter;
			}
        }

        public void sub()
		{
			    theCounter -= 1;
       }
	}

	public static int maximumCounter()
	{
		Problem9 classObject = new Problem9();

		TestThread threadOne =
			classObject.new TestThread();
		TestThread threadTwo =
			classObject.new TestThread();
		TestThread threadThree =
			classObject.new TestThread();

		try {

			threadOne.join();
			threadTwo.join();
			threadThree.join();
		}
		catch (Exception error) {

			//	whatever ...
		}

		return theCounterMaximum;
	}
    /*
    public static void main(String[] arg) {
        System.out.println(maximumCounter());
    }
    */
}


