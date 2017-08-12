/**
 * 
 */
package com.loadcontrol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import com.loadcontrol.observers.IResourceOverloadObserver;
import com.loadcontrol.observers.ITaskStatusObserver;
import com.loadcontrol.task.ComparableFutureTask;

/**
 * @author Illuminati
 *
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor 
		 {

	private List<ITaskStatusObserver> taskStatusobserverlist = Collections
			.synchronizedList(new ArrayList<ITaskStatusObserver>()); 
	
	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, 10, TimeUnit.SECONDS, workQueue);
		
	}
	
	@Override
	protected void beforeExecute(Thread worker, Runnable ftask) {
		
		for(ITaskStatusObserver taskStatusObserver : taskStatusobserverlist )
		{
			taskStatusObserver.taskStarted((FutureTask<Object>)ftask);
		}
		super.beforeExecute(worker, ftask);
		
		
		
	}
	
	@Override
	protected void afterExecute(Runnable ftask, Throwable exception) {
		
		super.afterExecute(ftask, exception);
		for(ITaskStatusObserver taskStatusObserver : taskStatusobserverlist )
		{
			taskStatusObserver.taskCompleted((FutureTask<Object>)ftask);
		}
		
	}
	
	public void registerStatusObserver(ITaskStatusObserver iTaskStatusObserver)
	{
		taskStatusobserverlist.add(iTaskStatusObserver);
	}
	
	public void deRegisterStatusObserver(ITaskStatusObserver iTaskStatusObserver)
	{
		taskStatusobserverlist.remove(iTaskStatusObserver);
	}
	
	@Override
	protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
		return new ComparableFutureTask(callable);
	}

}
