package com.govpoly.chardhamapis.Dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.govpoly.chardhamapis.Entity.EmailIdOtpEntity;

@Repository
public interface EmailIdOtpDao extends JpaRepository<EmailIdOtpEntity,Integer>{
 
    /**
     * this jpa method is used to check whether the email id is present or not.
     * @param emailId
     * @return
     */
    boolean existsByEmailId(String emailId);

    @Modifying
    @Transactional
    @Query(value = "update chardhamyatra.email_id_otp_entity set email_id_otp_entity.otp= :otps where email_id_otp_entity.email_id=:emaiiId",nativeQuery=true)
    void uEmailIdOtpEntity(@Param("emaiiId") String emaiiId,@Param("otps") String otps);


    /**
     * it is used to verify whether the emailid and otp are present or not.
     * @param emailId
     * @param otps
     * @return
     */
    boolean existsByEmailIdAndOtp(String emailId,String otps);
}
