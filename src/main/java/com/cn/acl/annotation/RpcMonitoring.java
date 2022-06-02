package com.cn.acl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.cn.acl.constant.RpcEnum;

/**
 * Rpc监控最佳实践
 * 打上该注解
 * 开启Feign监控（配置监控级别为Basic）
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RpcMonitoring {
    RpcEnum value();
}
