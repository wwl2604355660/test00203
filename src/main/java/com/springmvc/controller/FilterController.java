package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilterController {

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filterNumbers(
            @RequestParam("start") int start,
            @RequestParam("end") int end,
            @RequestParam("condition") int condition,
            ModelMap model) {
        // 定义用于存储结果的列表
        List<Integer> filteredNumbers = new ArrayList<>();
        // 判断每个数是否满足条件，并将满足条件的数添加到列表中
        for (int i = start; i <= end; i++) {
            if (i % condition == 0 || i % 10 == condition) {
                filteredNumbers.add(i);
            }
        }
        // 将结果列表放入模型中，以便在 JSP 页面中显示
        model.addAttribute("filteredNumbers", filteredNumbers);
        // 跳转到结果页面
        return "output";
    }

}

