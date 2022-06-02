package com.cn.acl.aspect;

import com.cn.acl.annotation.RpcResultHandler;
import com.cn.acl.common.Result;
import com.cn.acl.exception.ErrorCode;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(10)
@Aspect
@Component
public class RpcResultHandlerAspect {
    @Around("@annotation(rpcResultHandler)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, RpcResultHandler rpcResultHandler) {
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            ErrorCode errorCode = rpcResultHandler.value();
            log.error(errorCode.getMsg(), e);
            return Result.fail(errorCode);
        }
    }
}
