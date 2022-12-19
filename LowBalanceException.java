package com.exception;

public class LowBalanceException extends Exception

{
String msg;

	
	public LowBalanceException(String msg)
	{
		this.msg=msg;
	}
	public String toString()
	{
		return "Exception is:"+msg;
	}
}
