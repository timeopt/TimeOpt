package com.example.demo.Service;


import com.example.demo.Enums.ExceptionEnums;
import com.example.demo.Result.Result;
import com.example.demo.Util.Util;
import com.example.demo.domain.InkScreen;
import com.example.demo.domain.User;
import com.example.demo.repository.InkSreenRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InkSreenRepository inkSreenRepository;

    public void setNums(Integer id){
        User user=userRepository.findById(id).get();
        user.setInk_nums(user.getInkScreens().size());

    }

    public  void removeInk(Integer id,InkScreen inkScreen){
        User user=userRepository.findById(id).get();
        user.getInkScreens().remove(inkScreen);
        user.setInk_nums(user.getInkScreens().size());
    }


    public  void removeInk(User user,InkScreen inkScreen){
        user.getInkScreens().remove(inkScreen);
        user.setInk_nums(user.getInkScreens().size());
    }
    public  void addInk(Integer userId,Integer ink){
        InkScreen inkScreen= inkSreenRepository.findById(ink).get();
        User user=userRepository.findById(userId).get();
        user.getInkScreens().add(inkScreen);
        user.setInk_nums(user.getInkScreens().size());
    }
    public  void addInk(Integer userId,InkScreen inkScreen){
        User user=userRepository.findById(userId).get();
        user.getInkScreens().add(inkScreen);
        user.setInk_nums(user.getInkScreens().size());
    }

    public  void addInk(User user,InkScreen inkScreen){
        user.getInkScreens().add(inkScreen);
        user.setInk_nums(user.getInkScreens().size());
    }

    public Result findPassword(User user){

        User temp=userRepository.getByNameAndAndTelephone(user.getName(),user.getTelephone());
        if(temp==null){
            return  Util.failure(ExceptionEnums.USER_TEL_ERROR);
        }
        else {
            temp.setPassword(user.getPassword());
            return Util.success(temp);
        }

    }

    public  Result changePass(User user,String newPass){

        User temp=userRepository.getByNameAndPassword(user.getName(),user.getPassword());
        if(temp==null){
            return  Util.failure(ExceptionEnums.UNFIND_ERROR);
        }else {
            temp.setPassword(newPass);
            return Util.success(temp);
        }
    }






}
