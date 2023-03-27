package com.govpoly.chardhamapis.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govpoly.chardhamapis.Dao.PlaceDao;
import com.govpoly.chardhamapis.Entity.PlaceEntity;
import com.govpoly.chardhamapis.ServiceInterface.PlaceServiceInterface;

@Service
public class PlaceServiceImpl implements PlaceServiceInterface {

    @Autowired
    private PlaceDao placedao;
    
    /*
     * it is used to create the new place entries/data
     */
    @Override
    public Object createPlace(PlaceEntity pEntity) {
    
        return this.placedao.save(pEntity);
    }

    /**
     * it is used to fetch the list of place
     */
    @Override
    public Object getPlaceList() {
    
        return this.placedao.findAll();
    }

    /**
     * it is used to fetch the place by id 
     */
    @Override
    public Object getPlaceById(String id) {
    
        return this.placedao.findById(Integer.parseInt(id));
    }

}
