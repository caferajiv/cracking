package com.loadcontrol.task;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import com.loadcontrol.ResourceMonitor;
import com.loadcontrol.observers.IResourceOverloadObserver;
import com.loadcontrol.observers.impl.MemoryResourceObserverImpl;

public class InterruptableTaskWrapper implements Callable {

	private AbstractInterruptableTask task;
	
	private MemoryResourceObserverImpl memoryResourceObserverImpl = MemoryResourceObserverImpl.getInstance();

	private boolean isWaiting;
	
	private boolean isTimedOut;
	
	public InterruptableTaskWrapper(AbstractInterruptableTask task)
	{
		this.task=task;
	}
	
	@Override
	public Object call() throws Exception {

		synchronized (memoryResourceObserverImpl) {
			while (!memoryResourceObserverImpl.isCanTaskExecute()) {
				if (!isTimedOut) {
					wait();
				} else {
					isWaiting = true;
					notifyAll();
					break;
				}
			}

		}
		return task.call();
	}

	/**
	 * @return the task
	 */
	public AbstractInterruptableTask getTask() {
		return task;
	}
	
	/**
	 * @return the isWaiting
	 */
	public boolean isWaiting() {
		return isWaiting;
	}

	/**
	 * @param isWaiting the isWaiting to set
	 */
	public void setWaiting(boolean isWaiting) {
		this.isWaiting = isWaiting;
	}

	/**
	 * @return the isTimedOut
	 */
	public boolean isTimedOut() {
		return isTimedOut;
	}

	/**
	 * @param isTimedOut the isTimedOut to set
	 */
	public void setTimedOut(boolean isTimedOut) {
		this.isTimedOut = isTimedOut;
	}


}
