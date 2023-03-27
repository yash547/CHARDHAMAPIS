package com.govpoly.chardhamapis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.govpoly.chardhamapis.Entity.RestaurentEntity;
import com.govpoly.chardhamapis.ServiceInterface.RestaurentServiceInterface;
/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */
@RestController
public class RestaurentController {

    @Autowired
    private RestaurentServiceInterface restaurentServiceInterface;

    @PostMapping("/createRestaurent")
    public Object createRestaurent(@RequestBody RestaurentEntity rsEntity) {

        return this.restaurentServiceInterface.createRestaurent(rsEntity);
    }

    @GetMapping("/getRestaurentList")
    public Object getRestaurentList() {
        return this.restaurentServiceInterface.getRestaurentList();
    }

}
