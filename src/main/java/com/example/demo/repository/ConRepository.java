package com.example.demo.repository;

import com.example.demo.domain.Connnect;
import com.example.demo.domain.InkScreen;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConRepository extends JpaRepository<Connnect,Integer> {

//    public  List<Connnect>findByUserId(Integer userId);
//    public List<Connnect>findByInkscreenId(Integer inkscreenId);
//
     public List<Connnect>findByUserIdName(Integer UserIdName);
    public List<Connnect>findByInkscreenIdName(Integer inkScreenIdName);

    public Connnect getByUserIdNameAndInkscreenIdName(Integer userIdName,Integer inkScreenName);


//    public  Connnect findByInkscreenId(Integer inkscreen);


}
