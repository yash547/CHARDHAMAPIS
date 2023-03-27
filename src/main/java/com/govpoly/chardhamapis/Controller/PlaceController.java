package com.govpoly.chardhamapis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.govpoly.chardhamapis.Entity.PlaceEntity;
import com.govpoly.chardhamapis.ServiceImpl.PlaceServiceImpl;
import com.govpoly.chardhamapis.ServiceInterface.PlaceServiceInterface;

/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */
@RestController
public class PlaceController {

    @Autowired
    private PlaceServiceInterface placeServiceInterface;

    @PostMapping("/createPlace")
    public Object createPlace(@RequestBody PlaceEntity pEntity) {

        return this.placeServiceInterface.createPlace(pEntity);
    }

    @GetMapping("/getPlaceList")
    public Object getPlaceList() {

        return this.placeServiceInterface.getPlaceList();
    }

    @GetMapping("/getPlaceById={id}")
    public Object getPlaceById(@PathVariable String id) {

        return this.placeServiceInterface.getPlaceById(id);
    }

}
