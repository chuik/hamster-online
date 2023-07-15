package com.hamster.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hamster.comment.RespBeanEnum;
import com.hamster.comment.ResultJson;
import com.hamster.entity.LiveInfo;
import com.hamster.mapper.LiveInfoMapper;
import com.hamster.service.LiveInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 哈喽沃德
 * @version 1.0.0
 * @title LiveInfoServiceImpl
 * @description <TODO description class purpose>
 * @createTime 2023/7/14 10:08
 **/
@Service
public class LiveInfoServiceImpl extends ServiceImpl<LiveInfoMapper, LiveInfo> implements LiveInfoService {
    @Override
    public ResultJson getLives() {
        List<LiveInfo> liveInfos = list(new QueryWrapper<LiveInfo>().eq("live_status",1));
        if (liveInfos==null|| liveInfos.size()<=0){
            return ResultJson.error(RespBeanEnum.CLASSIFY_MENU_NOT_FIND);
        }
        return ResultJson.success(liveInfos);
    }
}
