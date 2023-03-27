package com.govpoly.chardhamapis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.govpoly.chardhamapis.Entity.EmergencyEntity;
import com.govpoly.chardhamapis.ServiceInterface.EmergencyServiceInterface;
/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */
@RestController
public class EmergencyController {
 
    @Autowired
    private EmergencyServiceInterface eInterface;

  @PostMapping("/createEmergency")
    public Object createEmergency(@RequestBody EmergencyEntity emergencyEntity) {

        return this.eInterface.createEmergency(emergencyEntity);
    
    }

      @GetMapping("/getEmergencylist")
    public Object getEmergencyList() {

        return this.eInterface.getEmergencyList();
    }

}
