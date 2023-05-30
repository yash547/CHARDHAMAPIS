package com.govpoly.chardhamapis.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "FeedBackEntity")
public class FeedBackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "UserID")
    private String userid;

    @Column(name = "FeedBack")
    private String feedback;

<<<<<<< HEAD
    @Column(name ="Rating")
    private String rating;

=======
>>>>>>> e8ac33e6ab09b7684444fd98d80ce9e3ad560ec7
   
}
