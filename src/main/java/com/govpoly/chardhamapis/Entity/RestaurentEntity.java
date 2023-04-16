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
 @Data
@Entity
@Table(name = "RestaurentEntity")
public class RestaurentEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column(name = "Name")
    private String name;
    
    @Column(name = "Description")
    private String description;
        
    
    @Column(name = "Latitute")
    private String lat;

    @Column(name = "Longitute")
    private String longitute;

    @Column(name = "Images")
    private String images;

    @Column(name = "PlaceName")
    private String placename;

    
}
