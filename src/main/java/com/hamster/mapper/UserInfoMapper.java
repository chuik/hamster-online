package com.hamster.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hamster.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
