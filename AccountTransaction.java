package com.services;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.connector.AccountDatabaseConnector;
import com.data.Account;
 
import com.exception.InvalidAccountNoException;
import com.exception.LowBalanceException;

//Business Logic Methods
 
public class AccountTransaction implements AccountServices
{
 

		 Account acc  ;
		 Connection con=null;
		 Statement st=null;
		 PreparedStatement pst=null;
		 ResultSet rs;
		 AccountDatabaseConnector x,y;
		 String name,pass,url;
		 
		 
		// OpenAccount Method
		
		
		  public int openAccount(String type, float amount ) 
		  {
			  acc = new Account(type,amount);
		      int i=acc.getAccNo();
			 
			  try
			  {
				  x=new AccountDatabaseConnector();
				  x.connect();
				  
				  url="jdbc:mysql://localhost:3306/banking_project";
				  name="root";
				  pass="life goes on like this again@7";
				  con=DriverManager.getConnection(url,name,pass);
				  pst=con.prepareStatement("insert into  account values(?,?,?)");
				  pst.setInt(1, acc.getAccNo());
				  pst.setString(2, acc.getAccType());
				  pst.setFloat(3, acc.getAccBal());
				  int updateAccount=pst.executeUpdate();
				  System.out.println(updateAccount+"Records Updated \n");
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			  return i;
		  }
	
		  
		  //account number validation 
		  
		  
		  public boolean compare(int accNo )
		  {
		       
			  if(accNo==acc.getAccNo())
			  { 
				  return true; 
			  } 
			  
			  else
			  {
				  return false; 
			  }
			  
		  }
		 
		
		
			
			  // calculate interest 
		  public float calculeteInt(int accNo)throws InvalidAccountNoException
		  
		  {
			  
			  float intrs=0.0f;
			  if(compare(accNo))
			  {
			  
			  
				  float bal =acc.getAccBal();
				  if(bal>50000)
				  {
			  
					  intrs=bal*10/100;
					  System.out.println( "\n Interest is:"+intrs); 
					  float newBal=intrs+bal;
					  System.out.println("\n Updated balance after adding interest is:"+newBal);
					  try
					  {
						  y= new AccountDatabaseConnector();
	                 	  y.connect();
	                      url="jdbc:mysql://localhost:3306/banking_project";
	       				  name="root";
	       				  pass="life goes on like this again@7";
	       				  con=DriverManager.getConnection(url,name,pass);
                 		pst=con.prepareStatement("update account set accbal=? where accNo=?");
                 		pst.setFloat(1, newBal);
                 		pst.setInt(2,accNo);
                 		boolean r=pst.execute();
                 		if(r)
                 		{
                 			rs=pst.getResultSet();
                 		}
                 		
                 	}
                 	catch(SQLException e)
                 	{
                 		e.printStackTrace();
                 	}
                 	catch(Exception e)
                 	{
                 		e.printStackTrace();
                 	}
					   
					  
					  
					}
			  
				  else
				  {
			  
					  	System.out.println("\n No interest is applicable yet....");
				  }
			      }
			  
			  
			   else 
			   {
				   throw new InvalidAccountNoException("\n Incorrect Account number");
			   }
			  return intrs;
			  
			  }

			  
			 
			  
			  
			 
		  	// Deposit Method
		
		
		  public synchronized float deposit(int accNo,float depAmt) throws InvalidAccountNoException,SQLException
		  {
		  
		  
			  	
			  	if(compare(accNo))
			  	{
			  		float updateBalance=acc.getAccBal()+depAmt; 
			  		acc.setAccBal(updateBalance);
                 	System.out.println(" \n Updated Balance after deposit  is :"+updateBalance);
                 	 
                 	try
                 	{
	                 	  y= new AccountDatabaseConnector();
	                 	  y.connect();
	                      url="jdbc:mysql://localhost:3306/banking_project";
	       				  name="root";
	       				  pass="life goes on like this again@7";
	       				  con=DriverManager.getConnection(url,name,pass);
                 		pst=con.prepareStatement("update account set accbal=? where accNo=?");
                 		pst.setFloat(1, updateBalance);
                 		pst.setInt(2,accNo);
                 		boolean r=pst.execute();
                 		if(r)
                 		{
                 			rs=pst.getResultSet();
                 		}
                 		
                 	}
                 	catch(SQLException e)
                 	{
                 		e.printStackTrace();
                 	}
                 	catch(Exception e)
                 	{
                 		e.printStackTrace();
                 	}
                 	return updateBalance;
		        } 
			  	
    	
		       else 
		       { 
			  
		    	   throw new InvalidAccountNoException("\n Incorrect Account number");
		       }
		  
		 
		  }
		 
		
		
		  // withdraw Method
		  public synchronized float withdraw(int accNo, float withdrawAmt)throws InvalidAccountNoException, LowBalanceException 
		  { 

				if(acc.getAccBal()<5000.0f)
				{
					throw new LowBalanceException("Incsufficient Balance");
				}
				else if (compare(accNo))
					{
					
						float updateBal=acc.getAccBal()-withdrawAmt;
						assert(updateBal>2000): "low balance";
						System.out.println("Updated Account Balance after withdrawl is "+updateBal);
						try
						{
							  y= new AccountDatabaseConnector();
		                 	  y.connect();
		                      url="jdbc:mysql://localhost:3306/banking_project";
		       				  name="root";
		       				  pass="life goes on like this again@7";
		       				  con=DriverManager.getConnection(url,name,pass);
	                 		pst=con.prepareStatement("update account set accbal=? where accNo=?");
	                 		pst.setFloat(1, updateBal);
	                 		pst.setInt(2,accNo);
	                 		boolean r=pst.execute();
	                 		if(r)
	                 		{
	                 			rs=pst.getResultSet();
	                 		}
						
						 
						}
						catch(SQLException e)
						{
							e.printStackTrace();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						return updateBal;
					}
					else
					{
						throw new InvalidAccountNoException("Enter Correct Account Number");
					}
				}
 	  
		  
		 
		
		
		  // Balance enquiry method
		  public synchronized float balEnquiry(int accNo)throws InvalidAccountNoException
		  
		  { 

				if(compare(accNo))
				{
					return acc.getAccBal();
				}
				else 
				{
					throw new InvalidAccountNoException("Enter Correct Account Number");
				}
		  }
		 
		
		  //print account details
		  public synchronized String printAccountDetails(int accNo)throws InvalidAccountNoException
		  {
		    if(compare(accNo)) 
			  {
		  
				  return acc.toString();
				  
			  }
			  else
			  {
				  throw new InvalidAccountNoException("\n Incorrect Account number");
			  }
		  
			 
		  }

	 }
  
  
  
  
  
 