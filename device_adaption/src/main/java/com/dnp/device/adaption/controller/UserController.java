package com.dnp.device.adaption.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-08 11:51
 */
@RestController
@RequestMapping("hellow")
public class UserController {

    @GetMapping("")
    public String getUserInfo() throws Exception {
        return "hello huazai";
    }
}
