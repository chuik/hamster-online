package com.hamster.controller;

import com.hamster.comment.RespBeanEnum;
import com.hamster.comment.ResultJson;
import com.hamster.entity.UserInfo;
import com.hamster.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public String login (String userName, String password, HttpServletRequest request) {
        return userInfoService.login(userName, password,request);
    }

    @PostMapping("/update")
    @ResponseBody
    public ResultJson update(UserInfo userInfo, HttpSession session){
        if (userInfoService.updateById(userInfo)){
            session.setAttribute("userInfo",userInfoService.getById(userInfo.getId()));;
            return ResultJson.success();
        }
        return ResultJson.error(RespBeanEnum.ERROR);
    }
}
