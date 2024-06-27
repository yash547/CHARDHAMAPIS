package com.govpoly.chardhamapis.ServiceInterface;

import com.govpoly.chardhamapis.Entity.RegistrationEntity;
/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 * Here we have create the RegistrationEntity interface as the name of 
 * RegisServiceInterface.
 */
public interface RegisServiceInterface {

    /**
      here the below method are declare.
      and they are inherite into the RegistrationServiceImple class for there 
      business logic.
    **/
    
    public Object createAccount(RegistrationEntity rEntity);

    public Object logIn(String emailId,String pass);

    public Object forgotPasswordByEmailId(String emailId);
    
    public Object passwordUpdtByEmailId(String emailId,String password);

    public Object updateProfile(RegistrationEntity registrationEntity);
    
}
