package com.hamster.controller;

import com.hamster.comment.ResultJson;
import com.hamster.service.ClassifyMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classify")
public class ClassifyMenuController {

    @Autowired
    private ClassifyMenuService classifyMenuService;


    @GetMapping("/getMenus")
    public ResultJson getMenus(){
        return classifyMenuService.getMenus();
    }
}
