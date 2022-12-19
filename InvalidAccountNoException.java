package com.exception;

public class InvalidAccountNoException extends Exception {
	String msg;

	
	public InvalidAccountNoException(String msg)
	{
		this.msg=msg;
	}
	public String toString()
	{
		return "Exception is:"+msg;
	}
}
