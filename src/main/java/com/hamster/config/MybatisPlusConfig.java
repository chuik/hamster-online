package com.hamster.config;

import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.springframework.context.annotation.Bean;

public class MybatisPlusConfig {

    /**
     * 配置分页插件
     * @return page
     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor(){
//        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        // 开启 count 的 join 优化,只针对部分 left join
//        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
//        return paginationInterceptor;
//    }
}
