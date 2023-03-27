package com.govpoly.chardhamapis.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.govpoly.chardhamapis.Entity.EmergencyEntity;
/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */
public interface EmergencyDao extends JpaRepository<EmergencyEntity,Integer>{
    
}
