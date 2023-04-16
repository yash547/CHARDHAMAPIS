package com.govpoly.chardhamapis.Dao;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.govpoly.chardhamapis.Entity.RestaurentEntity;
/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */
public interface RestaurentDao extends JpaRepository<RestaurentEntity,Integer>{

    @Query(value = "select * from chardhamyatra.restaurent_entity where restaurent_entity.place_name= :names",nativeQuery = true)   
    List<Tuple> getRestaurentByName(@Param("names") String names);
    
}
