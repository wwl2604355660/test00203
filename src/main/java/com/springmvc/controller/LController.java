package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LController {

    @GetMapping("/add")
    public String add(HttpSession httpSession, @RequestParam("input1") String aa,
                      @RequestParam("input2") String bb) {


//        String input1 = (String) httpSession.getAttribute("input1");
//        String input2 = (String) httpSession.getAttribute("input2");


        String input1 = aa;
        String input2 = bb;


        System.out.println(input1.toString());
        String[] s1 = input1.split(" ");
        String[] s2 = input2.split(" ");

        int[] intArray1 = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            intArray1[i] = Integer.parseInt(s1[i]);
        }
        int[] intArray2 = new int[s2.length];
        for (int i = 0; i < s1.length; i++) {
            intArray2[i] = Integer.parseInt(s2[i]);
        }
        int addx = intArray1[0] + intArray2[0];
        int addy = intArray1[1] + intArray2[1];
        int subx = intArray1[0] - intArray2[0];
        int suby = intArray1[1] - intArray2[1];
        int mulx = intArray1[0] * intArray2[0] - intArray1[1] * intArray2[1];
        int muly = intArray1[0] * intArray2[1] + intArray2[0] * intArray1[1];
        int denominator = (int) (Math.pow(intArray2[1], 2) + Math.pow(intArray2[1], 2));
        int divx = (intArray1[0] * intArray2[0] + intArray1[1] * intArray2[1]) / denominator;
        int divy = (intArray1[1] * intArray2[0] - intArray1[0] * intArray2[1]) / denominator;

        httpSession.setAttribute("a1",addx);
        httpSession.setAttribute("a2",addy);
        httpSession.setAttribute("b1",subx);
        httpSession.setAttribute("b2",suby);
        httpSession.setAttribute("c1",mulx);
        httpSession.setAttribute("c2",muly);
        httpSession.setAttribute("d1",divx);
        httpSession.setAttribute("d2",divy);
        System.out.println("AAAAAAAAAAAAAAAAA");

        return "/input.jsp";
    }
}
