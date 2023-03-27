package com.govpoly.chardhamapis.DTO;

import java.math.BigDecimal;

import lombok.Data;
/**
 * 
 * @author Team CharDham Yatra Developer
 */

 /*
 * The below the DTO class is used to provide the login crediential details. 
 */
@Data
public class LoginDTO {

    private Integer id;

    private String fullName;

    private String emailId;

    private String mobileNo;

}