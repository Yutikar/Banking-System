package com.services;

import com.exception.InvalidUserException;

public interface UserServices
{
    
   String signUp(String username,String password, String sqn,String san);
   void signIn(String username,String password) throws InvalidUserException;
   String forgotPassword(String username , String sqn,String san, String nPass) throws InvalidUserException;
   void updatePassword(String username,String password, String newPassword)throws InvalidUserException;
}
