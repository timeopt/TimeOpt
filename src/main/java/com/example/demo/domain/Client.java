package com.example.demo.domain;


import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Client {


    @Id
    @GeneratedValue
    private  Integer id;


    @Min(value = 18,message = "too young")
    private  Integer age;

    

    private String sex;


    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
