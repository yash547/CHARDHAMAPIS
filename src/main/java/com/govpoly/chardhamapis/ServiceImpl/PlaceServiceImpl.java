package com.govpoly.chardhamapis.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govpoly.chardhamapis.DTO.PlaceDTO;
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
    public Object getPlaceList(String names) {

        List<Tuple> placeData= placedao.getPlaceByName(names);
        
ArrayList<PlaceDTO> pArrayList=new ArrayList<>();
pArrayList.clear();
        for(Tuple tuple:placeData)
        {
                 PlaceDTO placeDTO=new PlaceDTO();
                 placeDTO.setId(tuple.get(0, Integer.class));
                 placeDTO.setName(tuple.get(6, String.class)); // it is used to display the context of place_name column.
                 placeDTO.setDescription(tuple.get(1, String.class));
                 placeDTO.setImages(tuple.get(2, String.class));
                 placeDTO.setLat(tuple.get(4, String.class));
                 placeDTO.setLongitute(tuple.get(5, String.class));

                 pArrayList.add(placeDTO);
        }

    
        
      return pArrayList;
    }

    /**
     * it is used to fetch the place by id 
     */
    @Override
    public Object getPlaceById(String id) {
    
        return this.placedao.findById(Integer.parseInt(id));
    }

}
