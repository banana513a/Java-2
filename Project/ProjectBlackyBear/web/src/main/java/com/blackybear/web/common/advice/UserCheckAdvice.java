package com.blackybear.web.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Description: UserCheckAdvice
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2018-01-13
 */
@Slf4j
@Aspect
@Component
public class UserCheckAdvice {
    @Around(value = "execution(* com.blackybear.web.backend.TestService.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("======>before:{}", pjp.getArgs());
        Object result = pjp.proceed();
        log.info("======>after:{}", pjp.getKind());
        return result;
    }
}
