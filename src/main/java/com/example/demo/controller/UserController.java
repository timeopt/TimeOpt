package com.example.demo.controller;


import com.example.demo.Enums.ExceptionEnums;
import com.example.demo.Result.Result;
import com.example.demo.Service.UserService;
import com.example.demo.Util.Util;
import com.example.demo.domain.User;
import com.example.demo.repository.InkSreenRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserService userService;


    @Autowired
    private InkSreenRepository inkSreenRepository;



    @PostMapping(value = "/user/add")
    public Result addUser(User user){
        user.setName(user.getName());
        user.setPassword(user.getPassword());
        user.setTelephone(user.getTelephone());
        user.setInk_nums(user.getInkScreens().size());
        return Util.success(userRepository.save(user));
    }


    @GetMapping(value = "/user/get/{id}")
    public Result getUser(@PathVariable("id") Integer id){

        User user=userRepository.findById(id).get();

        if(user==null){

            return Util.failure(ExceptionEnums.UNFIND_ERROR);
        }
        else return Util.success(user);
    }


    @PutMapping(value = "/user/put/id/{id}")
    public Result putUser(@PathVariable("id")Integer id,User user){
        user.setUserId(id);
        user.setName(user.getName());
        user.setTelephone(user.getTelephone());
        user.setPassword(user.getPassword());
        user.setInk_nums(user.getInkScreens().size());
        return Util.success(userRepository.save(user));
    }

    @DeleteMapping(value = "/user/del/{id}")
    public void delUser(@PathVariable("id") Integer id){

        userRepository.deleteById(id);
    }

    @PostMapping(value = "/user/login")
    public Result dologin(User user){
        User temp=userRepository.getByNameAndPassword(user.getName(),user.getPassword());
        if(temp==null)return  Util.failure(ExceptionEnums.PASS_ERROR);
        else  return Util.success(temp);
    }


    @PostMapping(value = "/user/login/findpass")
    public  Result doPassword(User user){
        return userService.findPassword(user);
    }

    @PostMapping(value = "/user/login/change")
    public  Result doChangePassword(User user,@RequestParam("newpass") String newPass ){
        return  userService.changePass(user,newPass);
    }



}
