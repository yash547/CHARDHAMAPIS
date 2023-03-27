package com.govpoly.chardhamapis.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */
@Data
@Entity
@Table(name = "EmergencyEntity")
public class EmergencyEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column(name = "Name")
    private String name;
    
    @Column(name = "MobileNo")
    private String mobileNo;
    
 

}
