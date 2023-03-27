package com.govpoly.chardhamapis.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govpoly.chardhamapis.Dao.EmergencyDao;
import com.govpoly.chardhamapis.Entity.EmergencyEntity;
import com.govpoly.chardhamapis.ServiceInterface.EmergencyServiceInterface;
/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */
@Service
public class EmergencyServiceImpl implements EmergencyServiceInterface{

    @Autowired
      private EmergencyDao emergencydao;
   
/**
 * it is used to create emergency details 
 */
    @Override
    public Object createEmergency(EmergencyEntity emergencyEntity) {
  
        this.emergencydao.save(emergencyEntity);
        
         return "EmergencyContact Created";
    }

    /**
     * it is used to fetch the list of emergency data
     */
    @Override
    public Object getEmergencyList() {
        return this.emergencydao.findAll();
    }
    
}
