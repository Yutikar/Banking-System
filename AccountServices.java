package com.services;

 
import java.sql.SQLException;

import com.exception.InvalidAccountNoException;
import com.exception.LowBalanceException;

public interface AccountServices
{
	int openAccount(String type, float amount);
   float deposit(int accN,float depAmt) throws InvalidAccountNoException, SQLException;
   float withdraw(int accN,float amount)throws InvalidAccountNoException ,LowBalanceException;
   float balEnquiry(int accN)throws InvalidAccountNoException;
   
   String printAccountDetails(int accNo)throws InvalidAccountNoException;
   float calculeteInt(int accNo)throws InvalidAccountNoException;
   
 
 
}
 