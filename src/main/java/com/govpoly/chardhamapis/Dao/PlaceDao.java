package com.govpoly.chardhamapis.Dao;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.govpoly.chardhamapis.Entity.PlaceEntity;

public interface PlaceDao  extends JpaRepository<PlaceEntity,Integer>{
 
    
 @Query(value = "SELECT * FROM chardhamyatra.place_entity where place_entity.name= :names",nativeQuery = true)   
List<Tuple> getPlaceByName(@Param("names") String names);

}
