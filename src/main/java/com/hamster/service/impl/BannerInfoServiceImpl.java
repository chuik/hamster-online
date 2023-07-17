package com.hamster.service.impl;

import com.github.yulichang.base.MPJBaseServiceImpl;
import com.hamster.comment.ResultJson;
import com.hamster.entity.BannerInfo;
import com.hamster.mapper.BannerInfoMapper;
import com.hamster.service.BannerInfoService;
import org.springframework.stereotype.Service;

/**
 * @author 哈喽沃德
 * @version 1.0.0
 * @title BannerInfoServiceImpl
 * @description <TODO description class purpose>
 * @createTime 2023/7/14 10:05
 **/
@Service
public class BannerInfoServiceImpl extends MPJBaseServiceImpl<BannerInfoMapper, BannerInfo> implements BannerInfoService {
    @Override
    public ResultJson bannerList() {
        return ResultJson.success(list());
    }
}
