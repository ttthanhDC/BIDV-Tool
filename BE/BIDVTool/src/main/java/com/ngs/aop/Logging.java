package com.ngs.aop;

import com.ngs.request.UpdateApplicationRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Slf4j
@Component
public class Logging {

//    @Pointcut("execution(* com.ngs.controller.*.*(..))")
//    private void callControllerMethod(){
//    }
//
//    @Around("callControllerMethod() && args(..,request)")
//    public void logAroundFunction(ProceedingJoinPoint joinPoint, Object request) throws Exception{
//        Object[] args = joinPoint.getArgs();
//        Object aThis = joinPoint.getThis();
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        Class<?> aClass = request.getClass();
//        RequestBody annotation = method.getAnnotation(RequestBody.class);
//        log.info(args.toString());
//    }
}
