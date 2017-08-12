/**
 * 
 */
package com.rajiv.loadcontrol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

import com.rajiv.loadcontrol.exceptions.IllegalQueueStateException;
import com.rajiv.loadcontrol.observers.IResourceRecoveryObserver;
import com.rajiv.loadcontrol.observers.ITaskStatusObserver;
import com.rajiv.loadcontrol.observers.impl.MemoryResourceObserverImpl;
import com.rajiv.loadcontrol.task.AbstractInterruptableTask;
import com.rajiv.loadcontrol.task.FutureWrapper;
import com.rajiv.loadcontrol.task.InterruptableTaskWrapper;

/**
 * @author Illuminati
 *
 */
public class LoadController implements ITaskStatusObserver , IResourceRecoveryObserver{

	private static LoadController loadController;

	private List<Future<Object>> currentlyExecutingTaskList = Collections
			.synchronizedList(new ArrayList<Future<Object>>());
	private Map<Future<Object>, FutureWrapper> submittedTasksMap = Collections
			.synchronizedMap(new HashMap<Future<Object>, FutureWrapper>());
	
	private Map<String, MyThreadPoolExecutor> threadPoolsMap = Collections
			.synchronizedMap(new HashMap<String, MyThreadPoolExecutor>());

	private LoadController() {
		// Do Nothing Singleton
	}

	public static LoadController getInstance() {
		if (null == loadController) {
			synchronized (LoadController.class) {
				if (null == loadController) {
					loadController = new LoadController();
					ResourceMonitor.getInstance().registerRecoveryObserver(
							loadController);
					ResourceMonitor.startSensors();
					ResourceMonitor.getInstance().registerOverloadObserver
					(MemoryResourceObserverImpl.getInstance());
				}
			}
		}
		return loadController;

	}

	public void registerModule(String moduleName, int queueSize,
			int corePoolSize, int maxPoolSize) {

		if (threadPoolsMap.containsKey(moduleName)) {
			System.out.println("Module already registered");
			return;
		}
		ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(
				queueSize);
		MyThreadPoolExecutor threadPoolExecutor = new MyThreadPoolExecutor(
				corePoolSize, maxPoolSize, queue);
		threadPoolExecutor.registerStatusObserver(this);
		threadPoolsMap.put(moduleName, threadPoolExecutor);

	}

	@SuppressWarnings("unchecked")
	public FutureWrapper submit(AbstractInterruptableTask task)
	{
		InterruptableTaskWrapper taskWrapper = new InterruptableTaskWrapper(task);
		MyThreadPoolExecutor threadPoolExecutor = threadPoolsMap.get(taskWrapper.getTask()
				.getTaskType());
		taskWrapper.getTask().setTimeOfSubmit(System.currentTimeMillis());
		Future<Object> future=null;
		try 
		{
			future = threadPoolExecutor.submit(taskWrapper);
		} 
		catch (RejectedExecutionException e) 
		{
			throw new IllegalQueueStateException("Queue is Full");
		}
		catch(Exception e)
		{
			throw new IllegalQueueStateException("Illegal Queue State");
		}
		FutureWrapper fWrapper = new FutureWrapper(taskWrapper, future);
		if (!(taskWrapper.getTask().getTimeOut() < 0)) {
			fWrapper.runTimer();
		}
		submittedTasksMap.put(future, fWrapper);
		return fWrapper;
	}

	@Override
	public void taskStarted(Future<Object> future) {
		currentlyExecutingTaskList.add(future);
		
	}
	@Override
	public void taskCompleted(Future<Object> future) {
		
		currentlyExecutingTaskList.remove(future);
		submittedTasksMap.remove(future);
		
	}

	@Override
	public void taskCancelled(Future<Object> future) {
		//submittedTasksMap.get(key)
		
	}

	@Override
	public void performActionOnRecoveryEvent() {
		synchronized (this) {

			for (Future<Object> future : currentlyExecutingTaskList) {
				submittedTasksMap.get(future).cancelTask();
				submittedTasksMap.remove(future);
			}
			// currentlyExecutingTaskList.clear();
		}
	}
	
	public void deRegisterModule(String moduleName)
	{
		threadPoolsMap.remove(moduleName);
	}

	public void cancelTaskOnTimeOut(FutureWrapper futureWrapper) {
		
		if(submittedTasksMap.containsKey(futureWrapper.getFuture()) && 
				!currentlyExecutingTaskList.contains(futureWrapper.getFuture())){
			removeTaskFromQueue(futureWrapper);
		}
		if(currentlyExecutingTaskList.contains(futureWrapper.getFuture()))
			{
			 InterruptableTaskWrapper taskWrapper = futureWrapper.getTaskWrapper();
			 if(taskWrapper.isTimedOut() && taskWrapper.isWaiting())
			 {
				 removeTaskFromQueue(futureWrapper);
				
			 }
			}
		
		
	}

	private void removeTaskFromQueue(FutureWrapper futureWrapper) {
		System.out.println("Task timed-out, Task will be cancelled and removed from the Queue");
		submittedTasksMap.get(futureWrapper.getFuture()).cancelTask();
		submittedTasksMap.remove(futureWrapper.getFuture());
		threadPoolsMap.get(futureWrapper.getTaskWrapper().getTask().getTaskType()).purge();
	}
	

}
