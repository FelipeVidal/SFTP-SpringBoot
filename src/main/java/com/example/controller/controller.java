package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.cuv;
import com.example.services.SftpService;

@RestController
public class controller {
    @Autowired
    SftpService sftpService;

    @GetMapping(value = "cuv", produces = MediaType.APPLICATION_JSON_VALUE)
    public cuv getMethodName() {
        return sftpService.getCuv();
    }

}
