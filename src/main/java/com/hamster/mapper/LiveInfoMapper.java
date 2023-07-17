package com.hamster.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yulichang.base.MPJBaseMapper;
import com.hamster.entity.LiveInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LiveInfoMapper extends  MPJBaseMapper<LiveInfo> {
}
