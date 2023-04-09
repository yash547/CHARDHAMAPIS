package com.govpoly.chardhamapis.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.govpoly.chardhamapis.Entity.FeedBackEntity;

public interface FeedBackDao extends JpaRepository<FeedBackEntity,Integer>{
    
}
