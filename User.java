package com.data;

// data carrier java bean class
public class User {
	private String username,password,sqn,san;
	
	public User(String username, String password,String sqn, String san)
	
	{
		this.username=username;
		this.password=password;
		this.sqn=sqn;
		this.san=san;
	}
	
	 //setter method
    public String setUserName(String name)
	{
		return username=name;
	}
	public void setPassword(String pass)
	{
		password=pass;
	}
	public void setSqn(String qn)
	{
		sqn=qn;
	}
	public void setSan(String ans)
	{
		san=ans;
	}
	



	//Getter method
	public String getUserName() 
	{
	    	return username;
	}
	
	public String getPassword() 
	{
	    	return password;
	}
	
	public String getSqn() 
	{
	    	return sqn;
	}
	
	public String getSan() 
	{
	    	return san;
	}
	
	//toString  Method
    public String toString() {
    	 return "\n \n USer Data:"+username+"/"+password+"/"+sqn+"/"+san;
     }
}
	    