package com.data;
import com.date.Date;

public class Account {
	    
	    private static int series =4000;
		private static int accNo;
	    private String accType;
	    private float accBal;
	     
	    //private  Date accDate;
	   // private static String ifsc="ASFGHHJJKKK";
	    
	    //Constructor
	    public Account ( String accType,float accBal )
	    {
	    	 
	    	this.accNo=series;
	    	series++;
	    	this.accType=accType;
	    	this.accBal=accBal;
	    	 
	    }
	    
	     // getter method
	   
	 public void display(){
		 
			System.out.printf("\n Account details are:  "+accNo+"/"+accType+"/"+accBal );
		 
	 }
	    public String getAccType()
	    {
	    	return accType;
	    }
	    public int getAccNo()
	    {
	    	return accNo;
	    }
	    public float getAccBal()
	    {
	    	return accBal;
	    }
	    
	  
	    //setter method
	    public void setAccNo(int no)
		{
			this.accNo=no;
		}
		public void setAccType(String type)
		{
			this.accType=type;
		}
		public float setAccBal(float bal)
		{
			return this.accBal=bal;
		}


		//toString  Method
	    public String toString() {
	    	 return "Account Data is:"+accNo+"/"+accType+"/"+accBal;
	     }
	    

	}


