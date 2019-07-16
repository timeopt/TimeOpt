package com.example.demo.domain;


import javax.persistence.*;

@Entity
@Table(name = "Conenct")
public class Connnect {


    @Id
    @GeneratedValue
    private Integer id;



//
//    @Column
//    private  Integer  UserId;
//
//
//    @Column
//    private Integer  InkScreen;

//
    @Column(name = "user")
    private Integer userIdName;


    @Column(name = "inkscreen")
    private Integer inkscreenIdName;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "User_id")
//    private  User User;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "InkScreen_id")
//    private  InkScreen inkScreen;


//    public Integer getUserId() {
//        return UserId;
//    }
//
//    public void setUserId(Integer userId) {
//        UserId = userId;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public com.example.demo.domain.User getUser() {
//        return User;
//    }
//
//    public void setUser(com.example.demo.domain.User user) {
//        User = user;
//    }
//
//    public InkScreen getInkScreen() {
//        return inkScreen;
//    }
//
//    public void setInkScreen(InkScreen inkScreen) {
//        this.inkScreen = inkScreen;
//    }



//    public Integer getInkscreenId() {
//        return InkscreenId;
//    }
//
//    public void setInkscreenId(Integer inkscreenId) {
//        InkscreenId = inkscreenId;
//    }


    public Integer getUserIdName() {
        return userIdName;
    }

    public void setUserIdName(Integer userIdName) {
        this.userIdName = userIdName;
    }

    public Integer getInkscreenIdName() {
        return inkscreenIdName;
    }

    public void setInkscreenIdName(Integer inkscreenIdName) {
        this.inkscreenIdName = inkscreenIdName;
    }
}
