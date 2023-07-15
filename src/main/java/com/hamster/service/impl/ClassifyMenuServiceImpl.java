package com.hamster.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hamster.comment.RespBeanEnum;
import com.hamster.comment.ResultJson;
import com.hamster.entity.ClassifyMenu;
import com.hamster.mapper.ClassifyMenuMapper;
import com.hamster.service.ClassifyMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 哈喽沃德
 * @version 1.0.0
 * @title ClassifyNameService
 * @description <TODO description class purpose>
 * @createTime 2023/7/14 10:07
 **/
@Service
public class ClassifyMenuServiceImpl extends ServiceImpl<ClassifyMenuMapper, ClassifyMenu> implements ClassifyMenuService {
    @Override
    public ResultJson getMenus() {
        List<ClassifyMenu> menus =  list(new QueryWrapper<ClassifyMenu>().eq("is_show",1));
        if (menus == null || menus.size() <= 0){
            return ResultJson.error(RespBeanEnum.CLASSIFY_MENU_NOT_FIND);
        }
        return ResultJson.success(menus);
    }
}
