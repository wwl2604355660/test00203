package com.spring.Aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wwl
 * @create 2023-05-04 15:52
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        Huoche huoche = (Huoche) context.getBean("huoche1");
//        System.out.println(huoche.toString());
//        System.out.print("setter注入对象:车次:"+huoche.getCheci()+",出发地"+huoche.getBeginAddress());
        huoche.b();
        huoche.a();
        huoche.d();

        Huoche huoche1 = (Huoche) context.getBean("huoche2");
        huoche1.c();
        huoche1.a();
        huoche1.d();
    }
}
