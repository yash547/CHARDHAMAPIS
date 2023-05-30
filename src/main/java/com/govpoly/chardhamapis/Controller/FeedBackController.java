package com.govpoly.chardhamapis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
=======
>>>>>>> e8ac33e6ab09b7684444fd98d80ce9e3ad560ec7
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.govpoly.chardhamapis.Entity.FeedBackEntity;
import com.govpoly.chardhamapis.ServiceInterface.FeedBackServiceInterface;

@RestController
public class FeedBackController {

    @Autowired
    private FeedBackServiceInterface feeInterface;

    @PostMapping("/createFeedBack")
    public Object createFeedBack(@RequestBody FeedBackEntity feeBackEntity) {

        return this.feeInterface.createFeedBack(feeBackEntity);
    }
<<<<<<< HEAD


    
    @GetMapping("/getFeedBackList")
    public Object getFeedback() {
return this.feeInterface.getFeedback();
    }
=======
>>>>>>> e8ac33e6ab09b7684444fd98d80ce9e3ad560ec7
}
