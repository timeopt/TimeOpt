package com.example.demo.repository;

import com.example.demo.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Integer> {

public  List<Client>findByAge(Integer age);

}