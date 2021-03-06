package com.cn.acl.aspect;

import java.lang.reflect.Method;

import com.cn.acl.annotation.RpcMonitoring;
import com.cn.acl.common.Result;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Order(1)
@Component
public class RpcMonitoringAspect {
    /**
     * 打印Rpc入参出参与调用耗时
     * 上报调用耗时及错误率
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@annotation(rpcMonitoring)")
    public Object rpcMonitor(ProceedingJoinPoint pjp, RpcMonitoring rpcMonitoring) throws Throwable {
        Method method = getPjpMethod(pjp);
        StopWatch sw = new StopWatch();
        Object ret = null;
        try {
            sw.start();
            log.info("[{}#{}] ---> Args{}", method.getDeclaringClass().getName(), method.getName(), pjp.getArgs());
            ret = pjp.proceed();
            return ret;
        } finally {
            sw.stop();
            long time = sw.getTotalTimeMillis();
            log.info("[{}#{}] <--- Ret[{}] ({}ms)", method.getDeclaringClass().getName(), method.getName(), ret, time);
            // TODO 调用耗时上报
            boolean hasError = ret != null && ret instanceof Result && ((Result<?>) ret).getCode() != 0;
            if (hasError) {
                // TODO 错误上报
                log.info("{}调用失败", rpcMonitoring.value());
            }
        }
    }

    private Method getPjpMethod(ProceedingJoinPoint pjp) throws Throwable {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        return pjp.getTarget().getClass().getMethod(method.getName(), method.getParameterTypes());
    }
}
