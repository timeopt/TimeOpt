package com.example.demo.controller;


import com.example.demo.Result.Result;
import com.example.demo.Util.Util;
import com.example.demo.domain.Client;
import com.example.demo.Service.ClientService;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClientController {


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;
    @GetMapping(value = "/client/list")
    public  List<Client> girlList() {

        return clientRepository.findAll();
    }

    @PostMapping(value = "/client/post")
    public Result postmap(@Valid Client client, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return  Util.failure(1,bindingResult.getFieldError().getDefaultMessage());
        }
        client.setAge(client.getAge());
        client.setSex(client.getSex());
        return Util.success(clientRepository.save(client));

    }

    @GetMapping(value = "/client/{id}")
    public Client check(@PathVariable("id") Integer id){
        return  clientRepository.findById(id).get();
    }
    @GetMapping(value = "/client/age/{age}")
    public List<Client> check2(@PathVariable("age") Integer age){
        return  clientRepository.findByAge(age);
    }

    @PutMapping(value = "/girl/{id}")
    public Client putgirl(@PathVariable("id")Integer id , @RequestParam("cupSize") String cupSzie, @RequestParam("age") Integer age){

        Client temp=new Client();
        temp.setSex(cupSzie);
        temp.setAge(age);
        temp.setId(id);


      return clientRepository.save(temp);
    }

    @GetMapping(value = "/client/getAge/{id}")
    public  Result getAge(@PathVariable("id") Integer id )throws Exception{

         return  clientService.getAge(id);



    }

    @DeleteMapping(value = "/client/{id}")
    public void delete(@PathVariable("id" )Integer id){

        clientRepository.deleteById(id);
    }


    @PostMapping(value = "/client/two")
    public void insert(){
        clientService.insertTwo();
    }






}
