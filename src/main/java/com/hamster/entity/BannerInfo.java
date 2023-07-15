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
* @TableName t_banner_info
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_banner_info")
public class BannerInfo implements Serializable {

    /**
    * 
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 轮播图地址
    */

    private String url;
    /**
    * 跳转链接
    */

    private String href;
    /**
    * 备注
    */

    private String remark;
    /**
    * 创建时间
    */

    private Date createTime;
    /**
    * 是否有效 1正常 0无效
    */

    private Integer status;

    /**
    * 
    */


}
