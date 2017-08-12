package com.rajiv.loadcontrol.observers;

public interface IResourceRecoveryObserver extends IResourceObserver{
	
	public void performActionOnRecoveryEvent();

}
