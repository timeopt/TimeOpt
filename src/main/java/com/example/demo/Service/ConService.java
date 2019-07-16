package com.example.demo.Service;


import com.example.demo.Enums.ExceptionEnums;
import com.example.demo.Result.Result;
import com.example.demo.Util.Util;
import com.example.demo.domain.Connnect;
import com.example.demo.domain.InkScreen;
import com.example.demo.domain.User;
import com.example.demo.repository.ConRepository;
import com.example.demo.repository.InkSreenRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ParameterOutOfBoundsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InkSreenRepository inkSreenRepository;


    @Autowired
    private ConRepository conRepository;

    public void addCon(User user, InkScreen inkScreen) {
        Connnect connnect = new Connnect();
        user.getConnnects_user().add(connnect);
        inkScreen.getConnnects_inkscreen().add(connnect);
        conRepository.save(connnect);
    }

    public Result delCon(User user, InkScreen inkScreen){
        Integer userId=user.getUserId();
        Integer inkId=inkScreen.getInkId();
       Connnect temp=conRepository.getByUserIdNameAndInkscreenIdName(userId,inkId);
       if(temp==null)return Util.failure(ExceptionEnums.UNFIND_ERROR);
       else {
           conRepository.delete(temp);
           return Util.success(conRepository.findByUserIdName(userId));
       }
    }
    public Result delCon(Integer userId, Integer inkId){
        Connnect temp=conRepository.getByUserIdNameAndInkscreenIdName(userId,inkId);
        if(temp==null)return Util.failure(ExceptionEnums.UNFIND_ERROR);
        else {
            conRepository.delete(temp);
            return Util.success(conRepository.findByUserIdName(userId));
        }
    }


}
