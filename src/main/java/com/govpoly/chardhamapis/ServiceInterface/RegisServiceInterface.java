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

}
