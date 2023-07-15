package com.hamster.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 功能描述
 * @Author: Mr、LXH
 * @Date: 2022/12/4 22:18
 * This file was created in IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultJson {
    private long code;
    private String message;
    private Object data;

    /**
     * 成功返回结果
     */
    public static ResultJson success() {
        return new ResultJson(RespBeanEnum.SUCCESS.getCode(),
                RespBeanEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回结果
     *
     * @param data
     */
    public static ResultJson success(Object data) {
        return new ResultJson(RespBeanEnum.SUCCESS.getCode(),
                RespBeanEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 失败返回结果
     *
     * @param respBeanEnum
     * @return
     */
    public static ResultJson error(RespBeanEnum respBeanEnum) {
        return new ResultJson(respBeanEnum.getCode(), respBeanEnum.getMessage(),
                null);
    }
}