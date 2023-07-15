package com.hamster.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @description 功能描述
 * @Author: Mr、LXH
 * @Date: 2022/12/4 22:17
 * This file was created in IntelliJ IDEA
 */
@ToString
@Getter
@AllArgsConstructor
public enum RespBeanEnum {
    //通用状态码
    SUCCESS(200, "success"),
    ERROR(500, "服务端异常"),
    //Token校验失败
    TOKEN_PARSE_ERROR(100100, "非法的令牌"),
    //Token失效
    TOKEN_INVALID(1001001, "令牌无效或已过期"),
    GET_OPENID_FAIL(100102, "获取openId失败，请重新授权"),
    BIND_ERROR(500212, "参数校验异常"),
    SAVE_USERINFO_ERR(100103, "保存用户信息失败"),
    UPLOAD_ERROR(5005001, "上传图片失败"),
    SAVE_COMMON_ADDRESS_ERR(5006001,"新增地址失败"),
    DEL_COMMON_ADDRESS_ERR(5006002, "删除地址失败"),
    UPDATE_COMMON_ADDRESS_ERR(5006003, "修改地址失败"),
    REVERSE_ADDRESS_ERROR(600100,"逆向地址解析失败" ), CLASSIFY_MENU_NOT_FIND(30001,"查询菜单异常" );
    private final Integer code;
    private final String message;
}
