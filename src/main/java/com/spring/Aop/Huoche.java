package com.spring.Aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Huoche {

   private String checi;
   private String beginAddress;

    public void a(){}

    public void b(){
        System.out.println("setter注入对象:车次:"+getCheci()+",出发地"+getBeginAddress());
    }

    public void c(){
        System.out.println("构造器注入对象:车次:"+getCheci()+",出发地"+getBeginAddress());
    }

    public void d(){
        System.out.println(getCheci()+"从"+getBeginAddress()+"出发");
    }

}

