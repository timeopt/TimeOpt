package com.example.demo.domain;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.NavigableMap;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer UserId;



    @Column(name = "username",unique = true)
    private  String name;

    @Column(name = "password")
    private String password;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Set<Connnect>connnects_user;



    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Set<InkScreen>inkScreens;




    @Column(name = "ink_nums")
    private  Integer ink_nums;


    @Column(name = "telephone")
    private  String telephone;

    public Set<Connnect> getConnnects_user() {
        return connnects_user;
    }

    public void setConnnects_user(Set<Connnect> connnects_user) {
        this.connnects_user = connnects_user;
    }

    public Set<InkScreen> getInkScreens() {
        return inkScreens;
    }

    public void setInkScreens(Set<InkScreen> inkScreens) {
        this.inkScreens = inkScreens;
    }

    public Integer getUserId() {
        return UserId;
    }



    public void setUserId(Integer userId) {
        UserId = userId;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public  User(){

    }
    public Integer getInk_nums() {
        return ink_nums;
    }

    public void setInk_nums(Integer ink_nums) {
        this.ink_nums = ink_nums;
    }

}
