package com.govpoly.chardhamapis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


    
    @GetMapping("/getFeedBackList")
    public Object getFeedback() {
return this.feeInterface.getFeedback();
    }
}
