package com.govpoly.chardhamapis.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govpoly.chardhamapis.Dao.FeedBackDao;
import com.govpoly.chardhamapis.Entity.FeedBackEntity;
import com.govpoly.chardhamapis.ServiceInterface.FeedBackServiceInterface;

@Service
public class FeedBAckServiceImpl implements FeedBackServiceInterface{

    @Autowired
    private FeedBackDao feedBackDao;

    @Override
    public Object createFeedBack(FeedBackEntity feeBackEntity) {
        
        return this.feedBackDao.save(feeBackEntity);
    }
    
}
