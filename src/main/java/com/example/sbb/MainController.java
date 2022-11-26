package com.example.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/sbb")
    @ResponseBody
    public static String index() {
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/")
    public String root() {
        return "redirect:/question";
    }
}
