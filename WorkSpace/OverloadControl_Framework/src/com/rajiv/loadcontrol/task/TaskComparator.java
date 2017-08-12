package com.rajiv.loadcontrol.task;

import java.util.Comparator;

public class TaskComparator implements Comparator<AbstractInterruptableTask> {

	@Override
	public int compare(AbstractInterruptableTask o1,
			AbstractInterruptableTask o2) {
		return o2.getPriority()-o1.getPriority();
		
	}

}
