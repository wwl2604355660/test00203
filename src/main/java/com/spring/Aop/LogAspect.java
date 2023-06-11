package com.spring.Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.spring.Aop.Huoche.a(..))")
    public void pointCut(){

    }

    @Around("pointCut()")
    public float aroundLog(ProceedingJoinPoint joinPoint){

        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("时间:--yyyy年MM月dd日 HH:mm:ss");
            String[] weekDays = { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日" };
            // 获取当前时间
            LocalDateTime endDate = LocalDateTime.now();
            // 获取当前周
            Integer week = endDate.getDayOfWeek().getValue();
            System.out.println(dateFormat.format(date) + " " + weekDays[week - 1]);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
        }
        return 0;
    }
}
