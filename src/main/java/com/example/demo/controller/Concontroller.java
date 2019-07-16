package com.example.demo.controller;


import com.example.demo.Enums.ExceptionEnums;
import com.example.demo.Result.Result;
import com.example.demo.Service.ConService;
import com.example.demo.Util.Util;
import com.example.demo.domain.Connnect;
import com.example.demo.domain.InkScreen;
import com.example.demo.domain.User;
import com.example.demo.repository.ConRepository;
import com.example.demo.repository.InkSreenRepository;
import com.example.demo.repository.UserRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Concontroller {

    @Autowired
    private ConRepository conRepository;


    @Autowired
    private ConService conService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InkSreenRepository inkSreenRepository;

    @DeleteMapping(value = "/con/del/{id}")
    public Result delConById(@PathVariable("id") Integer id){
        Connnect connnect=conRepository.findById(id).get();
        if(connnect!=null){
            conRepository.deleteById(id);
            return Util.success(connnect);
        }else {
            return Util.failure(ExceptionEnums.UNFIND_ERROR);
        }
    }


    @DeleteMapping(value = "/con/del/user/ink")
    public Result delConByUI(@RequestParam("UserId")Integer UserId,@RequestParam("InkId")Integer InkId){

        return conService.delCon(UserId,InkId);
     }


     @GetMapping(value = "/con/get/{id}")
    public Result getCon(@PathVariable("id") Integer id){
        Connnect connnect=conRepository.findById(id).get();
        if(connnect==null)return  Util.failure(ExceptionEnums.UNFIND_ERROR);
        else return Util.success(connnect);
     }


}
