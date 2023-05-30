package com.govpoly.chardhamapis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.govpoly.chardhamapis.ServiceInterface.EmailIdOtpServiceInterface;

@RestController
public class EmailIdOtpController {
    
    @Autowired
    private EmailIdOtpServiceInterface emailIdOtpServiceInterface;

/**
 * it is used to verify the otp by email id.
 * @param emailId
 * @param Otp
 * @return
 */
    @GetMapping("/VerifyOtp")
    public Object verifyOtp(@RequestParam String emailId,@RequestParam String Otp) {

    return emailIdOtpServiceInterface.verifyOtp(emailId, Otp);
    }
}
