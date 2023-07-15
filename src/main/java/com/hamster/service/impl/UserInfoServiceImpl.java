package com.hamster.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hamster.entity.UserInfo;
import com.hamster.mapper.UserInfoMapper;
import com.hamster.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author 哈喽沃德
 * @version 1.0.0
 * @title UserInfoServiceImpl
 * @description <TODO description class purpose>
 * @createTime 2023/7/14 10:09
 **/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
}
