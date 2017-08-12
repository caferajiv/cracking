package com.loadcontrol.observers;

import java.util.concurrent.Future;


public interface ITaskStatusObserver {
	
	public void taskStarted(Future<Object> future);
	
	public void taskCompleted(Future<Object> future);
	
	public void taskCancelled(Future<Object> future);
	

}
