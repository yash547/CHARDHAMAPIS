package com.govpoly.chardhamapis.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.govpoly.chardhamapis.Entity.PlaceEntity;

public interface PlaceDao  extends JpaRepository<PlaceEntity,Integer>{
    
}
