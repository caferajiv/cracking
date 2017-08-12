package com.rajiv.loadcontrol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.rajiv.loadcontrol.observers.IResourceObserver;
import com.rajiv.loadcontrol.observers.IResourceOverloadObserver;
import com.rajiv.loadcontrol.observers.IResourceRecoveryObserver;
import com.rajiv.loadcontrol.sensors.IResourceSensor;
import com.rajiv.loadcontrol.sensors.impl.MemoryResourceSensor;

public class ResourceMonitor {
	
	
	private static List<IResourceSensor> sensorsList = Collections
			.synchronizedList(new ArrayList<IResourceSensor>());
	private static ResourceMonitor resourceMonitor = new ResourceMonitor();
	
	private List<IResourceRecoveryObserver> resourceRecoveryObserversList = Collections
			.synchronizedList(new ArrayList<IResourceRecoveryObserver>()); 
	
	private List<IResourceOverloadObserver> resourceOverloadObserversList = Collections
			.synchronizedList(new ArrayList<IResourceOverloadObserver>()); 
	
	private ResourceMonitor()
	{
		sensorsList.add(new MemoryResourceSensor());
	}
	
	public static ResourceMonitor getInstance()
	{
		/*if (null == resourceMonitor) {
			synchronized (ResourceMonitor.class) {
				if (null == resourceMonitor) {
					resourceMonitor = new ResourceMonitor();
				}
			}
		}*/
		return resourceMonitor;

	}
	
	public void notifyOnOverLoadEvent()
	{

		for (IResourceOverloadObserver iResourceOverloadObserver : 
			resourceOverloadObserversList) 
		{
			iResourceOverloadObserver.performActionOnOverloadEvent();
		}
	
	}
	
	public void notifyOnOverLoadRectificationEvent() {
		for (IResourceOverloadObserver iResourceOverloadObserver : 
			resourceOverloadObserversList) 
		{
			iResourceOverloadObserver.performActionOnOverloadRectificationEvent();
		}
	}
	
	public void notifyOnRecoveryEvent()
	{

		for (IResourceRecoveryObserver iResourceRecoveryObserver : 
			resourceRecoveryObserversList) 
		{
			iResourceRecoveryObserver.performActionOnRecoveryEvent();
		}
	
	}
	
	

	public void registerRecoveryObserver(IResourceRecoveryObserver resourceRecoveryObserver) {
		resourceRecoveryObserversList.add(resourceRecoveryObserver);
		
	}
	
	public void registerOverloadObserver(IResourceOverloadObserver resourceOverloadObserver) {
		resourceOverloadObserversList.add(resourceOverloadObserver);
		
	}
	
	public void deRegisterObservers(IResourceObserver resourceObserver)
	{
		if(resourceObserver instanceof IResourceRecoveryObserver)
		{
			resourceRecoveryObserversList.remove(resourceObserver);
		}
		
		if(resourceObserver instanceof IResourceOverloadObserver)
		{
			resourceOverloadObserversList.remove(resourceObserver);
		}
	}

	public static void startSensors() {
		for(IResourceSensor resourceSensor: sensorsList)
		{
			resourceSensor.start();
		}
		
	}

}
