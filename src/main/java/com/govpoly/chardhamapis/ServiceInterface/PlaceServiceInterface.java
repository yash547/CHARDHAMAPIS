package com.govpoly.chardhamapis.ServiceInterface;

import org.springframework.stereotype.Service;

import com.govpoly.chardhamapis.Entity.PlaceEntity;

/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */
public interface PlaceServiceInterface {

    public Object createPlace(PlaceEntity pEntity);

    public Object getPlaceList(String names);

    public Object getPlaceById(String id);
}
