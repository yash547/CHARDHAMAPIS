package com.govpoly.chardhamapis.ServiceImpl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.govpoly.chardhamapis.Dao.EmailIdOtpDao;
import com.govpoly.chardhamapis.ServiceInterface.EmailIdOtpServiceInterface;

@Service
public class EmailIdOtpServiceImpl implements EmailIdOtpServiceInterface {

    @Autowired
    private EmailIdOtpDao emailOtpDao;

    @Override
    public Object verifyOtp(String emailId, String Otp) {
        JSONObject json = new JSONObject();

        if (emailOtpDao.existsByEmailIdAndOtp(emailId, Otp)) {
            
            json.put("message", "OTP Verified");
            json.put("status", "SUCCESS");

            return new ResponseEntity<>(json.toString(), HttpStatus.OK);
        
        }

        json.put("message", "Incorrect OTP");
        json.put("status", "NOT FOUND");

        return new ResponseEntity<>(json.toString(), HttpStatus.NOT_FOUND);
    }

}
