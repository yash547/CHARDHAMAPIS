package com.govpoly.chardhamapis.ServiceInterface;

import com.govpoly.chardhamapis.Entity.EmergencyEntity;
/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */
public interface EmergencyServiceInterface {
   
    public Object createEmergency(EmergencyEntity emergencyEntity);

    public Object getEmergencyList();

}
