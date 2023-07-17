package com.hamster.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.hamster.comment.RespBeanEnum;
import com.hamster.comment.ResultJson;
import com.hamster.entity.ClassifyMenu;
import com.hamster.entity.LiveInfo;
import com.hamster.entity.UserInfo;
import com.hamster.entity.vo.LiveInfoVo;
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
public class LiveInfoServiceImpl extends MPJBaseServiceImpl<LiveInfoMapper, LiveInfo> implements LiveInfoService {

//    @Override
//    public ResultJson getLives() {
//        List<LiveInfo> liveInfos = list(new QueryWrapper<LiveInfo>().eq("live_status",1));
//        if (liveInfos==null|| liveInfos.size()<=0){
//            return ResultJson.error(RespBeanEnum.CLASSIFY_MENU_NOT_FIND);
//        }
//        return ResultJson.success(liveInfos);
//    }

    @Override
    public ResultJson getLives(Integer pageIndex) {
        PageHelper.startPage(pageIndex,6);
        List<LiveInfoVo> liveInfoVos = selectJoinList(LiveInfoVo.class,
                new MPJLambdaWrapper<LiveInfo>()
                        .selectAll(LiveInfo.class)
                        .select(UserInfo::getNickName)
                        .select(UserInfo::getUserName)
                        .leftJoin(UserInfo.class,UserInfo::getId,LiveInfo::getUserId)
                        .eq(LiveInfo::getStatus,1)

                );
        return ResultJson.success(liveInfoVos);
    }


}
