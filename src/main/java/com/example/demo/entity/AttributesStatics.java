package com.example.demo.entity;


import lombok.Cleanup;

import javax.persistence.*;
import java.io.FileInputStream;

@Entity
public class AttributesStatics extends BaseEntity {



    @JoinColumn(name = "tuser_id",unique = true)
    @OneToOne(cascade = CascadeType.REFRESH,targetEntity = TUser.class)
    private  TUser tUser;

    @Column(unique = true,nullable = false)
    private  String username;

    @Column(nullable = false)
    private  Integer totalGrade;

    @Column(nullable = false)
    private Integer missTotalFinish;

    @Column(nullable = false)
    private Integer missTotalCreate;


    public TUser gettUser() {
        return tUser;
    }

    public void settUser(TUser tUser) {
        this.tUser = tUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(Integer totalGrade) {
        this.totalGrade = totalGrade;
    }

    public Integer getMissTotalFinish() {
        return missTotalFinish;
    }

    public void setMissTotalFinish(Integer missTotalFinish) {
        this.missTotalFinish = missTotalFinish;
    }

    public Integer getMissTotalCreate() {
        return missTotalCreate;
    }

    public void setMissTotalCreate(Integer missTotalCreate) {
        this.missTotalCreate = missTotalCreate;
    }
}
