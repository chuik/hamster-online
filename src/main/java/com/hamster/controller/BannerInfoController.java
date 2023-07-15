package com.hamster.controller;

import com.hamster.comment.ResultJson;
import com.hamster.service.BannerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
public class BannerInfoController {

    @Autowired
    private BannerInfoService bannerInfoService;


    @GetMapping("/list")
    public ResultJson bannerList(){
        return bannerInfoService.bannerList();
    }
}
