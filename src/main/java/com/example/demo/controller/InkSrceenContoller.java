package com.example.demo.controller;


import com.example.demo.Enums.ExceptionEnums;
import com.example.demo.Result.Result;
import com.example.demo.Service.ConService;
import com.example.demo.Service.UserService;
import com.example.demo.Util.Util;
import com.example.demo.domain.InkScreen;
import com.example.demo.domain.User;
import com.example.demo.repository.InkSreenRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.PostUpdate;
import java.util.Date;
import java.util.List;

@RestController
public class InkSrceenContoller {

    @Autowired
    private InkSreenRepository inkSreenRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ConService conService;


    @PostMapping(value = "/ink/add")
    public Result addInkScreen(InkScreen inkScreen, @RequestParam(name = "picture",required = false)MultipartFile picture,@RequestParam(name = "user_id",required = false)Integer id)throws Exception{
        Date date=new Date();
        inkScreen.setScreenName(inkScreen.getScreenName());
        inkScreen.setLocation(inkScreen.getLocation());
        inkScreen.setCreateDatetime(date);
        inkScreen.setUpdateTime(date);
        if(picture==null){
            inkScreen.setPicture(null);
        }else {
            inkScreen.setPicture(picture.getBytes());
        }

        User user=userRepository.findById(id).get();

        user.getInkScreens().add(inkScreen);

        if(userRepository.save(user)!=null){
            inkScreen.setValue(inkScreen.isValue());
            userService.setNums(id);
            conService.addCon(user,inkScreen);
            return Util.success(inkSreenRepository.save(inkScreen));
        }
        else {
            return Util.failure(ExceptionEnums.UNFIND_ERROR);
        }

    }


    @GetMapping(value = "/ink/get/{id}")
    public Result getInkById(@PathVariable("id") Integer id ){
        InkScreen inkScreen=inkSreenRepository.findById(id).get();
        if(inkScreen==null){
            return Util.failure(ExceptionEnums.UNFIND_ERROR);
        }else {
            return Util.success(inkScreen);
        }
    }


    @PostMapping(value = "/post/get/name")
    public Result getInkByName(@RequestParam("name") String screenName){

        List<InkScreen> inkScreenList=inkSreenRepository.findByScreenName(screenName);

        if(inkScreenList.size()==0)return Util.failure(ExceptionEnums.UNFIND_ERROR);
        else {
            return Util.success(inkScreenList);
        }
    }



    @PostMapping(value = "/post/get/location")
    public Result getInkByLocation(@RequestParam("location") String location){

        List<InkScreen> inkScreenList=inkSreenRepository.findByLocation(location);

        if(inkScreenList.size()==0)return Util.failure(ExceptionEnums.UNFIND_ERROR);
        else {
            return Util.success(inkScreenList);
        }
    }






    @DeleteMapping(value = "/del/ink/{id}")
    public  void delInkScreen(@PathVariable("id") Integer id,@RequestParam("user_id")Integer userId){
        inkSreenRepository.deleteById(id);
        userService.removeInk(userId,inkSreenRepository.findById(id).get());

    }


    @PutMapping(value = "update/inks/{id}")
    public Result updateInks(@PathVariable("id")Integer id,@RequestParam(name = "picture",required = false)MultipartFile picture ,InkScreen inkScreen)throws  Exception{
        InkScreen ink=inkSreenRepository.findById(id).get();

        if(ink==null)return Util.failure(ExceptionEnums.UNFIND_ERROR);
        Date date=new Date();
        ink.setValue(inkScreen.isValue());
        ink.setUpdateTime(date);
        ink.setLocation(inkScreen.getLocation());
        ink.setScreenName(inkScreen.getScreenName());
        if(picture!=null) ink.setPicture(picture.getBytes());
        return Util.success(inkSreenRepository.save(ink));

    }



}
