package com.example.demo.repository;

import com.example.demo.domain.InkScreen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface InkSreenRepository extends JpaRepository<InkScreen,Integer> {

    public List<InkScreen>findByScreenName(String screenname);

    public List<InkScreen>findByLocation(String location);

}
