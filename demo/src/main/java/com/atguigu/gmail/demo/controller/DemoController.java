package com.atguigu.gmail.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

@Controller
public class DemoController {

    @GetMapping("/demo")
    @ResponseBody
    public String getHello() {
        ArrayList<Object> arrayList = new ArrayList<>();
        return "hello0925!!!!!";
    }

}
