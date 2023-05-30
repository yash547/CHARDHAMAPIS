package com.govpoly.chardhamapis.Dao;

<<<<<<< HEAD
import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
=======
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> e8ac33e6ab09b7684444fd98d80ce9e3ad560ec7

import com.govpoly.chardhamapis.Entity.FeedBackEntity;

public interface FeedBackDao extends JpaRepository<FeedBackEntity,Integer>{
    
<<<<<<< HEAD

    @Query(value = "SELECT registration_entity.full_name,feed_back_entity.feed_back,feed_back_entity.rating FROM chardhamyatra.feed_back_entity INNER  JOIN chardhamyatra.registration_entity ON registration_entity.id=feed_back_entity.userid",nativeQuery = true)   
    List<Tuple> getFeedBackDetailsList();
   
=======
>>>>>>> e8ac33e6ab09b7684444fd98d80ce9e3ad560ec7
}
