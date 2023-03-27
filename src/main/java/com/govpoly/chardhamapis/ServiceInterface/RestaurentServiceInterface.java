package com.govpoly.chardhamapis.ServiceInterface;

import com.govpoly.chardhamapis.Entity.RestaurentEntity;
/**
 * 
 * 
 * @author Team CharDham Yatra Developer
 */
public interface RestaurentServiceInterface {

    public Object createRestaurent(RestaurentEntity rsEntity);

    public Object getRestaurentList();

}
