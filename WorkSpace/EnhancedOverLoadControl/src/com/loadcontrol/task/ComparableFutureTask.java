package com.loadcontrol.task;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ComparableFutureTask extends FutureTask implements Comparable{

	private Callable callable; 
	
	public ComparableFutureTask(Callable callable) {
		super(callable);
		this.callable=callable;
	}

	@Override
	public int compareTo(Object o) {
		if(null!=o && o instanceof ComparableFutureTask)
		{
			AbstractInterruptableTask task1= (AbstractInterruptableTask)(this.callable);
			AbstractInterruptableTask task2= (AbstractInterruptableTask)(((ComparableFutureTask)o).callable);
			return task2.getPriority()-task1.getPriority();
		}
		return 0;
	}

}
