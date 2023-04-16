package com.govpoly.chardhamapis.ServiceInterface;

import com.govpoly.chardhamapis.Entity.FeedBackEntity;

public interface FeedBackServiceInterface {
    
    public Object createFeedBack(FeedBackEntity feeBackEntity);

    public Object getFeedback();
}
