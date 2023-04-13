package com.govpoly.chardhamapis.ServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.Tuple;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.govpoly.chardhamapis.DTO.LoginDTO;
import com.govpoly.chardhamapis.Dao.EmailIdOtpDao;
import com.govpoly.chardhamapis.Dao.RegistrationDao;
import com.govpoly.chardhamapis.Entity.EmailIdOtpEntity;
import com.govpoly.chardhamapis.Entity.RegistrationEntity;
import com.govpoly.chardhamapis.ServiceInterface.RegisServiceInterface;

/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */
@Service
public class RegistrationServiceImpl implements RegisServiceInterface {

    @Autowired
    private RegistrationDao registrationDao;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailIdOtpDao emailOtpDao;

    /**
     * it is used to create the account.
     */
    @Override
    public Object createAccount(RegistrationEntity rEntity) {

        this.registrationDao.save(rEntity);
        return "Data Inserted";
    }

    /**
     * it is used to verify the data whether it is present or not.
     * 
     */
    @Override
    public Object logIn(String emailId, String pass) {

        JSONObject json = new JSONObject();

        List<Tuple> logData = this.registrationDao.logCrediential(emailId, pass);

        if (logData.size() == 0) {
            return new ResponseEntity<>(json.toString(), HttpStatus.NOT_FOUND);
        }
        // ArrayList<LoginDTO> logList = new ArrayList<LoginDTO>();
        // logList.clear();

        for (Tuple data : logData) {

            // LoginDTO logDTO = new LoginDTO();

            json.put("id", data.get(0, Integer.class));
            json.put("fullName", data.get(2, String.class));
            json.put("emailId", data.get(1, String.class));
            json.put("mobileNo", data.get(3, String.class));

            // logDTO.setId();
            // logDTO.setFullName();
            // logDTO.setEmailId();
            // logDTO.setMobileNo();

            // logList.add(logDTO);
        }
        return json.toString();

    }

    @Override
    public Object forgotPasswordByEmailId(String emailId) {
        JSONObject json = new JSONObject();

        if (registrationDao.existsByEmailId(emailId)) {

            // Generate the random password
            Random generator = new Random();
            int password = (generator.nextInt(999999));
            String pass = String.format("%06d", password);
            String body = "OTP for CharDham Yatra " + pass;

            if(emailOtpDao.existsByEmailId(emailId))
            {
                emailOtpDao.uEmailIdOtpEntity(emailId,pass);
            }
            else
            {

            /**
             * Object created to store the email id and OTP 
             */
            EmailIdOtpEntity emailIdOtpEntity = new EmailIdOtpEntity();
            emailIdOtpEntity.setEmailId(emailId);
            emailIdOtpEntity.setOtp(pass);
            
            /**
             * Data store into the data base using jpa repository
             */
            emailOtpDao.save(emailIdOtpEntity);
            }
            /**
             * sendSimpleEmail method call 
             */
            sendSimpleEmail(emailId, body);

            json.put("message", "OTP Send Through Email ID");
            json.put("status", "SUCCESS");

            return new ResponseEntity<>(json.toString(), HttpStatus.OK);
        }

        json.put("message", "Email ID NOT FOUND");
        json.put("status", "NOT FOUND");

        return new ResponseEntity<>(json.toString(), HttpStatus.NOT_FOUND);
    }

    /**
     * it used to send the email for OTP verification.
     * 
     * @param toEmail
     * @param body
     */
    public void sendSimpleEmail(String toEmail, String body) {

        MimeMessage messages = mailSender.createMimeMessage();

        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(messages, true);
            helper.setSubject("Char Dham Yatra OTP Crediential");
            helper.setFrom("yashmishra547@gmail.com");
            helper.setTo(toEmail);
            helper.setText(body, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        mailSender.send(messages);

        System.out.println("Mail Send...");

    }


}
