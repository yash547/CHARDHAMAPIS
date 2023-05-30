package com.govpoly.chardhamapis.ServiceImpl;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govpoly.chardhamapis.DTO.FeeBackListDTO;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

>>>>>>> e8ac33e6ab09b7684444fd98d80ce9e3ad560ec7
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
<<<<<<< HEAD

    @Override
    public Object getFeedback() {
        
        List<Tuple> feedData= feedBackDao.getFeedBackDetailsList();
        
ArrayList<FeeBackListDTO> fArrayList=new ArrayList<>();
fArrayList.clear();
        for(Tuple tuple:feedData)
        {
            FeeBackListDTO feedDTO=new FeeBackListDTO();
            
                 feedDTO.setName(tuple.get(0, String.class));
                 feedDTO.setDescription(tuple.get(1, String.class));
                 feedDTO.setRating(tuple.get(2, String.class));
                 fArrayList.add(feedDTO);
        }

      return fArrayList;
      
    }
=======
>>>>>>> e8ac33e6ab09b7684444fd98d80ce9e3ad560ec7
    
}
