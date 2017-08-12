package com.loadcontrol.observers.impl;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import com.loadcontrol.observers.IResourceOverloadObserver;

public class MemoryResourceObserverImpl implements IResourceOverloadObserver{
	
	private boolean canTaskExecute=true;
	
	private static MemoryResourceObserverImpl memoryResourceObserverImpl = new MemoryResourceObserverImpl();
	
	private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(); 
	
	private ReadLock readCanExecute = readWriteLock.readLock();
	
	private WriteLock writeCanExecute = readWriteLock.writeLock();
	
	private MemoryResourceObserverImpl()
	{
		
	}
	
	public static MemoryResourceObserverImpl getInstance()
	{
		return memoryResourceObserverImpl;
	}

	@Override
	public void performActionOnOverloadEvent() {
		System.out
				.println("Memory usage exceeded than Execution " +
						"threshold Task cannot execute");
		setCanTaskExecute(false);
		
	}

	@Override
	public void performActionOnOverloadRectificationEvent() {
		synchronized (this) 
		{
			System.out
			.println("Memory usage rectified Task may execute");
			setCanTaskExecute(true);
			notifyAll();
		}
		
	}
	
	/**
	 * @return the canTaskExecute
	 */
	public boolean isCanTaskExecute() {
		readCanExecute.lock();
		try {
			return canTaskExecute;
		} finally {
			readCanExecute.unlock();
		}
	}

	/**
	 * @param canTaskExecute the canTaskExecute to set
	 */
	public void setCanTaskExecute(boolean canTaskExecute) {
		writeCanExecute.lock();
		this.canTaskExecute = canTaskExecute;
		writeCanExecute.unlock();
	}

}
