package com.services;
    import com.services.UserServices;
	import com.data.User;
	import com.exception.InvalidUserException;
	 
	public class UserTransactions implements UserServices
	{

		 User  u;
		 //sign up
		public String signUp(String username, String password, String sqn, String san)
		
		{
			u=new User(username,password,sqn,san) ;
			System.out.println("\n \n You have sucessfully registered ..."+u);
			return u.getUserName();
			 
			
		}
		

		 //login
		public void signIn(String username, String password) throws InvalidUserException
		{
	      String uName = u.getUserName();
		  String uPass = u.getPassword();
		 if(uName.equalsIgnoreCase(username) && uPass.equalsIgnoreCase(password))
	      {
	    	 
		    System.out.println("\n WelCome "+username );
		     
		  } 
	     
	      else
	      {
	    	  throw new InvalidUserException("\n Incorrect username or password");
	      }
		 
		 
		}

		 
		public String forgotPassword(String username , String sqn,String san, String nPass) throws InvalidUserException
		{
			if((sqn==u.getSqn()) && (san==u.getSan()))
			{
				String newPass=null;
				System.out.println("\n Enter new password" +newPass);
				System.out.println("You have succesfully changed password");
				
			}
			else
			{
				return "Enter correct sequrity answer";
			}
			return nPass;
			 
		}

		 
		public void updatePassword(String username, String password, String newPassword)throws InvalidUserException
		{
			if(username.equalsIgnoreCase(username) && password.equalsIgnoreCase(password))
			{
 
				System.out.println("\n Enter old password:" +password);
				 
				System.out.println("\n Enter new password:" +newPassword);
				
			}
			else
			{
			    throw new InvalidUserException("\n Incorrect username or password");
			}
			
		}


	}


