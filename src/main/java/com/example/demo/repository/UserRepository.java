package com.example.demo.repository;

import com.example.demo.domain.InkScreen;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User,Integer> {

    public List<User>findByName(String username);

    public List<User>findByPassword(String password);

    public List<User>findByTelephone(String telephone);

    int countByInkScreens(Set<InkScreen> inkScreens);

    public  User getByNameAndPassword(String username,String password);

    public  User getByNameAndAndTelephone(String username,String telephone);


}
