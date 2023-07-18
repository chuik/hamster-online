package com.hamster.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.yulichang.base.MPJBaseMapper;
import com.github.yulichang.base.MPJBaseService;
import com.hamster.entity.UserInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 哈喽沃德
 * @version 1.0.0
 * @title UserInfoService
 * @description <TODO description class purpose>
 * @createTime 2023/7/14 10:06
 **/
public interface UserInfoService extends MPJBaseService<UserInfo> {
    String login(String userName, String password, HttpServletRequest request);
}
