package com.hamster.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.yulichang.base.MPJBaseService;
import com.hamster.comment.ResultJson;
import com.hamster.entity.LiveInfo;

/**
 * @author 哈喽沃德
 * @version 1.0.0
 * @title LiveInfoService
 * @description <TODO description class purpose>
 * @createTime 2023/7/14 10:06
 **/
public interface LiveInfoService extends MPJBaseService<LiveInfo> {

//    ResultJson getLives();
    ResultJson getLives(Integer pageIndex);

}
