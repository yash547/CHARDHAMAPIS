package com.govpoly.chardhamapis.ServiceInterface;

import com.govpoly.chardhamapis.Entity.RegistrationEntity;
/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */
public interface RegisServiceInterface {
    
    public Object createAccount(RegistrationEntity rEntity);

    public Object logIn(String emailId,String pass);

    public Object forgotPasswordByEmailId(String emailId);
    
    public Object passwordUpdtByEmailId(String emailId,String password);


    public Object updateProfile(RegistrationEntity registrationEntity);
    
}
