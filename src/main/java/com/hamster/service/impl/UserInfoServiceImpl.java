package com.hamster.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.base.MPJBaseMapper;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.hamster.entity.UserInfo;
import com.hamster.mapper.UserInfoMapper;
import com.hamster.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 哈喽沃德
 * @version 1.0.0
 * @title UserInfoServiceImpl
 * @description <TODO description class purpose>
 * @createTime 2023/7/14 10:09
 **/
@Service
public class UserInfoServiceImpl extends MPJBaseServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Override
    public String login(String userName, String password, HttpServletRequest request) {
       UserInfo userInfo =  getOne(new QueryWrapper<UserInfo>().eq("user_name", userName).eq("password", password));
        request.getSession().setAttribute("userInfo",userInfo);
        return "home";
    }
}
