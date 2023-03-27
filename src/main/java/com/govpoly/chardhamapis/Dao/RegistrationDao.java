package com.govpoly.chardhamapis.Dao;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.govpoly.chardhamapis.Entity.RegistrationEntity;

/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */

public interface RegistrationDao extends JpaRepository<RegistrationEntity,Integer>{
    
/*
 * it is used to check whether the email id and password exists or not
 */
    @Query(value  = "select * from registration_entity where registration_entity.email_id= :email and registration_entity.password= :pass",nativeQuery = true)
    List<Tuple> logCrediential(@Param("email") String email,@Param("pass") String pass);
}
