package com.spring.shijian3.Aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        Calculatorimpl cal = (Calculatorimpl) context.getBean(opration.class);

        cal.div(cal.getX(), cal.getY());
        cal.avg(cal.getX(), cal.getY());
        cal.max(cal.getX(), cal.getY());
    }
}
