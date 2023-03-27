package com.govpoly.chardhamapis.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govpoly.chardhamapis.Dao.RestaurentDao;
import com.govpoly.chardhamapis.Entity.RestaurentEntity;
import com.govpoly.chardhamapis.ServiceInterface.RestaurentServiceInterface;

/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */
@Service
public class RestaurentServiceImpl implements RestaurentServiceInterface {

    @Autowired
    private RestaurentDao restaurentDao;

    /**
     * it is used to create the new Restaurent
     */
    @Override
    public Object createRestaurent(RestaurentEntity rsEntity) {

        this.restaurentDao.save(rsEntity);

        return "Restaurent Created";
    }

    /**
     * it is used to fetch all the resturent with their details
     * (name,description,direction,images)
     */
    @Override
    public Object getRestaurentList() {

        return this.restaurentDao.findAll();

    }
    
    /**
     * fetch restaurent by id code pending.
     */



}
