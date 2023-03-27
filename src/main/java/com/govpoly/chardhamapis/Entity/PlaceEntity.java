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
@Table(name = "PlaceEntity")
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Location")
    private String location;

    @Column(name = "Images")
    private String images;
}
