package com.rajiv.loadcontrol.task;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.rajiv.loadcontrol.LoadController;


public class FutureWrapper implements Future<Object>{

	private InterruptableTaskWrapper taskWrapper;
	
	private Future<Object> future;
	
	private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

	public FutureWrapper(InterruptableTaskWrapper taskWrapper, Future<Object> future)
	{
		this.taskWrapper = taskWrapper;
		this.future = future;
	}

	/**
	 * @return the future
	 */
	public Future<Object> getFuture() {
		return future;
	}
	
	/**
	 * @return the task
	 */
	public InterruptableTaskWrapper getTaskWrapper() {
		return taskWrapper;
	}

	
	public boolean cancelTask() {
		taskWrapper.getTask().interrupt();
		return future.cancel(true);
	}

	
	public Object get() throws InterruptedException, ExecutionException {
		
		return future.get();
	}

	
	public Object get(long timeout, TimeUnit unit) throws InterruptedException,
			ExecutionException, TimeoutException {
		
		return future.get(timeout, unit);
	}

	
	public boolean isCancelled() {
		
		return future.isCancelled();
	}

	
	public boolean isDone() {
		return future.isDone();
	}
	
	public void runTimer() {
		
		scheduler.scheduleWithFixedDelay(new Runnable(){

			@Override
			public void run() {

				if(System.currentTimeMillis() - taskWrapper.getTask().getTimeOfSubmit() > taskWrapper.getTask().getTimeOut()*1000)
				{
					taskWrapper.setTimedOut(true);
					cancelTaskOnTimeOut(FutureWrapper.this);
					scheduler.shutdownNow();
				}
			}
			
		},taskWrapper.getTask().getTimeOut(),1L, TimeUnit.SECONDS);
	
		
		/*timerTask = new TimerTask()
		{

			@Override
			public void run() {
				if(System.currentTimeMillis() - taskWrapper.getTask().getTimeOfSubmit() > taskWrapper.getTask().getTimeOut()*1000)
				{
					cancelTaskOnTimeOut(FutureWrapper.this);
					cancel();
					timer.cancel();
				}
				
			}

		};
		timer.schedule(timerTask, taskWrapper.getTask().getTimeOut()*1000, 10);*/
	}
	
	private void cancelTaskOnTimeOut(
			FutureWrapper futureWrapper) {
		LoadController.getInstance().cancelTaskOnTimeOut(futureWrapper);
		
	}

	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		taskWrapper.getTask().interrupt();
		return future.cancel(mayInterruptIfRunning);
	}
	
}
