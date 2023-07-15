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
* @TableName t_classify_menu
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_classify_menu")
public class ClassifyMenu implements Serializable {

    /**
    * 
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 快捷菜单名
    */
    private String name;
    /**
    * 跳转地址
    */
    private String href;
    /**
    * 菜单图标
    */
    private String img;
    /**
    * 是否在首页上展示 1展示 0 不展示
    */
    private Integer isShow;
    /**
    * 
    */
    private Date createTime;
    /**
    * 
    */
    private Integer status;
}
