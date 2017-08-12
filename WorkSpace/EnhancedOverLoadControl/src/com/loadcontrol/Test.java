package com.loadcontrol;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.loadcontrol.exceptions.IllegalQueueStateException;
import com.loadcontrol.task.AbstractInterruptableTask;

public class Test {
	private static ScheduledExecutorService scheduler= Executors.newSingleThreadScheduledExecutor();
	private static Thread t = new Thread(new Runnable(){
    
		@Override
		public void run() {
			for(int i=0; i<40;i++)
			{
				long[] l = new long[1024*1024*1024];
			}
			Runtime.getRuntime().gc();
		}
		
	});

	public static void main(String[] args) {
		LoadController loadController = LoadController.getInstance();
		loadController.registerModule("Analyzer", 20, 3, 3);
		for (int i = 1; i <= 30; i++) {
			try {
				loadController.submit(createTask(i));
				System.out.println("Task submitted :" + i);
			} catch (IllegalQueueStateException ie) {
				System.out.println("Queue is Full");
			}
		}
		
		scheduler.scheduleWithFixedDelay(t, 10, 5, TimeUnit.SECONDS);
	}
	public static MyTask createTask(int i)
	{
		return new MyTask(i);
		
	}
	
	private static class MyTask extends AbstractInterruptableTask
	 {

		private int taskId;
		
		public MyTask(int taskId)
		{
			this.taskId=taskId;
		}
		
		@Override
		public Object call() throws Exception {
			try {
				for (int i = 0; i < 100; i++) {
					System.out
							.println("Task " + taskId + "running count :" + i);
					try
					{
					Thread.sleep(1000);
					}catch(InterruptedException ie)
					{
					System.out.println("-------------------Task Interrupted because of high memory------------------------");
					return "Task Interrupted because of high memory";
					}
				}
			} catch (Exception e) {
				System.out.println("Task Interrupted :" + taskId);
				return "Interrupted";
			}
			return "Done";
		}

		@Override
		public void interrupt() {
			
			System.out.println("Task Interrupted :" + taskId);
		}

		@Override
		public String getTaskType() {
			
			return "Analyzer";
		}
		
		public long getTimeOut() {
			return 600;
		}
	}

}

