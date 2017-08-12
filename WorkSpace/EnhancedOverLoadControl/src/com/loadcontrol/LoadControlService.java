package com.loadcontrol;

import java.util.concurrent.FutureTask;

import com.loadcontrol.task.InterruptibleTask;

/**
 * Load Control Service 
 * Enables modules to 
 * register themselves
 * deregister themselves
 * submit tasks
 * @author Illuminati
 *
 */
public interface LoadControlService {
	
	/**
	 * 
	 * @param moduleName
	 * @return
	 */
	public boolean registerModule(String moduleName, int queueSize, int minConcurrentTasks, int maxConcurrentTasks);
	/**
	 * 
	 * @param moduleName
	 * @return
	 */
	public boolean deregisterModule(String moduleName);
	
	/**
	 * 
	 * @param moduleName
	 * @param task
	 * @return
	 */
	public FutureTask submit(String moduleName, InterruptibleTask task);
	

}
