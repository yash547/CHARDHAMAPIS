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
@Data // here @Data annotation is from the lombok dependancy which help us to bipolarate the code. 
// means it help to provide the default constructure , parametrize constructor , and setter and getter method of the specific variable declare into the class.
@Entity // @Entity help us to create the table into the database.
@Table(name = "RegistrationEntity") // @Table help us to create the specific table in the database. so @Table is optional to use for the developer
// or depends upon the requirement of project or client or coding standard.
public class RegistrationEntity {
    
    @Id // Here @Id help us to create the primary key in the database for the perticular column. 
    @GeneratedValue(strategy=GenerationType.AUTO) 
    // here @GeneratedValue(strategy=GenerationType.AUTO) help us to increment the number automatic 
    // when ever the new data is store into the database of the registrationEntity table name.
    private int id;
    
    @Column(name = "FullName") // Here @Column help us to create the column name in the databse with the help of data assign into the name argument.
    private String fullName;
    
    @Column(name = "EmailId") // Here @Column help us to create the column name in the databse with the help of data assign into the name argument.
    private String emailId;
    

    @Column(name = "MobileNo") // Here @Column help us to create the column name in the databse with the help of data assign into the name argument.
    private String mobileNo;
    

    @Column(name = "Password") // Here @Column help us to create the column name in the databse with the help of data assign into the name argument.
    private String password;
    
    
    
}
