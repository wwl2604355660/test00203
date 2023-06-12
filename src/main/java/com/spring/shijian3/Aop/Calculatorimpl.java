package com.spring.shijian3.Aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@AllArgsConstructor
//@Component
public class Calculatorimpl implements opration{

    private float x;
    private float y;


    @Override
    public void BinocularOperation() {

    }

    @Override
    public void div(double a, double b) {
        if (y != 0){
            double m = x / y;
            System.out.println(m);
        }
    }

    @Override
    public void avg(double a, double b) {
        double m = (x+y)/2;
        System.out.println(m);
    }

    @Override
    public void max(double a, double b) {
        double m = Math.max(x,y);
        System.out.println(m);
    }

}

