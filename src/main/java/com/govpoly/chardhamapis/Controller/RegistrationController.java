package com.govpoly.chardhamapis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    //@GetMapping("/login={emailId}/={pass}")
    @GetMapping("/login")
    public Object logIn(@RequestParam  String emailId,@RequestParam  String pass) {

        return this.rServiceInterface.logIn(emailId, pass);

    }

/**
 * this controller is used to send the otp through email
 * @param emailid
 * @return
 */
    @GetMapping("/forgotPassword")
    public Object forgotPasswordByEmailId(@RequestParam String emailid) {
            return this.rServiceInterface.forgotPasswordByEmailId(emailid);
    }



}
