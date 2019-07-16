package com.example.demo.entity;


import javax.persistence.*;

@Entity
public class TShareEvent extends BaseEntity {

    private String eTitle;


    private  String descirption;

    private String imageURL;



    @ManyToOne(cascade = CascadeType.REFRESH,targetEntity = TUser.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private TUser tUser;

    public String geteTitle() {
        return eTitle;
    }

    public void seteTitle(String eTitle) {
        this.eTitle = eTitle;
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
