package com.loadcontrol.exceptions;

public class IllegalQueueStateException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4697145726836145695L;

	public IllegalQueueStateException(String cause) {

		super(cause);
	}

}
