package com.dnp.ptt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController {


    @Autowired

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add() {
        return "From Service-A, Result is ";
    }

}