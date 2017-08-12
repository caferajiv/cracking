package com.loadcontrol.task;

import java.util.concurrent.Callable;

public interface InterruptibleTask extends Callable{
	
	public void interrupt();

}
