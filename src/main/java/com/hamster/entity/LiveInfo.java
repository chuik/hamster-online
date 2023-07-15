package com.hamster.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.util.Date;

/**
* 
* @TableName t_live_info
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_live_info")
public class LiveInfo implements Serializable {

    /**
    * 
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 直播人ID
    */

    private Integer userId;
    /**
    * 标签
    */
    private String tag;
    /**
    * 直播状态  1在播  0离线 2回放
    */
    private Integer liveStatus;
    /**
    * 缩略图
    */
    private String thumbnail;
    /**
    * 直播间地址
    */
    private String href;
    /**
    * 
    */
    private Date createTime;
    /**
    * 是否有效 1正常  2 注销  3封禁
    */
    private Integer status;


    private Double visits;


    private String liveTitle;

}
