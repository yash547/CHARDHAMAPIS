package com.govpoly.chardhamapis.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govpoly.chardhamapis.DTO.RestaurentDTO;
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
    public Object getRestaurentList(String names) {

        
        List<Tuple> restaurentData= restaurentDao.getRestaurentByName(names);
        
ArrayList<RestaurentDTO> rArrayList=new ArrayList<>();
rArrayList.clear();
        for(Tuple tuple:restaurentData)
        {
                 RestaurentDTO restaurentDTO=new RestaurentDTO();
                 restaurentDTO.setId(tuple.get(0, Integer.class));
                 restaurentDTO.setName(tuple.get(3, String.class));
                 restaurentDTO.setDescription(tuple.get(1, String.class));
                 restaurentDTO.setImages(tuple.get(2, String.class));
                 restaurentDTO.setLat(tuple.get(4, String.class));
                 restaurentDTO.setLongitute(tuple.get(5, String.class));

                 rArrayList.add(restaurentDTO);
        }

    
        //return this.placedao.findAll();
      return rArrayList;

      //  return this.restaurentDao.findAll();

    }
    
    /**
     * fetch restaurent by id code pending.
     */



}
