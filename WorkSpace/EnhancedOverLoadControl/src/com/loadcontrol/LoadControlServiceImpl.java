package com.loadcontrol;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import com.loadcontrol.task.InterruptibleTask;

public class LoadControlServiceImpl implements LoadControlService {

	private static LoadControlService loadControlService = 
			new LoadControlServiceImpl();

	private static Map<String, ThreadPoolExecutor> moduleExecutorsMap = 
			new ConcurrentHashMap<String, ThreadPoolExecutor>();

	private LoadControlServiceImpl() {
		// do Nothing
	}

	public static LoadControlService getInstance() {
		return loadControlService;
	}

	@Override
	public boolean registerModule(String moduleName, int queueSize,
			int minConcurrentTasks, int maxConcurrentTasks) {
		if (!moduleExecutorsMap.containsKey(moduleName)) {
			PriorityBlockingQueue priorityBlockingQueue = 
					new PriorityBlockingQueue(
					queueSize);
			ThreadPoolExecutor threadPoolExecutor = new MyThreadPoolExecutor(
					minConcurrentTasks, maxConcurrentTasks,
					priorityBlockingQueue);
			moduleExecutorsMap.put(moduleName, threadPoolExecutor);
			return true;

		}

		return false;
	}

	@Override
	public boolean deregisterModule(String moduleName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FutureTask submit(String moduleName, InterruptibleTask task) {
		// TODO Auto-generated method stub
		return null;
	}

}
