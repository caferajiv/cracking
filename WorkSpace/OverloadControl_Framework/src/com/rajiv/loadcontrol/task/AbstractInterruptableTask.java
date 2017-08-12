package com.rajiv.loadcontrol.task;

import java.util.concurrent.Callable;

public abstract class AbstractInterruptableTask implements Callable<Object>{
	
	private long timeOut = -1;
	
	private long timeOfSubmit;
	
	private int priority=5;
	
	public abstract void interrupt();
	
	public abstract String getTaskType();
	
	public long getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(long timeOut) {
		this.timeOut = timeOut;
	}

	/**
	 * @return the timeOfSubmit
	 */
	public long getTimeOfSubmit() {
		return timeOfSubmit;
	}

	/**
	 * @param timeOfSubmit the timeOfSubmit to set
	 */
	public void setTimeOfSubmit(long timeOfSubmit) {
		this.timeOfSubmit = timeOfSubmit;
	}
	
	public static enum Priority{
		PRIORITY_1(1),
		PRIORITY_2(2),
		PRIORITY_3(3),
		PRIORITY_4(4),
		PRIORITY_5(5),
		PRIORITY_6(6),
		PRIORITY_7(7),
		PRIORITY_8(8),
		PRIORITY_9(9);
		
		private int value;
		Priority(int value)
		{
			this.value=value;
		}
		
	}
	
	
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Priority priority) {
		this.priority = priority.value;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	
	
	
}


