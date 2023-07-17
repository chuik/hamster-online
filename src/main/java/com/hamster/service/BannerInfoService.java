package com.hamster.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.yulichang.base.MPJBaseService;
import com.hamster.comment.ResultJson;
import com.hamster.entity.BannerInfo;

/**
 * @author 哈喽沃德
 * @version 1.0.0
 * @title BannerInfoService
 * @description <TODO description class purpose>
 * @createTime 2023/7/14 10:04
 **/
public interface BannerInfoService extends MPJBaseService<BannerInfo> {
    /**
     * 获取所有的Banner图
     * @return  java.util.List
     */
    ResultJson bannerList();
}
