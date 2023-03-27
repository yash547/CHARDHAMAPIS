package com.govpoly.chardhamapis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.govpoly.chardhamapis.Entity.RegistrationEntity;
import com.govpoly.chardhamapis.ServiceInterface.RegisServiceInterface;
/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */
@RestController
public class RegistrationController {

    @Autowired
    private RegisServiceInterface rServiceInterface;

    
    @PostMapping("/createAccount")
    public Object createAccount(@RequestBody RegistrationEntity rEntity) {

        return this.rServiceInterface.createAccount(rEntity);

    }

    @GetMapping("/login={emailId}/={pass}")
    public Object logIn(@PathVariable String emailId,@PathVariable String pass) {

        return this.rServiceInterface.logIn(emailId, pass);

    }
}
