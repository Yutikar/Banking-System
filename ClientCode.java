package com.client;

import java.util.InputMismatchException;
import java.util.Scanner;


 
import com.exception.InvalidAccountNoException;
import com.exception.InvalidUserException;
import com.exception.LowBalanceException;
import com.provider.BusinessObjectProvider;
import com.provider.UserObjectProvider;
import com.services.AccountServices;
import com.services.UserServices;
 
public class ClientCode
{

	// User Interface /End User

	public static void main(String[] args ) throws InvalidAccountNoException , InvalidUserException,InputMismatchException
		{
				 
				
				// SWITCH CASE FOR USER TRANSACTIONS
				char ch ='\0';
				Scanner sc=new Scanner(System.in);
				Scanner scan=new Scanner(System.in).useDelimiter("\n");
				System.out.println("WElcome to Our Services...");
				 
				 
				
				while(ch!='E')
				{
					System.out.println("\n Choose An option \n");
					System.out.println("A.SignUp");
					System.out.println("B. SignIn");
					System.out.println("C. Forgot passsword");
					System.out.println("D.Update password");
					System.out.println("E.Exit...");
					System.out.println("\n Enter an Option");
					ch=sc.next().charAt(0);	 
					System.out.println("\n");
				 
				switch(ch)
					{
				
				case 'A':
					 
					System.out.println("Enter UserName");
					String username=sc.next();
					System.out.println("Create Password");
					String password=sc.next();
					System.out.println("Choose sequrity Question");
					 
					String sqn=scan.next();
					 
					 
					System.out.println("Enter security answer");
					String san=sc.next();
					 
					 
					//user object provider
					 
					
					//Sign up method
					user.signUp(username,password,sqn,san);
					break;
					
					case 'B':
						
						//Sign in method
						
						try
						{
							
							System.out.println("Enter your username");
							String uName=sc.next();
							System.out.println("Enter Password");
							String uPass=sc.next();
							user.signIn(uName,uPass);
			 
					 
					
						  AccountServices bank=BusinessObjectProvider.createObject() ;	
						  
						  //SWITCH CASE FOR ACCOUNT TRANSACTIONS
							char option ='\0';
							
							System.out.println("\n");
							 
							
							while(option!='G')
							{
								System.out.println("Choose Service..");
								System.out.println("A. Open Account");
								System.out.println("B. Deposit");
								System.out.println("C. withdraw");
								System.out.println("D. Balance Enquiry");
								System.out.println("E.  calculate interest");
								System.out.println("F. Account Details");
								 System.out.println("G. Exit");
								System.out.println("\n Enter an Option");
								option=sc.next().charAt(0);	 
								System.out.println("\n");
							 
							switch(option)
								{
							
							    case 'A':
							    	//open account
							    	
							    	System.out.println("Please choose account type");
									String type=sc.next();
									System.out.println("Enter amount with which you are going to open the account ");
									float amount=sc.nextFloat();
								 
								   // bank.openAccount(type,amount );
									int accN = bank.openAccount(type, amount);
									System.out.println("\n   your account is opened " +accN );
									break;
							
							
							
								 case 'B':
									//deposit method
									try
									{
										System.out.println("Enter Account number :");
										int accNo=sc.nextInt();
										System.out.println("Enter amount to deposit :");
										float amt=sc.nextFloat();
										 bank.deposit(accNo, amt);
									}
									catch (InvalidAccountNoException e1) 
									{
										e1.printStackTrace();
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
									break;
									
								case 'C':
									//withdraw method
									try
									{
										System.out.println("Enter Account number :");
										int accNum=sc.nextInt();
										System.out.println("Enter amount to withdraw:");
										float amt1=sc.nextFloat();
										bank.withdraw(accNum, amt1);
									}
									catch (InvalidAccountNoException e) 
									{
										e.printStackTrace();
									}
									catch(LowBalanceException e)
									{
										e.printStackTrace();
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
									break;
									
								case 'D':
									//balance inquiry
									try
									{
									 
									System.out.println("Enter Account number :");
									int accNum=sc.nextInt();
									System.out.println("Your account Balance :"+bank.balEnquiry(accNum));
									}
									catch (InvalidAccountNoException e) 
									{
										e.printStackTrace();
									}
									 
									catch(Exception e)
									{
										e.printStackTrace();
									}
									break;
									
								
								  case 'E':
									  //calculate interest 
									  try {
										  	System.out.println("Enter Account number :"); 
										  	int accNm=sc.nextInt();
										  	bank.calculeteInt(accNm); 
									  		} 
									  catch (InvalidAccountNoException e)
									  {
										  e.printStackTrace(); 	
									  } 
									  
									  catch(Exception e) 
									  { 
										  e.printStackTrace();
									  } break;
								 
									 
								 case 'F':
									 //Print account details
									 
									try
									{
										System.out.println("Enter Account number :");
										int accNo=sc.nextInt();
										System.out.println("Your Account Details are :"+bank.printAccountDetails(accNo));
									}
								    catch (InvalidAccountNoException e) 
									{
										e.printStackTrace();
									}
								    catch(Exception e)
									{
										e.printStackTrace();
									}
									break;
									
								  
								 
									 
								 case 'G':
									  System.out.println("THANK YOU for using our services ..");
									  break;
									  
								 default:
									 System.out.println("Please Enter valid option");
									}
							 
								}
							}
							catch(InputMismatchException e)
							{
								e.printStackTrace();	
							}
							catch(NullPointerException e)
							{
								e.printStackTrace();
							}
							catch(InvalidUserException e)
							{
								e.printStackTrace();
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						break;
					
				case 'C':
					
					 try
						{
						 	System.out.println("You can reset your password here....");
							System.out.println("Enter your username");
							String userName=sc.next();
							System.out.println("Enter Security Question");
							String uQan=scan.next();
							System.out.println("Enter Security Answer");
							String uSan=sc.next();
							System.out.println("Enter new password");
							String nPass=sc.next();
							user.forgotPassword(userName,uQan,uSan,nPass);
							System.out.println("Your password is reset now...");
						}
						catch(InvalidUserException e)
						{
							e.printStackTrace();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					 break;
					 
				case 'D':
					try
					{
						System.out.println("Enter UserName");
						String userN=sc.next();
						System.out.println("Enter Password");
						String pass=sc.next();
						System.out.println("\n You can update your password now");
						System.out.println("Create new Password");
						String nPass=sc.next();
						user.updatePassword(userN,pass,nPass);
					}
					catch(InvalidUserException e)
					{
						e.printStackTrace();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					break;
					
				case 'E':
					 System.out.println("Exit....");
					 break;
					 
			     default:
			    	 System.out.println("Please enter valid option..");
					
					}
				}
			}
		}
  

