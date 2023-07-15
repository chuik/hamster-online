package com.hamster.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hamster.comment.ResultJson;
import com.hamster.entity.ClassifyMenu;

/**
 * @author 哈喽沃德
 * @version 1.0.0
 * @title ClassifyMenuService
 * @description <TODO description class purpose>
 * @createTime 2023/7/14 10:05
 **/
public interface ClassifyMenuService extends IService<ClassifyMenu> {
    ResultJson getMenus();

}
