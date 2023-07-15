package com.hamster.controller;

import com.hamster.comment.ResultJson;
import com.hamster.service.LiveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/live")
public class LiveInfoController {


    @Autowired
    private LiveInfoService liveInfoService;

    @GetMapping ("/getLives")
    public ResultJson getLiveInfo(){
        return liveInfoService.getLives();
    }

}
