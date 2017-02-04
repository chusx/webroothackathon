/**
 *	Problem: Why Wait
 *
 *	The class below implements a simple polling based producer - consumer
 *	demonstration. In this demonstration, the producer must finish producing
 *	product before the consumer can consume it.
 *
 *	The demonstration starts with the producer producing products and the
 *	consumer periodicly checking whether the producer is still producing
 *	product.
 *
 *	Change the Producer and Consumer classes so that the consumer doesn't have
 *	to waste its time checking the producer for product. Do not change code
 *	that is not part of the Producer or Consumer classes and do not move the
 *	two statements that collect times.
 */

package com.webroothackathon.app.problem15;

import java.util.LinkedList;
import java.util.List;

public class Problem15 {

	private static long theConsumptionStartedTime = 0;
	private static long theProductionStoppedTime = 0;

	public class Producer implements Runnable {

		List<Integer> itsProduct;
		boolean itsProductionInProcess;

		Producer()
		{
			itsProduct = new LinkedList<Integer>();
			itsProductionInProcess = true;
		}

		@Override
		public void run()
		{
			for (int index = 1; index <= 10; index++) {

				itsProduct.add(index);

				try {

					Thread.sleep(1000);
				}
				catch (InterruptedException error) {

					error.printStackTrace();
				}
			}

			theProductionStoppedTime += System.nanoTime();
			itsProductionInProcess = false;
		}
	}

	public class Consumer extends Thread {

		Producer itsProducer;

		Consumer(Producer aProducer)
		{
			itsProducer = aProducer;
		}

		public void run()
		{
			while (itsProducer.itsProductionInProcess) {

				try {

					Thread.sleep(4000);
				}
				catch(Exception error) {

					error.printStackTrace();
				}
			}

			theConsumptionStartedTime += System.nanoTime();

			int productSize = itsProducer.itsProduct.size();
			for (int index = 0; index < productSize; index++) {

				itsProducer.itsProduct.remove(0);
			}
		}
	}

	public static long produceAndConsume()
	{
		Problem15 program = new Problem15();

		Producer producer = program.new Producer();
		Consumer consumer = program.new Consumer(producer);

		long elapsedTime = 0;

		try {

			Thread producerThread = new Thread(producer, "Producer Thread");
			Thread consumerThread = new Thread(consumer, "Consumer Thread");

			producerThread.start();
			consumerThread.start();

			producerThread.join();
			consumerThread.join();

			elapsedTime =
				(theConsumptionStartedTime - theProductionStoppedTime) /
					1000000;
		}
		catch(Exception error) {

			error.printStackTrace();
		}

		return elapsedTime;
	}
}
