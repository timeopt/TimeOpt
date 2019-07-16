package com.example.demo.Service;


import com.example.demo.Enums.ExceptionEnums;
import com.example.demo.Exception.ClientException;
import com.example.demo.Result.Result;
import com.example.demo.Util.Util;
import com.example.demo.domain.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {


    @Autowired
    public ClientRepository clientRepository;



    @Transactional(rollbackFor = Exception.class)
    public void insertTwo() {



        Client clientA = new Client();
        clientA.setSex("E");
        clientA.setAge(8);
        clientRepository.save(clientA);

        Client clientB = new Client();
        clientB.setSex("DDDDDD");
        clientB.setAge(9);
        clientRepository.save(clientB);


    }


    public Result getAge(Integer id)throws  Exception{
        Client client = clientRepository.findById(id).get();

        Integer age= client.getAge();
        if(age<10){
            throw new ClientException(ExceptionEnums.PRIMAKET_SCHOOL);
        }else if(age>10&&age<16){

            throw new ClientException(ExceptionEnums.MIDDLE_SCHOOL);
        }else {

            return Util.success(client);

        }


    }
}