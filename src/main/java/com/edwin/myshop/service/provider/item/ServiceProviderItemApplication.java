package com.edwin.myshop.service.provider.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
//扫描myshop-commons-mapper下的Mapper接口
@MapperScan(basePackages = "com.edwin.myshop.service.provider.item.maper")
//首先扫描自己的包，然后扫描commons-service 的组件包，用来配置swagger2配置
@ComponentScan(basePackages = {"com.edwin.myshop.service.provider.item","com.edwin.myshop.common.base","com.edwin.myshop.common.config"})
@EnableCaching//开启redis缓存
public class ServiceProviderItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderItemApplication.class, args);
    }

}
