package com.govpoly.chardhamapis.ServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.govpoly.chardhamapis.DTO.LoginDTO;
import com.govpoly.chardhamapis.Dao.RegistrationDao;
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

         JSONObject json=new JSONObject();

        List<Tuple> logData = this.registrationDao.logCrediential(emailId, pass);


        if(logData.size()==0)
        {
		 	return new ResponseEntity<>(json.toString(), HttpStatus.NOT_FOUND);
        }
       // ArrayList<LoginDTO> logList = new ArrayList<LoginDTO>();
        // logList.clear();

        for (Tuple data : logData) {

        //    LoginDTO logDTO = new LoginDTO();

            json.put("id", data.get(0, Integer.class));
            json.put("fullName", data.get(2, String.class));
            json.put("emailId", data.get(1, String.class));
            json.put("mobileNo", data.get(3, String.class));
               

            // logDTO.setId();
            // logDTO.setFullName();
            // logDTO.setEmailId();
            // logDTO.setMobileNo();

            //logList.add(logDTO);
        }
        return json.toString();

    }

}
