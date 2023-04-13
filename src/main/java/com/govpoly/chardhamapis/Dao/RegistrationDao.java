package com.govpoly.chardhamapis.Dao;

import java.util.List;

import javax.persistence.Tuple;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.govpoly.chardhamapis.Entity.RegistrationEntity;

/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */

 @Repository
public interface RegistrationDao extends JpaRepository<RegistrationEntity,Integer>{
    
/*
 * it is used to check whether the email id and password exists or not
 */
    @Query(value  = "select * from registration_entity where registration_entity.email_id= :email and registration_entity.password= :pass",nativeQuery = true)
    List<Tuple> logCrediential(@Param("email") String email,@Param("pass") String pass);

    /**
     * this jpa method is used to check whether the email id is present or not.
     * @param emailId
     * @return
     */
    boolean existsByEmailId(String emailId);


    @Modifying
    @Transactional
    @Query(value = "update chardhamyatra.registration_entity set registration_entity.password= :pass where registration_entity.email_id=:emaiiId",nativeQuery=true)
    void updtPasswordByEmailId(@Param("emaiiId") String emaiiId,@Param("pass") String pass);


}
