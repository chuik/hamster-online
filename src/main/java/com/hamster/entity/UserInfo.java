package com.hamster.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
* 
* @TableName t_user_info
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user_info")
public class UserInfo implements Serializable {

    /**
    * 
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 密码
    */

    private String password;
    /**
    * 昵称
    */
    private String nickName;

}
