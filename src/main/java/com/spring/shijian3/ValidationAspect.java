package com.spring.shijian3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
public class ValidationAspect {

    @Pointcut("execution(* com.spring.shijian3.Aop.Calculatorimpl.*(..)) && " +
            "!execution(* com.spring.shijian3.Aop.Calculatorimpl.getX()) && " +
            "!execution(* com.spring.shijian3.Aop.Calculatorimpl.getY())")
    public void pointCut(){

    }

    @Around("pointCut()")
    public float aroundLog(ProceedingJoinPoint joinPoint){

        try {
            Object[] args =  joinPoint.getArgs();
            System.out.println("调用的方法: " + joinPoint.getSignature().getName());
            System.out.println("相关的参数值: " + Arrays.toString(joinPoint.getArgs()));
            for (Object s : args){
                int a = (int) s;
                if (a == 0){
                    System.out.println("当前除数为0,请修改后重新计算");
                    return 0;
                }
            }
            System.out.println("运算结果:" + joinPoint.proceed());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
        }
        return 0;
    }
}
