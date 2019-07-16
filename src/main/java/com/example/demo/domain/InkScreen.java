package com.example.demo.domain;


import javafx.stage.Screen;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "InkScreen")
public class InkScreen {

    @Id
    @GeneratedValue()
    @Column(name = "id")
    private  Integer InkId;

    @Column(name = "ScreenName")
    private String screenName;

    @Column(name = "location")
    private String location;

    @CreatedDate
    private Date createDatetime;

    @LastModifiedDate
    private Date updateTime;

//    @Lob
//    @Basic(fetch = FetchType.LAZY)
//    @Column(name=" company_logo", columnDefinition="longblob", nullable=true)
//    private byte[] CompanyLogo;
//    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "logo_picture" ,columnDefinition = "longblob",nullable = true)
    private  byte[] picture;

    @Column(name = "TF")
    private boolean value;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "inkScreen_id")
    private  Set<Connnect>connnects_inkscreen;

    public Set<Connnect> getConnnects_inkscreen() {
        return connnects_inkscreen;
    }



    public void setConnnects_inkscreen(Set<Connnect> connnects_inkscreen) {
        this.connnects_inkscreen = connnects_inkscreen;
    }



    public InkScreen() {
    }
    public Integer getInkId() {
        return InkId;
    }

    public void setInkId(Integer inkId) {
        InkId = inkId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public boolean isValue() {
        return value;
    }


    public void setValue(boolean value) {
        this.value = value;
    }
}
