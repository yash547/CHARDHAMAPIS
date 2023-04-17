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
        
            /**
             * sendSimpleEmail method call
             */
            String body = "<p>Dear "+rEntity.getFullName()+" ,</p>" +
                      "<p>Thank you for your interest in the CharDham app. To start your journey to the holy shrines, please create your account by following the steps below:</p>" +
                      "<ol>" +
                      "<li>Download the CharDham app from the Google Play Store.</li>" +
                      "<li>Tap on the \"Create Account\" button on the login screen.</li>" +
                      "<li>Enter your personal details, including your name, email address, and phone number.</li>" +
                      "<li>Choose a secure password and confirm it.</li>" +
                      "<li>Tap on the \"Create Account\" button.</li>" +
                      "</ol>" +
                      "<p>Once you have created your account, you will be able to explore the app's features, including:</p>" +
                      "<ul>" +
                      "<li>Information on the four holy shrines of CharDham</li>" +
                      "<ul>" +
                      "<li>Char Dham Yatra Guide: A comprehensive guide to the Char Dham Yatra, including information on the four holy shrines (Yamunotri, Gangotri, Kedarnath, and Badrinath), the route to each shrine, and important tips for travellers.</li>" +
                      "<li>Other Places to Visit: Information on other popular tourist destinations in Uttarakhand, including scenic hill stations, adventure sports destinations, and cultural and historical sites.</li>" +
                      "<li>Maps and Navigation: Interactive maps with GPS navigation to help tourists find their way to the Char Dham shrines and other places of interest in Uttarakhand.</li>" +
                      "<li>Accommodation and Food: A list of recommended hotels, guesthouses, and restaurants in the region, with information on prices, amenities, and contact details.</li>" +
                      "<li>Emergency Services: A directory of emergency services, including hospitals, police stations, and rescue services, to help tourists in case of any emergency</li>" +
                      "</ul>" +
                      "</ul>" +
                      "<p>If you have any questions or concerns, please don't hesitate to contact us at <a href=\"mailto:krutikajaiswal724@gmail.com\">krutikajaiswal724@gmail.com</a></p>" +
                      "<p>Thank you,<br>The CharDham App Team</p>";

            sendSimpleEmail(rEntity.getEmailId(), body,"Create your CharDham account");
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

            if (emailOtpDao.existsByEmailId(emailId)) {
                emailOtpDao.uEmailIdOtpEntity(emailId, pass);
            } else {

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
            sendSimpleEmail(emailId, body,"Char Dham Yatra OTP Crediential");

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
    public void sendSimpleEmail(String toEmail, String body,String suject) {

        MimeMessage messages = mailSender.createMimeMessage();

        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(messages, true);
            helper.setSubject(suject);
            helper.setFrom("krutikajaiswal724@gmail.com");
            helper.setTo(toEmail);
            helper.setText(body, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        mailSender.send(messages);

        System.out.println("Mail Send...");

    }

    @Override
    public Object passwordUpdtByEmailId(String emailId, String password) {
        JSONObject json = new JSONObject();

        registrationDao.updtPasswordByEmailId(emailId, password);
        json.put("message", "Password Changed ");
        json.put("status", "SUCCESS");

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);

    }

    @Override
    public Object updateProfile(RegistrationEntity registrationEntity) {
        JSONObject json = new JSONObject();

        Optional<RegistrationEntity> rOptional=this.registrationDao.findById(registrationEntity.getId());

        RegistrationEntity regUpdateEntity=rOptional.get();

        regUpdateEntity.setEmailId(registrationEntity.getEmailId());

        regUpdateEntity.setFullName(registrationEntity.getFullName());

        regUpdateEntity.setMobileNo(registrationEntity.getMobileNo());

        this.registrationDao.save(regUpdateEntity);

        json.put("message", "Profile Updated");
        json.put("status", "SUCCESS");

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);

    }

}
