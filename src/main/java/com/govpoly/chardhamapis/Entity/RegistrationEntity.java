package com.govpoly.chardhamapis.Entity;

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
@Table(name = "RegistrationEntity")
public class RegistrationEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column(name = "FullName")
    private String fullName;
    
    @Column(name = "EmailId")
    private String emailId;
    

    @Column(name = "MobileNo")
    private String mobileNo;
    

    @Column(name = "Password")
    private String password;
    
    
    
}
