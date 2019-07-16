package com.example.demo.Service;


import com.example.demo.repository.InkSreenRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InkService {

    @Autowired
    private InkSreenRepository inkSreenRepository;



    @Autowired
    private UserRepository userRepository;





}
