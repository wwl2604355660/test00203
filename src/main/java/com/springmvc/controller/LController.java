package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
//计算两个复数,这个只是练习，不是真的题
@Controller
public class LController {

    @GetMapping("/add")
    public String add(HttpSession httpSession, @RequestParam("input1") String aa,
                      @RequestParam("input2") String bb,
                        @RequestParam("input3") String cc) {


        return "output";
    }
}
