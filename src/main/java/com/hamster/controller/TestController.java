package com.hamster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("/goMinePage")
    public String goMinePage(){
        return "mine";
    }


    @RequestMapping("/CompressUpload")
    public String goCompressUpload(){
        return "compress_upload";
    }

    // QG开头的controller里也需要把网络地址改成live


    @RequestMapping("/live")
    public String live(){
        return "live";
    }


}
