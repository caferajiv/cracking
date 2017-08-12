package com.rajiv.loadcontrol.sensors.impl;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.rajiv.loadcontrol.ResourceMonitor;
import com.rajiv.loadcontrol.sensors.IResourceSensor;

public class MemoryResourceSensor implements IResourceSensor {

	private ScheduledExecutorService scheduler;
	@Override
	public void start() {
		scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.scheduleWithFixedDelay(new MemoryMonitorThread(9.0F,15.0F),0L,5L, TimeUnit.SECONDS);
	}

	@Override
	public void shutdown() {
		scheduler.shutdown();
	}
	
	private static class MemoryMonitorThread implements Runnable
	{

		private float interruptMemoryThreshold;
		private float executionMemoryThreshold;
		private MemoryMXBean memoryMxBean = ManagementFactory.getMemoryMXBean();
		//private boolean isRectified = false;
		private static ResourceMonitor resourceMonitor = ResourceMonitor.getInstance();
		
		private double usedMemoryInPercent;
		
		private boolean gcRan=false;
		
		public MemoryMonitorThread(float executionMemoryThreshold,
				float interruptMemoryThreshold) {

			this.interruptMemoryThreshold=interruptMemoryThreshold;
			this.executionMemoryThreshold=executionMemoryThreshold;
		}
		@Override
		public void run() {
			
			if(isMemoryExceeded(interruptMemoryThreshold))
			{
				//isRectified=false;
				//Notify both Recovery and Overload observers
				resourceMonitor.notifyOnRecoveryEvent();
				
				resourceMonitor.notifyOnOverLoadEvent();
				Runtime.getRuntime().gc();
				
			}
			else if(isMemoryExceeded(executionMemoryThreshold))
			{
				//isRectified=false;
				//Notify only Overload observers 
				//and set flag that notRectified
				resourceMonitor.notifyOnOverLoadEvent();
			}
			else
			{
				//isRectified=true;
				//Notify overloadrectification obsever
				//and set flag that rectified
				resourceMonitor.notifyOnOverLoadRectificationEvent();
			}
			
		}
		
		private boolean isMemoryExceeded(float value)
 {
			MemoryUsage memoryUsage = memoryMxBean.getHeapMemoryUsage();
			long usedMemory = memoryUsage.getUsed();
			long totalMemory = Runtime.getRuntime().totalMemory();

			usedMemoryInPercent = ((double) usedMemory / totalMemory) * 100;

			//String formattedUsedMemory = String.format("%.2",
				//	usedMemoryInPercent);
			System.out.println();
			System.out.println("Total Memory :"+totalMemory+" Used Memory :"+usedMemory);
			System.out.println("Pecentage used :"+usedMemoryInPercent+" Threshold :"+value);

			if (usedMemoryInPercent > value) {
				System.out.println("Memory exceeded threshold :"+value);
				return true;
			}

			System.out.println("Memory not exceeded threshold "+value);
			return false;

		}
	}
	
public static void main(String[] args) {
	MemoryMXBean memoryMxBean = ManagementFactory.getMemoryMXBean();
	MemoryUsage memoryUsage=memoryMxBean.getHeapMemoryUsage();
	long usedMemory=memoryUsage.getUsed();
	long totalMemory=Runtime.getRuntime().totalMemory();
	
	double usedMemoryInPercent= ((double)usedMemory/totalMemory)*100;
	
	String formattedUsedMemory = String.format("%.2f", usedMemoryInPercent);
	System.out.println(usedMemory);
	System.out.println(totalMemory);
	
	System.out.println(usedMemoryInPercent+"   "+formattedUsedMemory);
}

}


