package com.spring.shijian3.Aop;

import com.spring.Aop.Huoche;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wwl
 * @create 2023-06-12 10:28
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        Calculatorimpl cal = (Calculatorimpl) context.getBean("aaa");
//        System.out.println("输入的两个数是"+cal.getX()+"\t"+cal.getY());
        cal.div(cal.getX(), cal.getY());
        cal.avg(cal.getX(), cal.getY());
        cal.max(cal.getX(), cal.getY());
    }
}
